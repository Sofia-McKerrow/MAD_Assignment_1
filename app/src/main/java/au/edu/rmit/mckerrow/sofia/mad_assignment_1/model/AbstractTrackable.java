package au.edu.rmit.mckerrow.sofia.mad_assignment_1.model;

public abstract class AbstractTrackable implements Trackable {

    private int trackableID;
    private String name;
    private String description;
    private String url;
    private String category;

    public AbstractTrackable(int trackableID, String name, String description, String url, String category) {
        this.trackableID = trackableID;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
    }

    public int getTrackableID() {
        return trackableID;
    }

    public void setTrackableID(int trackableID) {
        this.trackableID = trackableID;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "AbstractTrackable{" +
                "trackableID=" + trackableID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
