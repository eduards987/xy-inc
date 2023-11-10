package com.poi.xyinc10.pointinterestrepository;


import com.poi.xyinc10.PointInterest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public interface PointInterestRepository extends JpaRepository<PointInterest, Long> {
    List<PointInterest> findByCoordenadaXBetweenAndCoordenadaYBetween(int x1, int x2, int y1, int y2);

}
