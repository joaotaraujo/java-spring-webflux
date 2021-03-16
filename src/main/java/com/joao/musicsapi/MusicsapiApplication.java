package com.joao.musicsapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class MusicsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicsapiApplication.class, args);
		System.out.println("Exemplo de projeto com webflux!");
	}

}
