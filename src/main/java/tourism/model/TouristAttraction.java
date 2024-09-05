package tourism.model;

public class TouristAttraction {
    private String name;
    private String description;

    public TouristAttraction() {
    }

    public TouristAttraction(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
