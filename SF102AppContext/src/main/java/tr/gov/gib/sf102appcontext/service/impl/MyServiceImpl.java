package tr.gov.gib.sf102appcontext.service.impl;

import tr.gov.gib.sf102appcontext.service.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void printMessage() {
        System.out.println("Merhaba , Spring Boot");
    }
   /* public void printMessage(){
        System.out.println("Merhaba , Spring Boot");
    }*/
}
