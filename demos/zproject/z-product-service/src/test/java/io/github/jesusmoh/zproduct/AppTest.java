
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import com.google.gson.Gson;

import io.github.jesusmoh.zproduct.config.CustomTestListener;
import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import static us.abstracta.jmeter.javadsl.JmeterDsl.htmlReporter;
import static us.abstracta.jmeter.javadsl.JmeterDsl.httpSampler;
import static us.abstracta.jmeter.javadsl.JmeterDsl.testPlan;
import static us.abstracta.jmeter.javadsl.JmeterDsl.threadGroup;
import us.abstracta.jmeter.javadsl.core.TestPlanStats;

@ExtendWith(CustomTestListener.class)
@Slf4j
public class AppTest {

    private static Random rand = new Random();
    private static final String DOCKER_COMPOSE_FILE_PATH = "docker/compose/full/docker-compose.yml";
    private static final DockerComposeContainer environment = new DockerComposeContainer(
            new File(DOCKER_COMPOSE_FILE_PATH))
            .withExposedService("java_app", 8081, Wait.forHttp("/ping"))
            .withExposedService("mongodb", 27017);

    // Docker enviroment start and stop

    @BeforeAll
    @DisplayName("power on doker-compose enviroment")
    public static void setup() {
        environment.start();
    }

    @AfterAll
    @DisplayName("power off doker-compose enviroment")
    public static void teardown() {
        environment.stop();
    }

    // Perfomance Tests

    @DisplayName("performanceTestJMeter")
    @Test
    public void performanceTest() throws IOException {
        TestPlanStats stats = testPlan(
                threadGroup(2, 2, httpSampler("http://localhost:8081/ping")),
                htmlReporter("target/jmeter-reports/ping-jmeter-results")).run();
        log.error("performanceTestJMeter?");
        assertThat(stats.overall().sampleTimePercentile99()).isLessThan(Duration.ofSeconds(5));
    }

    @Test
    public void testPing() throws IOException {
        String url = "http://localhost:8081/ping";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        int statusCode = response.statusCode();
        String responseBody = response.body();

        // Add your assertions here based on the response
        assertEquals(200, statusCode);
        assertTrue(responseBody.contains("pong"));
    }

    // Rest API test
    @DisplayName("createProduct")
    @Test
    public void testCreateProduct() {
        String url = "http://localhost:8081/api/products";
        HttpClient client = HttpClient.newHttpClient();

        int stock = rand.nextInt();
        boolean status = rand.nextBoolean();
        var json = """
                {
                     "id": "2222",
                     "name": "NewProduct",
                     "description": "This is a sample product description.",
                     "price": 29.99,
                     "stock": %s,
                     "status": %s
                 }
                 """.formatted(stock, status);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
        }
        int statusCode = response.statusCode();
        String responseBody = response.body();
        log.info("<-> " + json);
        log.info("<-> " + responseBody);
        assertEquals(200, statusCode);
        assertTrue(responseBody.contains("NewProduct"));
    }

    // Rest API test
    @DisplayName("createProductRandomAndValidatorLayer")
    @Test
    public void testCreateProductRandomAndValidatorLayer() {
        String url = "http://localhost:8081/api/products";
        HttpClient client = HttpClient.newHttpClient();

        ProductDTO dto = Instancio.of(ProductDTO.class).create();

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(
                        json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
        }
        int statusCode = response.statusCode();
        String responseBody = response.body();

        log.info("<-> " + json);
        log.info("<-> " + responseBody);
        assertEquals(422, statusCode);
        assertTrue(responseBody.contains("doesn't have a correct value"));
    }

}