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

//Class to perform operation on database table
public class OrderOperation {
    List<Orders> orderlist = new ArrayList<Orders>();
    Connection connection;

    /**
     * Function to operate and perform operation,execute query in database table
     * 
     * @param userid
     * @return List from database table
     */
    public List<Orders> getOrderData(int userid) {

        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement query = connection
                    .prepareStatement(Queries.querySelect);

            query.setInt(1, userid);

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");

            ResultSet resultset = query.executeQuery();

            while (resultset.next()) {

                int id = resultset.getInt("order_id");
                Timestamp date = resultset.getTimestamp("order_date");
                int cost = resultset.getInt("total_cost");

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
}
