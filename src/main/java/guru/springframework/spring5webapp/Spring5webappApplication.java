package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Spring5webappApplication {

	@GetMapping
	public String message(){
		return "Welcome to GTech first Jenkins project...";
	}

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}
