package assignment1;

import connection.*;
import queries.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderOperation {
    List<Orders> orderlist = new ArrayList<Orders>();
    Connection connection;

    public List<Orders> getOrderData(int userid) {

        try {
            connection = ConnectionFactory.getConnection();
            System.out.println(Queries.queryAssignment1);
            PreparedStatement query = connection
                    .prepareStatement(Queries.queryAssignment1);

            // query.setString(1,"Shipped");
            query.setInt(1, userid);

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");

            ResultSet resultset = query.executeQuery();

            while (resultset.next()) {

                int id = resultset.getInt("order_id");
                Timestamp date = resultset.getTimestamp("order_date");
                int cost = resultset.getInt("total_cost");

                System.out.println("id : " + id + "  date :" + date
                        + "  cost : " + cost);

                Orders order = new Orders(id, sdf.format(date), cost);
                orderlist.add(order);

            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }

        return orderlist;
    }

    public static void main(String args[]) {
        OrderOperation obj = new OrderOperation();
        System.out.println(obj.getOrderData(1) + "   " + obj.orderlist.size());
    }

}
