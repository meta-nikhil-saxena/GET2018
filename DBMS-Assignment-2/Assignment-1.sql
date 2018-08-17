create database Storefront;

show databases;

use Storefront;


#Question 1
/*
Write SQL scripts for the following:
Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments.
(Write all CREATE commands in a SQL file and run that SQL File).
*/

#table1
create table user(
                  User_ID VARCHAR(15) NOT NULL,    
                  Email_ID VARCHAR(20) NOT NULL,
                  Name VARCHAR(50) NOT NULL,
                  Password VARCHAR(15) NOT NULL,
                  ContactNum VARCHAR(15) NOT NULL,
                  DOB DATE NOT NULL,
                  PRIMARY KEY(User_ID),
                  UNIQUE(Email_ID)
                 );

desc user;

#table2
create table addressbook(
                        User_ID VARCHAR(5) NOT NULL,
                        Address_ID VARCHAR(5) NOT NULL,                           
                        PRIMARY KEY(Address_ID),
                        FOREIGN KEY (User_ID) REFERENCES user(User_ID)
                        ON UPDATE CASCADE
                        ON DELETE RESTRICT
                        );
                        
desc addressBook;

#table3
create table addressstore(
                         Address_ID VARCHAR(5) NOT NULL,
                         Address TEXT NOT NULL,
                         Pincode INT NOT NULL,
                         Landmark VARCHAR(45),
                         FOREIGN KEY(Address_ID) REFERENCES addressbook(Address_ID)
                         );

desc addressstore;

#table4
create table category(
                      Category_ID VARCHAR(5) NOT NULL,
                      Parent_ID VARCHAR(5) NULL,
                      Name VARCHAR(45) NOT NULL,
                      Quantity INT NOT NULL,
                      Image_logo BLOB,
                      PRIMARY KEY(Category_ID), 
                      FOREIGN KEY (Parent_ID) REFERENCES category(Category_ID) ON DELETE CASCADE
                     );
                     
desc category; 

#table5
create table product(
                     Category_ID VARCHAR(5) NOT NULL,
                     Product_ID VARCHAR(5) NOT NULL,
                     Image_ID VARCHAR(5) NOT NULL,
                     Name VARCHAR(45) NOT NULL,
                     Quantity INT NOT NULL,
                     Cost INT NOT NULL,
                     Total_images INT NOT NULL,                     
                     status VARCHAR(20) NOT NULL,
                     DateAddProduct TIMESTAMP NOT NULL,
                     PRIMARY KEY(Product_ID),
                     FOREIGN KEY(Category_ID) REFERENCES category(Category_ID),
                     UNIQUE(Image_ID)
                     ); 
                     
desc product;  

#table6
create table image(
                   Image_ID VARCHAR(5) NOT NULL,
                   Name VARCHAR(45) NOT NULL,
                   Image BLOB,
                   FOREIGN KEY(Image_ID) REFERENCES product(Image_ID)
                  );
                  
desc image;   

#table7
create table orderitem(
                   Order_ID VARCHAR(5) NOT NULL,                   
                   User_ID VARCHAR(5) NOT NULL,
                   Order_Date TIMESTAMP NOT NULL,                                   
                   PRIMARY KEY(Order_ID),
                   FOREIGN KEY(User_ID) REFERENCES user (User_ID)
                  );
                  
desc orderitem;   

#table8
create table orderproduct(
                   Order_ID VARCHAR(5) NOT NULL,
                   Product_ID VARCHAR(5) NOT NULL,
                   ShippingAddress VARCHAR(45) NOT NULL,
                   Cost INT NOT NULL,
                   Quantity INT NOT NULL,
                   Order_Date TIMESTAMP NOT NULL,        
                   Status VARCHAR(45) NULL DEFAULT 'NOT-Shipped',
                   FOREIGN KEY(Order_ID) REFERENCES orderitem (Order_ID),
                   FOREIGN KEY(Product_ID) REFERENCES product (Product_ID)
                   );
                
desc orderproduct;

#Question 2
/*
Write a command to display all the table names present in StoreFront.

*/
show tables;


#Question 3
/*
Write a command to remove Product table of the StoreFront database.
*/
drop table orderproduct;

drop table orderitem;

drop table image;

drop table product;

drop table category;

show tables;


#Question 4
/*
Create the Product table again.
*/
#table4
create table category(
                      Category_ID VARCHAR(5) NOT NULL,
                      Parent_ID VARCHAR(5) NOT NULL,
                      Name VARCHAR(45) NOT NULL,
                      Quantity INT NOT NULL,
                      Image_logo BLOB,
                      PRIMARY KEY(Category_ID)
                     );
                     
#table5
create table product(
                     Category_ID VARCHAR(5) NOT NULL,
                     Product_ID VARCHAR(5) NOT NULL,
                     Image_ID VARCHAR(5) NOT NULL,
                     Name VARCHAR(45) NOT NULL,
                     Quantity INT NOT NULL,
                     Cost INT NOT NULL,
                     Total_images INT NOT NULL,                     
                     status VARCHAR(20) NOT NULL,
                     DateAddProduct TIMESTAMP NOT NULL,
                     PRIMARY KEY(Product_ID),
                     FOREIGN KEY(Category_ID) REFERENCES category(Category_ID),
                     UNIQUE(Image_ID)
                     ); 
                     
#table6
create table image(
                   Image_ID VARCHAR(5) NOT NULL,
                   Name VARCHAR(45) NOT NULL,
                   Image BLOB,
                   FOREIGN KEY(Image_ID) REFERENCES product(Image_ID)
                  );  
                  
#table7
create table orderitem(
                   Order_ID VARCHAR(5) NOT NULL,                   
                   User_ID VARCHAR(5) NOT NULL,
                   Order_Date TIMESTAMP NOT NULL,                                   
                   PRIMARY KEY(Order_ID),
                   FOREIGN KEY(User_ID) REFERENCES user (User_ID)
                  );
#table8
create table orderproduct(
                   Order_ID VARCHAR(5) NOT NULL,
                   Product_ID VARCHAR(5) NOT NULL,
                   ShippingAddress VARCHAR(45) NOT NULL,
                   Cost INT NOT NULL,
                   Quantity INT NOT NULL,
                   Order_Date TIMESTAMP NOT NULL, 
                   Status VARCHAR(45) NULL DEFAULT 'NOT-Shipped',
                   FOREIGN KEY(Order_ID) REFERENCES orderitem (Order_ID),
                   FOREIGN KEY(Product_ID) REFERENCES product (Product_ID)
                   );                  
                                   
                                   
                                


                                   