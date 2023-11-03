package com.example.sf210config;

import com.example.sf210config.di.Araba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sf210ConfigApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(Sf210ConfigApplication.class);

        Araba araba= context.getBean(Araba.class);
        araba.baslat();
    }

}
