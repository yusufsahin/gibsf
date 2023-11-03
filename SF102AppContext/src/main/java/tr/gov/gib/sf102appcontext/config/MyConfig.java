package tr.gov.gib.sf102appcontext.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.gov.gib.sf102appcontext.service.impl.MyServiceImpl;

@Configuration
public class MyConfig {
    @Bean
    public MyServiceImpl  myServiceImp()
    {
        return  new MyServiceImpl();
    }
}
