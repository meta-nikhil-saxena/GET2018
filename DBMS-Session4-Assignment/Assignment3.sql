# Q. Identify the columns require indexing in order, product, category tables and create indexes.

    # Appling indexes on addressbook Table
       
       ALTER TABLE addressbook ADD INDEX index_user_id(user_id);
       
       SHOW INDEX FROM addressbook;
       
    # Appling indexes on addressstore Table
    
       ALTER TABLE addressstore ADD INDEX index_address_id(address_id);

       SHOW INDEX FROM addressstore;

    # Appling indexes on category Table
       
       ALTER TABLE category ADD UNIQUE index_name(name);
       
       ALTER TABLE category ADD INDEX index_parent_id(parent_id);
       
       SHOW INDEX FROM category;
       
    # Appling indexes on productlist Table
    
       ALTER TABLE productlist ADD INDEX index_product_id(product_id);
       
       ALTER TABLE productlist ADD INDEX index_category_id(category_id);
       
       SHOW INDEX FROM productlist;
       
    # Appling indexes on orderitem Table
    
       ALTER TABLE orderitem ADD INDEX index_user_id(user_id);
       
       ALTER TABLE orderitem ADD INDEX index_order_date(order_date);
       
       SHOW INDEX FROM orderitem;
       
    # Appling indexes on orderproduct Table
       
       ALTER TABLE orderproduct ADD INDEX index_order_id(order_id);
       
       ALTER TABLE orderproduct ADD INDEX index_product_id(product_id);
       
       ALTER TABLE orderproduct ADD INDEX index_status(status);
       
       SHOW INDEX FROM orderproduct;