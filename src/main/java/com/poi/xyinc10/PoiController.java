package com.poi.xyinc10;

import com.poi.xyinc10.pointinterestrepository.PointInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/coordenada")
@RestController
public class PoiController {

    @Autowired
    private PointInterestRepository poiRepository;

    @PostMapping()
    public ResponseEntity<Void> cadastrarPOI(@RequestBody PointInterest poi){
        poiRepository.save(poi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


     @GetMapping("/")
    public List<PointInterest>listarpointinterest(

            @RequestParam (name = "coordenadaX", required = false) String coordenadaX,
            @RequestParam (name = "coordenadaY", required = false) String coordenadaY,
            @RequestParam (name = "dMax", required = false) String dMax
    ) {
         if (coordenadaX != null & coordenadaY != null & dMax != null) {
             int x = Integer.parseInt(coordenadaX);
             int y = Integer.parseInt(coordenadaY);
             int max = Integer.parseInt(dMax);

             int x1 = x - max;
             int x2 = x + max;
             int y1 = y - max;
             int y2 = y + max;

             return poiRepository.findByCoordenadaXBetweenAndCoordenadaYBetween(x1, x2, y1, y2);
         }
         return poiRepository.findAll();
     }

    @DeleteMapping("/{id")
    public void excluirpointinterest(@PathVariable Long id){
        poiRepository.deleteById(id);
    }

}
