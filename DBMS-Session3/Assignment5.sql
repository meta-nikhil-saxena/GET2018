/*
1 >

Create a view displaying the order information 
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
with latest ordered items should be displayed first for last 60 days.

*/

CREATE VIEW order_information
AS
SELECT o.id AS order_id, p.id AS product_id, p.name AS product_name, opr.quantity, p.cost, 
       u.name AS username, u.email_id, opr.order_date, opr.status
FROM orderitem AS o
INNER JOIN orderproduct AS opr ON o.id = opr.order_id
INNER JOIN product AS p ON opr.product_id = p.id
INNER JOIN user AS u ON u.id = o.user_id
WHERE o.order_date > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY o.order_date DESC;

SELECT * FROM order_information;

# 2 > Use the above view to display the Products(Items) which are in ‘shipped’ state.

SELECT DISTINCT product_name
FROM order_information
WHERE status = 'shipped';

# 3 > Use the above view to display the top 5 most selling products.

Select product_name, SUM(quantity) AS product_sold
FROM order_information
GROUP BY product_id
ORDER BY product_sold DESC
LIMIT 5;