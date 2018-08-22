/* 1 > Consider a form where providing a Zip Code populates associated City and
       State. 
       
         Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/

CREATE TABLE zipcode
                    (
                    id INT NOT NULL AUTO_INCREMENT,  
                    zipcode INT NOT NULL,
                    city VARCHAR(50) NOT NULL,
                    state VARCHAR(50) NOT NULL,
                    PRIMARY KEY(id),
                    UNIQUE(zipcode)
                    );
desc zipcode;

INSERT INTO zipcode(zipcode,city,state) 
                    VALUES
                    (313001, 'Udaipur', 'Rajasthan'),
                    (302019, 'Jaipur', 'Rajasthan'),
                    (302020, 'Jaipur', 'Rajasthan'), 
                    (302021, 'Jaipur', 'Rajasthan');
                    
SELECT * FROM zipcode;                    
          
SELECT id , zipcode , city , state
FROM zipcode
ORDER BY state, city;          