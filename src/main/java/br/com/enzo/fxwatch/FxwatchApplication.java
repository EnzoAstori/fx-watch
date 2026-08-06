package br.com.enzo.fxwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FxwatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxwatchApplication.class, args);
	}

}
