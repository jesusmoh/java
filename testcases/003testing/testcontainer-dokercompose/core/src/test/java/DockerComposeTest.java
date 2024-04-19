import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.containsString;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static io.restassured.RestAssured.given;

public class DockerComposeTest {

    private static final String DOCKER_COMPOSE_FILE_PATH = "docker-compose.yml";

    @BeforeClass
    public static void setup() {
        environment.start();
    }

    private static final DockerComposeContainer environment = new DockerComposeContainer(
            new File(DOCKER_COMPOSE_FILE_PATH))
            .withExposedService("test_service", 8080, Wait.forHttp("/"));

    @AfterClass
    public static void teardown() {
        environment.stop();
    }

    @Test
    public void testServiceIsRunning() {
        given().when()
                .get("http://localhost:8080")
                .then()
                .statusCode(200)
                .body(containsString("Welcome to nginx"));
    }
}