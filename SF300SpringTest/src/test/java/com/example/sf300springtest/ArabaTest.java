package com.example.sf300springtest;

import com.example.sf300springtest.di.Araba;
import com.example.sf300springtest.di.Motor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArabaTest {

    @Test
    public void baslatTest()
    {
        Motor mockMotor= new Motor("Benzinli");
        Araba araba= new Araba(mockMotor);

        assertNotNull(araba);

    }
}
