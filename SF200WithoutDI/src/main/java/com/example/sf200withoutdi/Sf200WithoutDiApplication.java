package com.example.sf200withoutdi;

import com.example.sf200withoutdi.di.Araba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sf200WithoutDiApplication {

    public static void main(String[] args) {

        //SpringApplication.run(Sf200WithoutDiApplication.class, args);

        Araba araba= new Araba();
        araba.baslat();
    }

}
