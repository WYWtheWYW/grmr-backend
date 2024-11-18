package wow.grmr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GrmrApplication {
	public static void main(String[] args) {
		SpringApplication.run(GrmrApplication.class, args);
	}
}