package com.example.sf300springtest;

import com.example.sf300springtest.di.Motor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotorTest {
    @Test
    public  void tipGetirTest(){
        Motor motor =new  Motor("Benzinli");
        assertEquals("Benzinli",motor.tipGetir());
        Motor motor2 =new  Motor("Elektrikli");
        assertEquals("Elektrikli",motor2.tipGetir());

    }
}
