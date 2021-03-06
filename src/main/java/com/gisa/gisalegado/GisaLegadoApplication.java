package com.gisa.gisalegado;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication(scanBasePackages = "com.gisa")
public class GisaLegadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GisaLegadoApplication.class, args);
	}

}
