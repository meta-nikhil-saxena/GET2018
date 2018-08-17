use Storefront;
/*
Q1 : 
Write SQL scripts for the following:
*/

#1 > Insert sample data in StoreFront tables by using SQL files.
insert into user(User_ID,Email_ID,Name,Password,ContactNum,DOB)
                 VALUES
                 ('U1','u1@metacube.com','User1','1234','123345688','1996-08-04'),
                 ('U2','u2@metacube.com','User2','1234','123345688','1996-08-04'),
                 ('U3','u3@metacube.com','User3','1234','123345688','1996-08-04'),
                 ('U4','u4@metacube.com','User4','1234','123345688','1996-08-04'),
                 ('U5','u5@metacube.com','User5','1234','123345688','1996-08-04'),
                 ('U6','u6@metacube.com','User6','1234','123345688','1996-08-04'),
                 ('U7','u7@metacube.com','User7','1234','123345688','1996-08-04');
                
select * from user;

insert into addressbook(User_ID,Address_ID)                           
                       VALUES
                       ('U1','A1'),
                       ('U2','A2'),
                       ('U3','A3'),
                       ('U4','A4'),
                       ('U5','A5'),
                       ('U6','A6'),
                       ('U7','A7');
                       
SELECT * FROM addressbook;                       
                       
insert into addressstore(Address_ID,Address,Pincode,Landmark)
                          VALUES
                          ('A1','abcd',123456,''),
                          ('A2','abcd',123456,'Taj'),
                          ('A3','abcd',123456,'Taj Hotel'),
                          ('A4','abcd',123456,'PG'),
                          ('A5','abcd',123456,'Temple'),
                          ('A6','abcd',123456,''),
                          ('A7','abcd',123456,'');
                          
SELECT * FROM addressstore;

insert into category(Category_ID,Parent_ID,Name,Quantity,Image_logo)
                     VALUES
                     ('El','NULL','ELECTRONICS',10,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Mob','El','Mobile',10,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Cl','NULL','Clothes',20,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Et','NULL','Etables',20,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                     ('Fd','NULL','Foods',20,'D:\New folder\GET2018\GET2018\DBMS-Assignment-2');
                 
SELECT * FROM category;

insert into product(Category_ID,Product_ID,Image_ID,Name,Quantity,Cost,Total_images,status)
                    VALUES
                    ('El','MB','MBIm','Mobile',5,5000,0,'Available'),
                    ('El','MC','MCIm','Washing Machine',5,15000,2,'Available'),
                    ('Cl','SH','SHIm','Shirt',15,500,0,'Available'),
                    ('Mob','SM','SMIm','Samsung',15,500,0,'Available'),
                    ('Mob','NO','NOIm','Nokia',15,500,0,'Available'),
                    ('Fd','FST','FSTIm','Fast Food',15,50,1,'Available');
                    
SELECT * FROM product;     

insert into image(Image_ID,Name,Image)
                  VALUES
                  ('MBIm','Mobile','D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                  ('MCIm','Washing Machine','D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                  ('SHIm','T-Shirt','D:\New folder\GET2018\GET2018\DBMS-Assignment-2'),
                  ('FSTIm','Pasta','D:\New folder\GET2018\GET2018\DBMS-Assignment-2');
                  
SELECT * FROM image;      


# 2 > Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top

SELECT P.Product_ID,C.Name,P.Cost
FROM product P
INNER JOIN category C
ON C.Category_ID = P.Category_ID
WHERE status = 'Available'
ORDER BY DateAddProduct;

# 3 > Display the list of products which don't have any images

SELECT Name
FROM product
WHERE Total_images = 0;

# 4 > Display all Id, Title and Parent Category Title for all the Categories listed, 
# sorted by Parent Category Title and then Category Title. 
# (If Category is top category then Parent Category Title column should display “Top Category” as value.)

SELECT c.Category_ID,c.Name,c.Parent_ID,
IFNULL( p.Name, 'Parent') AS Parent_Category
FROM category c
LEFT JOIN category p
ON c.Category_ID = p.Parent_ID;

# 5 > Display Id, Title, Parent Category Title of all the leaf Categories 
# (categories which are not parent of any other category)

SELECT C.Category_ID, C.Name, 
IFNULL(P.Name, 'Leaf Categories') as Parent_Category
FROM Category C                                                                   
LEFT JOIN Category P
ON C.Parent_ID = P.Category_ID;

# 6 > Display Product Title, Price & Description which falls into particular category Title 
# (i.e. “Mobile”)


SELECT P.Product_ID,P.Name,P.Cost
FROM product P
INNER JOIN category C
ON P.Category_ID = C.Category_ID
WHERE C.Name = 'Mobile';

# 7 > Display the list of Products whose Quantity on hand (Inventory) is under 10.

SELECT * FROM product
WHERE Quantity < 10;

#8 > Increase the Inventory of all the products by 100.

UPDATE product
SET Quantity = Quantity + 100;

SELECT * FROM product;