USE Storefront;
/*
Q1 : 
Write SQL scripts for the following:
*/

#1 > Insert sample data in StoreFront tables by using SQL files.
INSERT INTO user(email_id,name,password,dob)
                 VALUES
                 ('u1@metacube.com','User1','1234','1996-08-04'),
                 ('u2@metacube.com','User2','1234','1996-08-04'),
                 ('u3@metacube.com','User3','1234','1996-08-04'),
                 ('u4@metacube.com','User4','1234','1996-08-04'),
                 ('u5@metacube.com','User5','1234','1996-08-04'),
                 ('u6@metacube.com','User6','1234','1996-08-04'),
                 ('u7@metacube.com','User7','1234','1996-08-04');
                
select * from user;

INSERT INTO addressbook(user_id)                           
                       VALUES
                       (1),
                       (2),
                       (3),
                       (4),
                       (5),
                       (6),
                       (7);
                       
SELECT * FROM addressbook;                       
                       
INSERT INTO addressstore(address_id,address,pincode,landmark)
                          VALUES
                          (1,'abcd',123456,''),
                          (2,'abcd',123456,'Taj'),
                          (3,'abcd',123456,'Taj Hotel'),
                          (4,'abcd',123456,'PG'),
                          (5,'abcd',123456,'Temple'),
                          (6,'abcd',123456,''),
                          (7,'abcd',123456,'');
                          
SELECT * FROM addressstore;

INSERT INTO category(name,quantity,image_logo)
                     VALUES
                     ('ELECTRONICS',10,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2');

INSERT INTO category(parent_id,name,quantity,image_logo)
                     VALUES                     
                     (44,'Mobile',10,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2');

INSERT INTO category(name,quantity,image_logo)
                     VALUES
                     ('Clothes',20,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Etables',20,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Foods',20,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Snacks',22,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2');
                 
SELECT * FROM category;

INSERT INTO product(name,quantity,cost,status)
                    VALUES
                    ('Mobile',5,5000,'Available'),
                    ('Washing Machine',5,15000,'Available');
                    
INSERT INTO product(name,quantity,cost,status)
                    VALUES         
                    ('Shirt',15,500,'Available'),
                    ('Samsung',15,500,'Available');
                    
INSERT INTO product(name,quantity,cost,status)
                    VALUES                    
                    ('Nokia',15,500,'Available'),
                    ('Fast Food',15,50,'Available'),
                    ('Noodles',15,50,'Available');
                    
SELECT * FROM category;
                    
SELECT * FROM product;  

INSERT INTO productlist(category_id,product_id)
                        VALUES
                        (44,1),
                        (44,2),
                        (46,3),
                        (45,4),
                        (45,5),
                        (48,6),
                        (49,7);
    
INSERT INTO productlist(category_id,product_id)
                        VALUES
                        (48,7);
                        
SELECT * FROM productlist;


INSERT INTO image(product_id,name,Image)
                  VALUES
                  (1,'Mobile','D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                  (2,'Washing Machine','D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                  (3,'T-Shirt','D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                  (6,'Pasta','D:\New folder\GET2018\GET2018\DBMS-Assignment-2');
                  
SELECT * FROM image;      


# 2 > Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top

SELECT p.id,p.name,c.name AS category_name,p.cost
FROM product p
INNER JOIN productlist pl
ON p.id = pl.product_id
INNER JOIN category c
ON c.id = pl.category_id
WHERE status = 'Available'
ORDER BY date DESC;

# 3 > Display the list of products which don't have any images

SELECT id,name
FROM product
WHERE id
NOT IN(SELECT product_id FROM image);

# 4 > Display all Id, Title and Parent Category Title for all the Categories listed, 
# sorted by Parent Category Title and then Category Title. 
# (If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT c.id,c.name,c.parent_id,
IFNULL(p.name,'Top Category') AS parent_category
FROM category c
LEFT JOIN category p
ON c.id = p.parent_id
ORDER BY parent_category,c.name;

# 5 > Display Id, Title, Parent Category Title of all the leaf Categories 
# (categories which are not parent of any other category)

SELECT c.id, c.name, 
IFNULL(p.name, 'Leaf Categories') as parent_category
FROM category c                                                                   
LEFT JOIN category p
ON c.parent_id = p.id
WHERE p.id IS NULL;


# 6 > Display Product Title, Price & Description which falls into particular category Title 
# (i.e. “Mobile”)

SELECT p.id,p.name,p.cost
FROM product p
INNER JOIN productlist pl
ON p.id = pl.product_id
INNER JOIN category c
ON c.id = pl.category_id
WHERE c.name = 'Mobile';


# 7 > Display the list of Products whose Quantity on hand (Inventory) is under 10.

SELECT * FROM product
WHERE Quantity < 10;

#8 > Increase the Inventory of all the products by 100.

UPDATE product
SET Quantity = Quantity + 100;

SELECT * FROM product;
