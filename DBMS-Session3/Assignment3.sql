# 1 > Display Shopper’s information along with number of orders he/she placed during last 30 days.

SELECT u.id, u.name, u.email_id, u.dob, COUNT(o.id) AS order_count
FROM user AS u
INNER JOIN orderitem AS o
ON u.id = o.user_id
INNER JOIN orderproduct AS op
ON o.id = op.order_id
WHERE op.order_date > DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
GROUP BY o.user_id;

# 2 > Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.

SELECT u.id, u.name, u.email_id, SUM(p.cost * p.quantity) AS order_total
FROM user AS u
INNER JOIN orderitem AS o 
ON u.id = o.user_id
INNER JOIN orderproduct AS p 
ON o.id = p.order_id
WHERE o.order_date > DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
GROUP BY u.id
ORDER BY order_total DESC
LIMIT 10;

# 3 > Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT p.name, SUM(o.quantity) AS product_count
FROM product as p
INNER JOIN orderproduct AS o 
ON o.product_id = p.id
WHERE o.order_date > DATE_SUB(CURDATE(), INTERVAL 60 DAY) 
GROUP BY p.id
ORDER BY product_count DESC
LIMIT 20;

# 4 > Display Monthly sales revenue of the StoreFront for last 6 months. 
# It should display each month’s sale.

SELECT MONTHNAME(o.order_date) AS month_name, SUM(p.cost * op.quantity) AS order_total
FROM orderitem AS o
INNER JOIN orderproduct AS op 
ON o.id = op.order_id
INNER JOIN product AS p 
ON p.id = op.product_id
WHERE o.order_date > DATE_SUB(CURDATE(), INTERVAL 6 MONTH) 
GROUP BY MONTH(o.order_date);

# 5 > Mark the products as Inactive which are not ordered in last 90 days.

UPDATE product AS p
SET p.status = 'Inactive'
WHERE p.id Not IN(
                        SELECT product_id
                        FROM orderproduct AS opr                
                        WHERE opr.order_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
                       );
                       
SELECT * FROM product;              

#6 > Given a category search keyword, display all the Products present in this category/categories. 

SELECT p.name AS product_name
FROM product AS p
LEFT JOIN productlist AS pl 
ON p.id = pl.product_id
LEFT JOIN category AS c 
ON pl.category_id = c.id
WHERE c.name IN ('ELECTRONICS');

#7 > Display top 10 Items which were cancelled most.

SELECT p.name, COUNT(*) AS cancelled_count
FROM orderproduct AS op
INNER JOIN product AS p
ON p.id = op.product_id
WHERE op.status = 'cancelled'
GROUP BY op.product_id
ORDER BY cancelled_count DESC
LIMIT 10;