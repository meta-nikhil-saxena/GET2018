package assignment4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import queries.Queries;
import connection.ConnectionFactory;

public class DisplayParentOperation {
    /**
     * Function to display category from database tables
     * 
     * @return list of selected items
     */
    public List<DisplayCategory> displayCategory() {

        List<DisplayCategory> listOfCategory = new ArrayList<DisplayCategory>();

        try {
            Connection connection = ConnectionFactory.getConnection();

            PreparedStatement statement = connection
                    .prepareStatement(Queries.displayCategoryQuery);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                
                int id = result.getInt("id");
                String name = result.getString("name");
                int count = result.getInt("count");

                DisplayCategory display = new DisplayCategory(id, name, count);
                listOfCategory.add(display);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfCategory;
    }
}
