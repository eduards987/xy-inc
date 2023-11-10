package com.poi.xyinc10.pointinterestrepositorytest;

import com.poi.xyinc10.PointInterest;
import com.poi.xyinc10.pointinterestrepository.PointInterestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PointInterestRepositoryTest {

    @Autowired
    private PointInterestRepository poiRepository;

    @MockBean
    private PointInterest mockPointInterest;

    @Test
    public void testFindByCoordenadaXBetweenAndCoordenadaYBetween() {
        int x1 = 10;
        int x2 = 20;
        int y1 = 30;
        int y2 = 40;

        when(poiRepository.findByCoordenadaXBetweenAndCoordenadaYBetween(x1, x2, y1, y2))
                .thenReturn(List.of(mockPointInterest));

        List<PointInterest> result = poiRepository.findByCoordenadaXBetweenAndCoordenadaYBetween(x1, x2, y1, y2);

        assertEquals(1, result.size());
        assertEquals(mockPointInterest, result.get(0));
    }
}
