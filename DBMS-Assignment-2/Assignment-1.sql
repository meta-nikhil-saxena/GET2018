create database Storefront;

show databases;

USE Storefront;


#Question 1
/*
Write SQL scripts for the following:
Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments.
(Write all CREATE commands in a SQL file and run that SQL File).
*/

#table1
create table user(
                  id INT NOT NULL AUTO_INCREMENT,    
                  email_id VARCHAR(20) NOT NULL,
                  name VARCHAR(50) NOT NULL,
                  password VARCHAR(15) NOT NULL,
                  dob DATE NOT NULL,
                  PRIMARY KEY(id),
                  UNIQUE(email_id)
                  );

desc user;

#table2
create table addressbook(
                        id INT NOT NULL AUTO_INCREMENT,
                        user_id INT NOT NULL,                                                   
                        PRIMARY KEY(id),
                        FOREIGN KEY (user_id) REFERENCES user(id)
                        ON UPDATE CASCADE
                        ON DELETE RESTRICT
                        );
                        
desc addressBook;

#table3
create table addressstore(
                         address_id INT NOT NULL,
                         address TEXT NOT NULL,
                         pincode INT NOT NULL,
                         landmark VARCHAR(45),
                         FOREIGN KEY(address_id) REFERENCES addressbook(id)
                         );

desc addressstore;


#table4
create table category(
                      id INT NOT NULL AUTO_INCREMENT,
                      parent_id INT NULL,
                      name VARCHAR(45) NOT NULL,
                      quantity INT NOT NULL,
                      image_logo BLOB,
                      PRIMARY KEY(id), 
                      FOREIGN KEY (parent_id) REFERENCES category(id)
                     );
                     
desc category; 

#table5
create table product(
                     id INT NOT NULL AUTO_INCREMENT,
                     name VARCHAR(45) NOT NULL,
                     quantity INT NOT NULL,
                     cost INT NOT NULL,
                     status VARCHAR(20) NOT NULL,
                     date TIMESTAMP NOT NULL,
                     PRIMARY KEY(id)                   
                     ); 
desc product;

#table6
create table productlist(
                        category_id INT NOT NULL,
                        product_id INT NULL,
                        FOREIGN KEY(category_id) REFERENCES category(id),
                        FOREIGN KEY (product_id) REFERENCES product(id) 
                        );
desc productlist;         

#table7
create table image(
                   product_id INT NOT NULL,
                   name VARCHAR(45) NOT NULL,
                   image BLOB,
                   FOREIGN KEY(product_id) REFERENCES product(id)
                  );
                  
desc image;   

#table8
create table orderitem(
                   id INT NOT NULL AUTO_INCREMENT,                  
                   user_id INT NOT NULL,
                   order_date TIMESTAMP NOT NULL,                                   
                   PRIMARY KEY(id),
                   FOREIGN KEY(user_id) REFERENCES user (id)
                  );
                  
desc orderitem;   

#table9
create table orderproduct(
                   order_id INT NOT NULL,
                   product_id INT NOT NULL,
                   shippingaddress VARCHAR(45) NOT NULL,
                   cost INT NOT NULL,
                   quantity INT NOT NULL,
                   order_Date TIMESTAMP NOT NULL,        
                   status VARCHAR(45) NULL DEFAULT 'NOT-Shipped',
                   FOREIGN KEY(order_id) REFERENCES orderitem (id),
                   FOREIGN KEY(product_id) REFERENCES product (id)
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

drop table productlist;

drop table product;

drop table category;

show tables;


#Question 4
/*
Create the Product table again.
*/
#table4
create table category(
                      id INT NOT NULL AUTO_INCREMENT,
                      parent_id INT NULL,
                      name VARCHAR(45) NOT NULL,
                      quantity INT NOT NULL,
                      image_logo BLOB,
                      PRIMARY KEY(id), 
                      FOREIGN KEY (parent_id) REFERENCES category(id) ON DELETE CASCADE
                     );
                     
desc category; 

#table5
create table product(
                     id INT NOT NULL AUTO_INCREMENT,
                     name VARCHAR(45) NOT NULL,
                     quantity INT NOT NULL,
                     cost INT NOT NULL,
                     total_images INT NOT NULL,                     
                     status VARCHAR(20) NOT NULL,
                     date TIMESTAMP NOT NULL,
                     PRIMARY KEY(id)                   
                     ); 
desc product;

#table6
create table productlist(
                        category_id INT NOT NULL,
                        product_id INT NULL,
                        FOREIGN KEY(category_id) REFERENCES category(id),
                        FOREIGN KEY (product_id) REFERENCES product(id) 
                        );
desc productlist;         

#table7
create table image(
                   product_id INT NOT NULL,
                   name VARCHAR(45) NOT NULL,
                   image BLOB,
                   FOREIGN KEY(product_id) REFERENCES product(id)
                  );
                  
desc image;   

#table8
create table orderitem(
                   id INT NOT NULL AUTO_INCREMENT,                  
                   user_id INT NOT NULL,
                   order_date TIMESTAMP NOT NULL,                                   
                   PRIMARY KEY(id),
                   FOREIGN KEY(user_id) REFERENCES user (id)
                  );
                  
desc orderitem;   

#table9
create table orderproduct(
                   order_id INT NOT NULL,
                   product_id INT NOT NULL,
                   shippingaddress VARCHAR(45) NOT NULL,
                   cost INT NOT NULL,
                   quantity INT NOT NULL,
                   order_Date TIMESTAMP NOT NULL,        
                   status VARCHAR(45) NULL DEFAULT 'NOT-Shipped',
                   FOREIGN KEY(order_id) REFERENCES orderitem (id),
                   FOREIGN KEY(product_id) REFERENCES product (id)
                   );
                
desc orderproduct;            
                                   
                                


                                   
