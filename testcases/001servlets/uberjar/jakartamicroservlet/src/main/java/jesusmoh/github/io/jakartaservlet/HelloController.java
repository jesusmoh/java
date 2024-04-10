package jesusmoh.github.io.jakartaservlet;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * to start java -jar jakartaservlet-microbundle.jar
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello World";
    }
}
