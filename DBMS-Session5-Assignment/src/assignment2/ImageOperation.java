package assignment2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import queries.Queries;

import connection.ConnectionFactory;

public class ImageOperation {

    /**
     * Function to insert image in the image table
     * 
     * @param product_id
     * @param listimages
     * @return length of rows inserted
     */
    public int insert(int product_id, List<InsertImages> listimages) {
        Connection connection;
        int rowlength = 0;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement(Queries.queryInsert);

            connection.setAutoCommit(false);

            // Inserting image data in image table
            for (int i = 0; i < listimages.size(); i++) {

                statement.setInt(1, product_id);
                statement.setString(2, listimages.get(i).getName());
                statement.setString(3, listimages.get(i).getUrl());

                statement.addBatch();
            }

            rowlength = statement.executeBatch().length;
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowlength;
    }
}
