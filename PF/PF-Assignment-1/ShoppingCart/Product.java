//Class to set and get product Details

package ShoppingCart;

public class Product {
        private String item;
        private int price;
        private int quantity;
        
        void setPrice(int price){
        	this.price = price;
        }
        void setItem(String item){
        	this.item = item;
        }
        void setQuantity(int quantity){
        	this.quantity = quantity;
        }
        String getItem(){
        	return this.item;
        }
        int getPrice(){
        	return this.price;
        }
        int getQuantity(){
        	return this.quantity;
        }
        
      }
