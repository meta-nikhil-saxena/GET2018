package assignment4;

//class to set and retrieve information from database tables
public class DisplayCategory {

    private int id;
    private String name;
    private int count;

    public DisplayCategory(int id, String name, int count) {

        this.id = id;
        this.name = name;
        this.count = count;
    }

    // Getters and Setters STRAT
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
    // Getters END

}
