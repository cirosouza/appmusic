package br.edu.infnet.appmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppmusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppmusicApplication.class, args);
	}
}