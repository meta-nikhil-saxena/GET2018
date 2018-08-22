package assignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;

import queries.Queries;
import connection.ConnectionFactory;

public class UpdateOperation {

    /**
     * Function to delete product from product table in database
     * 
     * @param id
     * @return number of product deleted
     */
    public int deleteproduct() {
        int numberOfProductDeleted = 0;
        try {
            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement statement = connection
                    .prepareStatement(Queries.update);

            numberOfProductDeleted = statement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfProductDeleted;
    }
}
