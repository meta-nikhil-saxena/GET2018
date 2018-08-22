package assignment1;

//POJO class to store and retrieve table data from database
public class Orders {

    private int id;
    private String order_date;
    private int total_cost;

    // Constructor to initialize data from database table to local fields
    public Orders(int id, String order_date, int total_cost) {

        this.id = id;
        this.order_date = order_date;
        this.total_cost = total_cost;
    }

    // Getter and setters START
    public int getId() {
        return id;
    }

    public String getOrderdate() {
        return order_date;
    }

    public int getTotalcost() {
        return total_cost;
    }
    // Getter and Setter END
}
