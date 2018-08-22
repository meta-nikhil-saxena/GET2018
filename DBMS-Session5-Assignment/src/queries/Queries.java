package queries;

//Class to store queries to be execute in the database 
public class Queries {

    // Select query to select items from database
    /**
     * Q-1 Given the id of a user, fetch all orders (Id, Order Date, Order
     * Total) of that user which are in shipped state. Orders should be sorted
     * by order date column in chronological order.
     */
    public static String querySelect = "SELECT op.order_id,o.order_date,SUM(p.cost*op.quantity) AS total_cost "
            + "FROM orderitem o "
            + "INNER JOIN orderproduct op "
            + "ON op.order_id = o.id "
            + "INNER JOIN product p "
            + "ON p.id = op.product_id "
            + "WHERE op.status IN('SHIPPED') "
            + "AND o.user_id = ? GROUP BY op.order_id DESC";

    // Insert query to insert images
    /**
     * Q-2 Insert five or more images of a product using batch insert technique.
     */
    public static String queryInsert = "INSERT INTO image(product_id,name,image)VALUES(?,?,?)";

    // delete query to update products
    /**
     * Q-3 Update all those products which were not ordered by any Shopper as Inactive in
     * last 1 year. Return the number of products updated.
     */
    public static String update = "UPDATE product p SET p.status = 'Inactive' "
            + "WHERE p.id NOT IN ( SELECT DISTINCT product_id "
            + "FROM orderproduct "
            + "WHERE order_date > DATE_SUB(CURDATE(), INTERVAL 1 YEAR) ) "
            + "AND p.date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) ";

    // select query to display category
    /**
     * Q-4 Select and display the category title of all top parent categories
     * sorted alphabetically and the count of their child categories.
     */
    public static String displayCategoryQuery = " SELECT C.id ,C.name,COUNT(C.id) as count "
            + "FROM category C LEFT JOIN category P "
            + "ON P.parent_id = C.id WHERE P.parent_id IN "
            + "(SELECT id FROM category WHERE parent_id IS NULL) "
            + "GROUP BY C.id ORDER BY name ";

}
