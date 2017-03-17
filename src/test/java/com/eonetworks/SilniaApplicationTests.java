package com.eonetworks;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SilniaApplicationTests {
    SilniaService silniaService = new SilniaService();

    @Test
    public void ShouldReturnRightNumberRecursion() throws Exception {
        //given
        int a = 12;
        //when
        BigInteger silnia = silniaService.obliczSilniaRekurencja(a);
        //then
        assertEquals(silnia.intValue(), 479001600);

    }

    @Test
    public void shouldReturnRightNumberIterating() throws Exception {
        //given
        int a = 12;
        //when
        BigInteger silnia1 = silniaService.liczIteracja(a);
        //then
        assertEquals(silnia1.intValue(), 479001600);
    }
}