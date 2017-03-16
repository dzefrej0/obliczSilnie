package com.eonetworks;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SilniaApplicationTests {
    SilniaService silniaService = new SilniaService();

    @Test
    public void ShouldReturnRightNumberRecursion() throws Exception {
        int a = 12;
        BigInteger silnia = silniaService.obliczSilniaRekurencja(a);
        assertEquals(silnia.intValue(), 479001600);

    }

    @Test
    public void shouldReturnRightNumberIterating() throws Exception {

        BigInteger silnia1 = silniaService.liczIteracja(12);
        assertEquals(silnia1.intValue(), 479001600);
    }
}