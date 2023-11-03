package com.example.sf300springtest;

import com.example.sf300springtest.di.Araba;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class Sf300SpringTestApplicationTests {

    @Autowired
    private Araba araba;

    @MockBean
    private Araba mockAraba;

    @Test
    void contextLoads() {
    }

    @Test
    void arabaBaslatIsCalled(){
        araba.baslat();

        Mockito.verify(mockAraba,Mockito.times(1)).baslat();
    }
}
