USE storefront;

/*
Q-1

Create a function to calculate number of orders in a month. 
Month and year will be input parameter to function.
*/

DELIMITER $$

CREATE FUNCTION number_of_orders(month INT,year INT) 
RETURNS INT NOT DETERMINISTIC

BEGIN

DECLARE num INT;

SELECT COUNT(order_id) INTO num 
FROM orderproduct 
WHERE MONTH(order_date) = month 
AND YEAR(order_date) = year;

RETURN (num);

END$$

SELECT number_of_orders(08,2018);


/*
Q-2

Create a function to return month in a year having maximum orders. 
Year will be input parameter.
*/

DELIMITER $$

CREATE FUNCTION max_order(year INT) 
RETURNS INT DETERMINISTIC

BEGIN

DECLARE max INT;


      SELECT MONTH(order_date) INTO max
      FROM orderproduct
      WHERE YEAR(order_date) = year
      GROUP BY MONTH(order_date)
      ORDER BY COUNT(order_id) DESC
      LIMIT 1;
      
      RETURN (max);



END$$

SELECT max_order(2018);