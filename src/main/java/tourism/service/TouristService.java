package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addAttraction(touristAttraction);
    }

    public TouristAttraction findAttractionByName(String name){
        return touristRepository.findAttractionByName(name);
    }

    public TouristAttraction updateAttraction(String name, String newName, String newDescription){
        return touristRepository.updateAttraction(name,newName,newDescription);
    }

    public TouristAttraction deleteAttraction(String name){
        return touristRepository.deleteAttraction(name);
    }


}
