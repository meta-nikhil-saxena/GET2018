package assignment2;

//POJO class to store and retrieve data 
public class InsertImages {
    private int id;
    private String name;
    private String url;

    // Constructor to initialize data in local fields
    public InsertImages(int id, String name, String url) {

        this.id = id;
        this.name = name;
        this.url = url;
    }

    // Getters and Setters START
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    // Getters and Setters END

}
