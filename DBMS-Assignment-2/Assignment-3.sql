use storefront;

insert into orderitem(Order_ID,User_ID)
                    VALUES
                    ('O1','U1'),
                    ('O2','U2'),
                    ('O3','U3'),
                    ('O4','U4'),
                    ('O5','U5'),
                    ('O6','U6');
                    
SELECT * FROM orderitem; 

insert into orderproduct(Order_ID,Product_ID,ShippingAddress,Cost,Quantity,Status)
                    VALUES
                    ('O1','MB','Jaipur',5000,5,'NOT-SHIPPED'),
                    ('O2','MC','Jaipur',5000,5,'NOT-SHIPPED'),
                    ('O3','SH','Jaipur',5000,5,'NOT-SHIPPED'),
                    ('O4','SM','Jaipur',5000,5,'NOT-SHIPPED'),
                    ('O5','NO','Jaipur',5000,5,'NOT-SHIPPED'),
                    ('O6','FST','Jaipur',5000,5,'NOT-SHIPPED');
                    
insert into orderproduct(Order_ID,Product_ID,ShippingAddress,Cost,Quantity,Status)
                    VALUES
                    ('O1','MC','Jaipur',5000,5,'NOT-SHIPPED'),
                    ('O2','MC','Udaipur',50000,25,'NOT-SHIPPED'),
                    ('O3','SH','Jaipur',15000,5,'NOT-SHIPPED'),
                    ('O4','FST','Aligarh',2000,35,'NOT-SHIPPED'),
                    ('O5','NO','Jodhpur',51000,15,'NOT-SHIPPED'),
                    ('O6','FST','Agra',90000,1,'NOT-SHIPPED');                    
                    
insert into orderproduct(Order_ID,Product_ID,ShippingAddress,Cost,Quantity,Status)
                    VALUES
                    ('O1','MC','Jaipur',5000,5,'SHIPPED'),
                    ('O2','MC','Udaipur',50000,25,'NOT-SHIPPED'),
                    ('O3','SH','Jaipur',15000,5,'SHIPPED'),
                    ('O4','FST','Aligarh',2000,35,'NOT-SHIPPED'),
                    ('O5','NO','Jodhpur',51000,15,'NOT-SHIPPED'),
                    ('O6','FST','Agra',90000,1,'NOT-SHIPPED');  
                    
SELECT * FROM orderproduct;   
delete from orderproduct;

# 1 > Display Recent 5 Orders placed (Id, Order Date, Order Total).

SELECT op.Order_ID,op.Order_Date,
op.Cost*op.Quantity As TotalCost
FROM orderproduct op
INNER JOIN orderitem p
ON p.Order_ID = op.Order_ID
ORDER BY Order_Date
LIMIT 5;

# 2 > Display 10 most expensive Orders.

SELECT op.Order_ID,op.Order_Date,
op.Cost*op.Quantity As TotalCost
FROM orderproduct op
INNER JOIN orderitem p
ON p.Order_ID = op.Order_ID
ORDER BY TotalCost
LIMIT 5;

#3 > Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.

SELECT op.Order_ID,op.Product_ID 
FROM orderitem o
JOIN orderproduct op
ON op.Order_ID = o.Order_ID
WHERE Status = 'NOT-SHIPPED';

#4 > Display list of shoppers which haven't ordered anything since last month.

SELECT Name
FROM user
WHERE User_ID NOT IN (SELECT User_ID FROM orderitem WHERE Order_Date<CURDATE()-30);

#5 > Display list of shopper along with orders placed by them in last 15 days. 

SELECT Name
FROM user
WHERE User_ID IN (SELECT distinct User_ID FROM orderitem WHERE Order_Date > CURDATE()-15);

#6 > Display list of order items which are in “shipped” state for particular Order Id )

SELECT P.Name
FROM product P 
JOIN orderproduct O
ON P.Product_ID = O.Product_ID
WHERE O.Product_ID = 'MC' 
AND O.Status = 'SHIPPED';

#7 > Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.

SELECT DISTINCT P.Name, O.Order_Date
FROM product P 
JOIN orderitem O 
JOIN orderproduct PO
ON P.Product_ID = PO.Product_ID
WHERE P.Cost BETWEEN 200 AND 500;

# 8 > Update first 20 Order items status to “Shipped” which are placed today.

UPDATE orderproduct 
SET Status = 'SHIPPED'
LIMIT 10;

SELECT * FROM orderproduct;