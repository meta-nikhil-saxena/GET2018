# 1 > Display the list of products (Id, Title, Count of Categories) 
# which fall in more than one Categories.
 
SELECT DISTINCT pl.product_id,p.name,COUNT(pl.product_id) AS count_product
FROM productlist pl
INNER JOIN product p
ON p.id = pl.product_id
GROUP BY pl.product_id
HAVING COUNT(pl.product_id) > 1;

# 2 > Display Count of products as per below price range:

SELECT price_range , COUNT(*) AS product_count 
FROM(SELECT CASE
       WHEN cost BETWEEN 0 AND 100 THEN '0-100'
       WHEN cost BETWEEN 101 AND 500 THEN '100-500'
       ELSE 'Above 500' END AS price_range
       FROM product) pr
GROUP BY pr.price_range;

# or above question can be done by individual count

# (i)  0 - 100
  
SELECT COUNT(cost) AS count
FROM product
WHERE cost 
BETWEEN 0 
AND 100;

# (ii)  101 - 500

SELECT COUNT(cost) AS count
FROM product
WHERE cost 
BETWEEN 101 
AND 500;

# (iii)  Above 500

SELECT COUNT(cost) AS count
FROM product
WHERE
cost >= 500;


#3 > Display the Categories along with number of products under each category.

SELECT pl.category_id, c.name, COUNT(product_id) AS number_of_products
FROM productlist pl
INNER JOIN category c
ON c.id = pl.category_id
GROUP BY category_id;


