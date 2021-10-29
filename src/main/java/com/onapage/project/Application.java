package com.onapage.project;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;
@SpringBootApplication
@EnableSwagger2Doc
public class Application {
	public static void main(String[] args) {
	    SpringApplication.run(Application.class, args);
    }
}
