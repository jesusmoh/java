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
import static junit.framework.TestCase.assertEquals;
import lombok.extern.slf4j.Slf4j;
import us.abstracta.jmeter.javadsl.JmeterDsl;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

@ExtendWith(CustomTestListener.class)
@Slf4j
public class AppSuiteTest {

    // Data generation
    private static final Random rand = new Random();

    // Docker enviroment
    private static final String DOCKER_IMAGE = "img/z-product-service-1-0-0-staged";
    private static final String DOCKER_FILE = "docker/dockerfile/Dockerfile.staged";
    private static final String DOCKER_COMPOSE_FILE_PATH = "docker/compose/zproductservicecompose/docker-compose.yml";
    private static final String MONGO_SERVICE_NAME = "mongodb";
    private static final int MONGO_SERVICE_NAME_PORT = 27017;
    private static final String JAVA_SERVICE_NAME = "nginx";
    private static final int JAVA_SERVICE_NAME_PORT = 9081;

    // Url
    private static final String HTTP = "http://";
    private static final String HOST = "localhost";
    private static final String HOST_PORT = HOST + ":" + JAVA_SERVICE_NAME_PORT;
    private static final String PATH_PING = "/ping";
    private static final String PATH_PRODUCTS = "/api/products";
    private static final String URL_PING = HTTP.concat(HOST_PORT).concat(PATH_PING);
    private static final String URL_PRODUCTS = HTTP.concat(HOST_PORT).concat(PATH_PRODUCTS);

    private static final DockerComposeContainer environment = new DockerComposeContainer(
            new File(DOCKER_COMPOSE_FILE_PATH))
            .withExposedService(JAVA_SERVICE_NAME, JAVA_SERVICE_NAME_PORT, Wait.forHttp(PATH_PING))
            .withExposedService(MONGO_SERVICE_NAME, MONGO_SERVICE_NAME_PORT);

    @BeforeAll
    @DisplayName("Build Docker image and start Docker Compose environment")
    public static void setup() {
        buildDockerImage();
        startDockerComposeEnvironment();

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
            Thread.sleep(11000); // optional: sleep for a short period
        } catch (IOException | InterruptedException e) {
            log.error("An error occurred: {}", e.getMessage());
        }
    }

    private static void startDockerComposeEnvironment() {
        environment.start();
    }

    @DisplayName("Performance Test: Ping with JMeter")
    @Test
    @Order(1)
    void performanceTestPingJMeter() throws IOException {
        TestPlanStats stats = JmeterDsl.testPlan(
                JmeterDsl.threadGroup(2, 2, JmeterDsl.httpSampler(URL_PING)),
                JmeterDsl.htmlReporter("target/jmeter-reports/ping-jmeter-results")).run();
        log.error("Performance Test with JMeter");
        assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
    }

    @DisplayName("REST API Test: Ping")
    @Test
    @Order(2)
    void testPing() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_PING))
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
    @RepeatedTest(value = 3, name = "{displayName}{currentRepetition}/{totalRepetitions}")
    void testCreateProduct() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        int id = rand.nextInt(30, 300);
        int skuCode = rand.nextInt(342, 678);
        float price = (skuCode * 0.5f) + 23.2f;
        boolean status = rand.nextBoolean();
        String json = String.format("""
                {
                    "id": %s,
                    "skuCode": %s,
                    "name": "NewProduct",
                    "description": "This is a sample product description.",
                    "price": %s,
                    "status": %s
                }
                """, id, skuCode, price, status);
        log.info("<-> {}", json);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_PRODUCTS))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String responseBody = response.body();
        log.info("<-> {}", responseBody);
        assertEquals(200, statusCode);
        assertTrue(responseBody.contains("NewProduct"));
    }

    @DisplayName("Create Product Random and Validate Layer")
    @Test
    @Order(4)
    void testCreateProductRandomAndValidatorLayer() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ProductDTO dto = Instancio.of(ProductDTO.class).create(); // Assuming ProductDTO has default constructor
        Gson gson = new Gson();
        String json = gson.toJson(dto);
        log.info("<-> " + json);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_PRODUCTS))
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

}