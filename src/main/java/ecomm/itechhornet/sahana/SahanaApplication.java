package ecomm.itechhornet.sahana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SahanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SahanaApplication.class, args);
	}

}
