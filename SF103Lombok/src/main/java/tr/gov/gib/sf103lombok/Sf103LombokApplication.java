package tr.gov.gib.sf103lombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.gov.gib.sf103lombok.dao.entity.Mukellef;

@SpringBootApplication
public class Sf103LombokApplication {

    public static void main(String[] args) {
        Mukellef mukellef= new Mukellef();
        mukellef.setAd("Test");
        mukellef.setSoyad("TestSoyad");
        mukellef.setVKN("1111111112");

        Mukellef mukellef2= new Mukellef("111111114","Test2","TestSoyisim");

        SpringApplication.run(Sf103LombokApplication.class, args);
    }

}
