package micro.publico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@EnableHystrixDashboard
@RestController
@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "modelo" , "modelo.auth"})
@ComponentScan({"micro.publico", "steger.excepciones"})
@EnableJpaRepositories({ "dao" , "dao.auth" })
public class MicroPublicoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MicroPublicoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MicroPublicoApplication.class);
	}

	@GetMapping("/heartbit")
	public ResponseEntity<String> getUser() {
		return new ResponseEntity<String>("IM OK", HttpStatus.OK);
	}
	
}
