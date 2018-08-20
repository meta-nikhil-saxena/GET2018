USE storefront;

# Q-1 > Create a Stored procedure to retrieve average sales of each product in a month. 
# Month and year will be input parameter to function.

    SELECT * from orderproduct;
    
    DELIMITER $$
    CREATE PROCEDURE average_sale(month int, year int)
    BEGIN
    
    SELECT p.id,p.name,op.order_date, AVG(p.cost*op.quantity) AS avg_amount
    FROM orderitem i
    INNER JOIN orderproduct op
    ON i.id = op.order_id
    INNER JOIN product p
    ON op.product_id = p.id
    WHERE MONTH(op.order_date) = month AND YEAR(op.order_date) = year 
    GROUP BY op.product_id;
    
    END$$

    CALL average_sale(08,2018);
    
    DROP PROCEDURE average_sale;
    
    # Q-2 > Create a stored procedure to retrieve table having order detail with status for a given period. 
    # Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
    # If start date is greater than end date take first date of month as start date.
    
   DELIMITER $$ 
   CREATE FUNCTION validate_date(start_date Date,end_date Date)
   RETURNS DATE
   BEGIN
   DECLARE set_start_date DATE;
   
       if (start_date < end_date)
           then
               return start_date;
               
       else
          SET set_start_date = CONCAT(DATE_FORMAT(end_date, '%Y-%m-'), '01');
           return set_start_date;
           
       END if;
   END$$
   
   DELIMITER $$
   CREATE PROCEDURE order_details(IN start_date Date,IN end_date Date)
   BEGIN
   DECLARE set_start_date Date;
   
   SET set_start_date = validate_date(start_date,end_date);
   
               SELECT DISTINCT i.id AS order_id,p.id AS product_id,p.name,o.order_date,o.status
               FROM orderitem i
               INNER JOIN orderproduct o
               ON o.order_id = i.id
               INNER JOIN product p
               ON p.id = o.product_id
               WHERE o.order_date BETWEEN set_start_date AND end_date;

   END$$
   
   CALL order_details('2017-07-10','2018-08-18');