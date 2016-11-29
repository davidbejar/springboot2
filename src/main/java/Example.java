import org.apache.catalina.util.ServerInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {

	/**
	 * inner class for output json
	 *
	 * @author davidbejar
	 *
	 */
	class SpringPojo {
		/**
		 * @return the springBootVersion
		 */
		public String getSpringBootVersion() {
			return springBootVersion;
		}

		/**
		 * @return the springFrameworkVersion
		 */
		public String getSpringFrameworkVersion() {
			return springFrameworkVersion;
		}

		/**
		 * @return the tomcatServerInfo
		 */
		public String getTomcatServerInfo() {
			return tomcatServerInfo;
		}

		/**
		 * @return the tomcatVersion
		 */
		public String getTomcatVersion() {
			return tomcatVersion;
		}

		/**
		 * @return the tomcatBuilt
		 */
		public String getTomcatBuilt() {
			return tomcatBuilt;
		}

		String springBootVersion;
		String springFrameworkVersion;
		String tomcatServerInfo;
		String tomcatVersion;
		String tomcatBuilt;

	}

	@RequestMapping("/")
	SpringPojo home() {
		SpringPojo springPojo = new SpringPojo();
		springPojo.springBootVersion = SpringBootVersion.getVersion();
		springPojo.springFrameworkVersion = SpringVersion.getVersion();
		springPojo.tomcatServerInfo = ServerInfo.getServerInfo();
		springPojo.tomcatVersion = ServerInfo.getServerNumber();
		springPojo.tomcatBuilt = ServerInfo.getServerBuilt();
		return springPojo;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

}
