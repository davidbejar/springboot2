import org.eclipse.jetty.util.Jetty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {

	@RequestMapping("/")
	String home() {
		return new StringBuilder("Running Spring Boot version: ").append(SpringBootVersion.getVersion())
				.append(" , Spring Framework version: ").append(SpringVersion.getVersion())
				.append(" and Jetty version: ").append(Jetty.VERSION).toString();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

}
