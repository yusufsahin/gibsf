package com.example.sf300springtest;

import com.example.sf300springtest.di.Araba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Sf300SpringTestApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(Sf300SpringTestApplication.class);
        Araba araba = context.getBean(Araba.class);
        araba.baslat();
    }

}
