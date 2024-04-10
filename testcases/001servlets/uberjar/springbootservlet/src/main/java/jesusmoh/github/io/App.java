package jesusmoh.github.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
@SpringBootApplication
public class App {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello, this is a Spring Boot servlet!";
	}

	@Bean
	public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<>(dispatcherServlet);
		registration.addUrlMappings("/servlet/*");
		return registration;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
