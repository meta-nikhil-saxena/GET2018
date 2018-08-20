use storefront;

INSERT INTO orderitem(User_ID)
                    VALUES
                    (1),
                    (2),
                    (3),
                    (4),
                    (5),
                    (6),
                    (7);
                    
SELECT * FROM orderitem; 

INSERT INTO orderproduct(order_id,product_id,shippingaddress,cost,quantity,status)
                    VALUES
                    (1,1,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (2,2,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (3,3,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (4,4,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (5,5,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (6,6,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (7,7,'Udaipur',5000,5,'SHIPPED');
                    
INSERT INTO orderproduct(Order_ID,Product_ID,ShippingAddress,Cost,Quantity,Status)
                    VALUES
                    (1,2,'Jaipur',5000,5,'NOT-SHIPPED'),
                    (2,2,'Udaipur',50000,25,'NOT-SHIPPED'),
                    (3,3,'Jaipur',15000,5,'NOT-SHIPPED'),
                    (4,6,'Aligarh',2000,35,'NOT-SHIPPED'),
                    (5,7,'Jodhpur',51000,15,'NOT-SHIPPED'),
                    (6,6,'Agra',90000,1,'NOT-SHIPPED');                    
                    
                    
SELECT * FROM orderproduct;   

CREATE VIEW billing
AS
SELECT u.id AS user_id,o.id AS order_id, p.id AS product_id, p.name AS product_name, opr.quantity, p.cost, 
       u.name AS username, u.email_id, opr.order_date, opr.status,SUM(opr.quantity*p.cost) AS order_total
FROM orderitem AS o
INNER JOIN orderproduct AS opr ON o.id = opr.order_id
INNER JOIN product AS p ON opr.product_id = p.id
INNER JOIN user AS u ON u.id = o.user_id
GROUP BY o.id;

SELECT * FROM billing;

DROP VIEW billing;

# 1 > Display Recent 5 Orders placed (Id, Order Date, Order Total).

SELECT op.order_id,op.order_date,
op.cost*op.quantity As totalcost
FROM orderproduct op
INNER JOIN orderitem p
ON p.id = op.order_id
ORDER BY order_date DESC
LIMIT 5;

# 2 > Display 10 most expensive Orders.

SELECT op.order_id,op.order_date,
op.cost*op.quantity As totalcost
FROM orderproduct op
INNER JOIN orderitem p
ON p.id = op.Order_ID
ORDER BY totalcost DESC
LIMIT 5;

#3 > Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.

SELECT DISTINCT op.order_id,op.product_id 
FROM orderitem o
JOIN orderproduct op
ON op.order_id = o.id
WHERE DATE(o.order_date) <= CURDATE() - 10  
AND status = 'NOT-SHIPPED';

#4 > Display list of shoppers which haven't ordered anything since last month.

SELECT name
FROM user
WHERE id 
NOT IN (SELECT user_id FROM orderitem WHERE DATE(order_date) < CURDATE()-30);

#5 > Display list of shopper along with orders placed by them in last 15 days. 

SELECT name
FROM user
WHERE id 
IN (SELECT user_id FROM orderitem WHERE DATE(order_date) > CURDATE()-15);

#6 > Display list of order items which are in “shipped” state for particular Order Id )

SELECT p.Name
FROM orderproduct o
JOIN product p
ON p.id = o.product_id
WHERE o.order_id = 7 
AND o.status = 'SHIPPED';

#7 > Display list of order items along with order placed date which fall between Rs 200 to Rs 500 price.

SELECT DISTINCT p.name, o.order_date
FROM product p 
JOIN orderitem o 
JOIN orderproduct po
ON p.id = po.product_id
WHERE p.cost BETWEEN 200 AND 500;

# 8 > Update first 20 Order items status to “Shipped” which are placed today.

UPDATE orderproduct 
SET status = 'SHIPPED'
WHERE DATE(order_date) = CURDATE()
ORDER BY order_date
LIMIT 10;

SELECT * FROM orderproduct;
