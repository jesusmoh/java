package io.github.jesusmoh.zproduct;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import com.google.gson.Gson;

import io.github.jesusmoh.zproduct.config.CustomTestListener;
import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.services.validations.RangeValidator;
import lombok.extern.slf4j.Slf4j;
import static us.abstracta.jmeter.javadsl.JmeterDsl.htmlReporter;
import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;
import static us.abstracta.jmeter.javadsl.JmeterDsl.testPlan;
import static us.abstracta.jmeter.javadsl.JmeterDsl.threadGroup;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

@ExtendWith(CustomTestListener.class)
@Slf4j
public class AppTest {

    private static final Random rand = new Random();
    private static RangeValidator cut;
    private static final String DOCKER_IMAGE = "img/z-product-service-1-0-0";
    private static final String DOCKER_FILE = "docker/Dockerfile.simple";
    private static final String DOCKER_COMPOSE_FILE_PATH = "docker/compose/full/docker-compose.yml";
    private static final String MONGO_SERVICE_NAME = "mongodb";
    private static final int MONGO_SERVICE_NAME_PORT = 27017;
    private static final String JAVA_SERVICE_NAME = "java_app";
    private static final int JAVA_SERVICE_NAME_PORT = 8081;
    private static final DockerComposeContainer environment = new DockerComposeContainer(
            new File(DOCKER_COMPOSE_FILE_PATH))
            .withExposedService(JAVA_SERVICE_NAME, JAVA_SERVICE_NAME_PORT, Wait.forHttp("/ping"))
            .withExposedService(MONGO_SERVICE_NAME, MONGO_SERVICE_NAME_PORT);

    @BeforeAll
    @DisplayName("Build Docker image and start Docker Compose environment")
    public static void setup() {
        buildDockerImage();
        startDockerComposeEnvironment();
        cut = new RangeValidator();
    }

    @AfterAll
    @DisplayName("Stop Docker Compose environment")
    public static void teardown() {
        environment.stop();
    }

    private static void buildDockerImage() {
        ProcessBuilder pb = new ProcessBuilder("docker", "build", "-f", DOCKER_FILE, "-t", DOCKER_IMAGE, ".");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            pb.start();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        try {
            Thread.sleep(8000); // optional: sleep for a short period
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private static void startDockerComposeEnvironment() {
        environment.start();
    }

    @DisplayName("Performance Test: Ping with JMeter")
    @Test
    @Order(1)
    void performanceTestPingJMeter() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(2, 2, httpSampler("http://localhost:8081/ping")),
                htmlReporter("target/jmeter-reports/ping-jmeter-results")).run();
        log.error("Performance Test with JMeter");
        assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
    }

    @DisplayName("REST API Test: Ping")
    @Test
    @Order(2)
    void testPing() throws IOException, InterruptedException {
        String url = "http://localhost:8081/ping";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String responseBody = response.body();

        assertEquals(200, statusCode);
        assertTrue(responseBody.contains("pong"));
    }

    @DisplayName("REST API Test: Create Product")
    @Test
    @Order(3)
    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void testCreateProduct() throws IOException, InterruptedException {
        String url = "http://localhost:8081/api/products";
        HttpClient client = HttpClient.newHttpClient();

        int stock = rand.nextInt();
        int id = rand.nextInt(3423, 6789);
        boolean status = rand.nextBoolean();
        String json = String.format("""
                {
                     "id": %s,
                     "name": "NewProduct",
                     "description": "This is a sample product description.",
                     "price": 29.99,
                     "stock": %s,
                     "status": %s
                 }
                 """, id, stock, status);
        log.info("<-> " + json);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String responseBody = response.body();
        log.info("<-> " + responseBody);
        assertEquals(200, statusCode);
        assertTrue(responseBody.contains("NewProduct"));
    }

    @DisplayName("Create Product Random and Validate Layer")
    @Test
    @Order(4)
    void testCreateProductRandomAndValidatorLayer() throws IOException, InterruptedException {
        String url = "http://localhost:8081/api/products";
        HttpClient client = HttpClient.newHttpClient();

        ProductDTO dto = Instancio.of(ProductDTO.class).create(); // Assuming ProductDTO has default constructor

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        log.info("<-> " + json);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String responseBody = response.body();
        log.info("<-> " + responseBody);
        assertEquals(422, statusCode);
        assertTrue(responseBody.contains("doesn't have a correct value"));
    }

    @Test
    @DisplayName("Should return true given 50")
    void fifty_isValid_returnsTrue() {
        assertThat(cut.isValid(50)).isTrue();
    }

    @Test
    @DisplayName("Should return false given 200")
    void twoHundred_isValid_returnsFalse() {
        assertThat(cut.isValid(200)).isFalse();
    }

    @Test
    @DisplayName("Should return true given 100")
    void hundred_isValid_returnsTrue() {
        assertThat(cut.isValid(100)).isTrue();
    }

    @Test
    @DisplayName("Should return false given 0")
    void zero_isValid_returnsFalse() {
        assertThat(cut.isValid(0)).isFalse();
    }
}
