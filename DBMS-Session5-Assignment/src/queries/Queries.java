package queries;

public class Queries {
    
      public static String queryAssignment1 = "SELECT op.order_id,o.order_date,SUM(p.cost*op.quantity) AS total_cost "
                                        +"FROM orderitem o "
                                        +"INNER JOIN orderproduct op "
                                        +"ON op.order_id = o.id "
                                        +"INNER JOIN product p "
                                        +"ON p.id = op.product_id "
                                        +"WHERE op.status LIKE \'%Shipped%\'  "
                                        +"AND o.user_id = ? "
                                        +"GROUP BY op.order_id ";
}
