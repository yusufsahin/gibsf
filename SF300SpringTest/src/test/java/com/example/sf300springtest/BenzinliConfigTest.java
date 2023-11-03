package com.example.sf300springtest;

import com.example.sf300springtest.di.Motor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("benzinli")
public class BenzinliConfigTest {
    @Autowired
    private Motor motor;
    @Test
    public void  benzinliMotorTest()
    {
        assertEquals("Benzinli",motor.tipGetir());
    }
}
