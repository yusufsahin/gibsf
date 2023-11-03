package tr.gov.gib.HellopSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellopSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HellopSpringApplication.class, args);
		System.out.println("Hello Spring!");
	}

}
