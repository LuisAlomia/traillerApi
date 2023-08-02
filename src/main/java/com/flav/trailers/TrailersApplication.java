package com.flav.trailers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class TrailersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrailersApplication.class, args);
	}

}
