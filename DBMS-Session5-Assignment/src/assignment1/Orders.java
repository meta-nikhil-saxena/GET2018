package assignment1;


public class Orders {
      
    private int id;
    private String orderdate;
    private int totalcost;

    public Orders(int id, String orderdate, int totalcost) {
        
        this.id = id;
        this.orderdate = orderdate;
        this.totalcost = totalcost;
        
    }

    public int getId() {
        return id;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public int getTotalcost() {
        return totalcost;
    }

}
