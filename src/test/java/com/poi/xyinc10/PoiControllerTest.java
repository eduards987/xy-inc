package com.poi.xyinc10;


import com.poi.xyinc10.pointinterestrepository.PointInterestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(PoiController.class)
public class PoiControllerTest {
    @InjectMocks
    PoiController poiController;

    @Autowired
    @MockBean
    private PointInterestRepository poiRepository;

 /*   @BeforeEach
    public void setup() {
        poiRepository = Mockito.mock(PointInterestRepository.class);
        poiController = new PoiController();
        poiController.setPoiRepository(poiRepository);
    }*/

    @Test
    public void testCadastrarPOI() {
        PointInterest poi = new PointInterest();
        ResponseEntity<Void> response = poiController.cadastrarPOI(poi);

        Mockito.verify(poiRepository, Mockito.times(1)).save(poi);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testListarpointinterestprox() {
        List<PointInterest> mockPois = new ArrayList<>();
        Mockito.when(poiRepository.findAll()).thenReturn(mockPois);

        List<PointInterest> result = poiController.listarpointinterest(null, null, null);

        Mockito.verify(poiRepository, Mockito.times(1)).findAll();
        assertEquals(mockPois, result);
    }

    @Test
    public void testListarpointinterestproxWithParams() {
        int x = 10;
        int y = 20;
        int dMax = 30;

        List<PointInterest> mockPois = new ArrayList<>();
        Mockito.when(poiRepository.findByCoordenadaXBetweenAndCoordenadaYBetween(0, 40, -10, 50)).thenReturn(mockPois);

        List<PointInterest> result = poiController.listarpointinterest(Integer.toString(x), Integer.toString(y), Integer.toString(dMax));

        Mockito.verify(poiRepository, Mockito.times(1)).findByCoordenadaXBetweenAndCoordenadaYBetween(0, 40, -10, 50);
        assertEquals(mockPois, result);
    }

    @Test
    public void testExcluirpointinterest() {
        poiController.excluirpointinterest(1L);

        Mockito.verify(poiRepository, Mockito.times(1)).deleteById(1L);
    }
}
