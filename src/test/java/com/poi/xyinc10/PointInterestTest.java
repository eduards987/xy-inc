package com.poi.xyinc10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointInterestTest {

    @Test
    public void testGetAndSetNome() {
        PointInterest poi = new PointInterest();
        poi.setNome("Test POI");
        assertEquals("Test POI", poi.getNome());
    }

    @Test
    public void testGetAndSetCoordenadaX() {
        PointInterest poi = new PointInterest();
        poi.setCoordenadaX(10);
        assertEquals(10, poi.getCoordenadaX());
    }

    @Test
    public void testGetAndSetCoordenadaY() {
        PointInterest poi = new PointInterest();
        poi.setCoordenadaY(20);
        assertEquals(20, poi.getCoordenadaY());
    }
}
