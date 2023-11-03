package tr.gov.gib.sf102appcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tr.gov.gib.sf102appcontext.service.impl.MyServiceImpl;

@SpringBootApplication
public class Sf102AppContextApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext contex= SpringApplication.run(Sf102AppContextApplication.class);

        MyServiceImpl myService= contex.getBean(MyServiceImpl.class);
        myService.printMessage();
    }

}
