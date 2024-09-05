package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.findAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newAttraction = touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction updatedAttraction = touristService.updateAttraction
                (touristAttraction.getName(),
                        touristAttraction.getName(),
                        touristAttraction.getDescription());
        if (updatedAttraction != null) {
            return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@RequestBody String name) {
        TouristAttraction deletedAttraction = touristService.deleteAttraction(name);
        if (deletedAttraction != null) {
            return new ResponseEntity<>(deletedAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
