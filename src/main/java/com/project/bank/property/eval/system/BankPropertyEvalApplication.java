package com.project.bank.property.eval.system;

import com.project.bank.property.eval.system.configuration.JwtConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfigurations.class)
public class BankPropertyEvalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankPropertyEvalApplication.class, args);
	}

}
