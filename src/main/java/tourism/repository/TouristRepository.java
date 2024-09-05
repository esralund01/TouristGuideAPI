package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        populateAttractions();
    }

    private void populateAttractions() {
        attractions.add(new TouristAttraction("Den lille havfrue",
                "Den lille havfrue er en skulptur på Langelinie i København. Den illustrerer H.C. Andersens eventyr Den lille Havfrue."));
        attractions.add(new TouristAttraction("Tivoli",
                "Tivoli er et overflødighedshorn af oplevelser, fra vilde forlystelser til gode middage og store koncerter, og et must for alle, der besøger København."));
        attractions.add(new TouristAttraction("Rundetårn",
                "Christian IV og Tycho Brahes Rundetaarn er Europas ældste fungerende observatorium."));

    }

    public TouristAttraction findAttractionByName(String name){
        for(TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction){
        attractions.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction updateAttraction(String name, String newName, String newDescription){
        for(TouristAttraction attraction : attractions){
            if(attraction.getName().equalsIgnoreCase(name)){
                attraction.setName(newName);
                attraction.setDescription(newDescription);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name){
        TouristAttraction attractionToDelete = null;
        for(TouristAttraction attraction : attractions){
            if(attraction.getName().equalsIgnoreCase(name)){
                attractionToDelete = attraction;
            }
        }
        if(attractionToDelete != null){
            attractions.remove(attractionToDelete);
            return attractionToDelete;
            }
        return null;
    }

}
