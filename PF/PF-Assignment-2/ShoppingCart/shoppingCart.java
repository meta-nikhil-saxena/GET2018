//Class to add Product along with details in the cart and Perform other Operations

package ShoppingCart;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


public class shoppingCart {
	static Promotion promotionProduct;
	static Promotion promotionOrder;
	static Scanner sc;
	ArrayList<Object> cart;
	
	
	public shoppingCart() {
		 promotionProduct = new fixedProductPromotion();
		 promotionOrder = new fixedOrderPromotion();
		 sc = new Scanner(System.in);
		 cart= new ArrayList<Object>();
	}
	 
	
/**
 * Function to set Item Details and Add to Cart	
 * @param index
 */
        void setItemDetailsAndAdd(int index){
    	   
    	   Product product = new Product();
    	  
    	   System.out.println("Enter Item : ");
    	   product.setItem(sc.next());
    	   
    	   System.out.println("Enter Price : ");
    	   product.setPrice(sc.nextInt());
    	   
    	   System.out.println("Enter Quantity : ");
    	   product.setQuantity(sc.nextInt());
    	   
    	   cart.add(index,product);
       }
 
/**
 * Function for setting Minimum price and Discount for each product        
 */
      void setMinPriceAndDiscountforProduct(){
    	  
    	  
    	  System.out.println("Enter MinPrice for Product Discount : ");
    	  promotionProduct.setMinimumPrice(sc.nextInt());
    	  
    	  System.out.println("Enter Discount : (Enter Between 1-100) ");
    	  
    	  int discountProduct = sc.nextInt();
               if(discountProduct < 100 && discountProduct > 0){
            	promotionProduct.setFixedDiscount(discountProduct);
               }else{
                System.out.println("Enter valid Discount, Program is terminating");
                System.exit(0);
               }
    	  
      }
      
      void setMinPriceAndDiscountforOrder(){
    	  
    	  
    	  System.out.println("Enter MinPrice for Total Order Discount : ");
    	  promotionOrder.setMinimumPrice(sc.nextInt());
    	  
    	  System.out.println("Enter Discount for Total Order : (Enter Between 1-100) ");
          int discountOrder =  	sc.nextInt();
              if(discountOrder < 100 && discountOrder > 0){
    	      promotionOrder.setFixedDiscount(discountOrder);
              }else{
              System.out.println("Enter valid Discount, Program is terminating");
              System.exit(0);
              }
    	  
      }
      
/**
 * Function to remove product with details
 * @param index
 */
       void removeItem(int index){
    	   cart.remove(index);
       }
 
/**
 * Function to show Product along with details
 * Details include :
 * 1> Product index
 * 2> Product Name
 * 3> Product Price
 * 4> Product Quantity
 * 5> Product individual Discount
 */
       void show(){
    	   Iterator<Object> iterator= cart.iterator(); 
    	   int i=0;
    	   while(iterator.hasNext()){
    		
    		  Product product = (Product)cart.get(i);
    		  
    		  System.out.println("Product Index : "+i);
    		  System.out.println("Item : "+product.getItem());
    		  System.out.println("Price : "+product.getPrice());
    		  System.out.println("Quantity : "+product.getQuantity());
    		  
    		  System.out.println("------------------------------------");
    		  
    		  if(product.getPrice() >= promotionProduct.getMinimumPrice()){
    			System.out.println("Discount on Product Given : "+promotionProduct.getFixedDiscount());  
    		  }
    		  
    		  i++;
    		  iterator.next();
    		  
    	   }
       }
       
 /**
  * Function for updating quantity of Item
  * @param index
  */
       void updateQuantity(int index){
    	   Product product = (Product)cart.get(index);
    	   
    	   System.out.println("Update item Quantity of "+product.getItem()+" : ");
    	   product.setQuantity(sc.nextInt());
    	   System.out.println("Quantity Updated !!");
       }
    
/**
 * Function to return total amount for cart items
 * @return totalAmount for the cart items       
 */
       int generateBillinCart(){
    	   Iterator<Object> iterator= cart.iterator(); 
    	   int i=0,totalAmount = 0;
    	   while(iterator.hasNext()){
    		
    		  Product product = (Product)cart.get(i);
    		
    		  
         /** function if Calculates total amount after reducing discount
          *  Compares the minimum price with the actual price of the Product, to apply fixed discount on each item
          *  Check the promotion code to be apply on item to avail the fixed discount  		  
          */
    		        if(product.getPrice() >= promotionProduct.getMinimumPrice()){
    		        	
    		        	  System.out.println("Enter the Promo code here : ");
    		        	  String code = sc.next();
    		        	  
    		        	  Date currentDate = new Date();
    		        	  if(promotionProduct.isPromotionApplicable(code, currentDate)){
      			                totalAmount += (product.getPrice()-promotionProduct.getFixedDiscount()) * (product.getQuantity());
    		        	  }else{
    		        		  System.out.println("Enter Valid Promo Code");
    		        	  }
    		        	         
    		        }else{
    		             totalAmount += (product.getPrice()) * (product.getQuantity());
    		             
    		        }
    		  i++;
    		  iterator.next();
    		  
    	   }
       return totalAmount;   
       }
       
       
       
   public static void main(String args[]){
	  
	
	  
	   int choice,i=0;
	   shoppingCart obj = new shoppingCart();
	   
	   System.out.println("Set Minimum Price and Discount");
	   obj.setMinPriceAndDiscountforProduct();
	   obj.setMinPriceAndDiscountforOrder();
	   
	try{   
	   do{
			System.out.println("1. Add Product and Details");
			System.out.println("2. Remove Product and Details");
			System.out.println("3. Show items in the cart");
			System.out.println("4. Update Quantity of item");
			System.out.println("5. Generate bill in the cart");
			System.out.println("6. EXIT");
			
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:{
				System.out.println("Enter the Details of product and add Item : ");
				obj.setItemDetailsAndAdd(i);
				i++;
				break;
			}
			case 2:{
				System.out.println("Enter Item Index to be Deleted : ");
				obj.removeItem(sc.nextInt());
				break;
			}
			case 3:{
				obj.show();
				break;
			}
			case 4:{
				System.out.println("Enter Item Index to Update quantity : ");
				obj.updateQuantity(sc.nextInt());
				break;
			}
			case 5:{
				int totalAmountInCart = obj.generateBillinCart();
			    int FinalAmount = 0;
          	    String code;
          	    Date currentDate = new Date(); 
			 	               if(totalAmountInCart >= promotionOrder.getMinimumPrice()){
			 	            	   
			 	            	   System.out.println("Enter Promotion code for Order Discount in Cart : ");
			 	            	   code = sc.next();
			 	            	   
			 	            	         if(promotionOrder.isPromotionApplicable(code, currentDate)){
			 	            	        	 FinalAmount = totalAmountInCart-promotionOrder.getFixedDiscount();
			 	            	        	 
			 	            	        	System.out.println("-----------------------------------");
			 	   		                    System.out.println("Total Amount of Cart is : "+FinalAmount);
			 	   		                    System.out.println("-----------------------------------");
			 	   		                    
			 	            	         }else{
			 	            	        	 System.out.println("Enter valid Promo Coder for Full Order Discount");
			 	            	         }
				                }else{
	 	            	        	 FinalAmount = totalAmountInCart;
	 	            	        	System.out.println("-----------------------------------");
	 	   		                    System.out.println("Total Amount of Cart is : "+FinalAmount);
	 	   		                    System.out.println("-----------------------------------");
	 	            	        	 
	 	            	         }
	 	            	
			 	               
				break;
			}
			case 6:{
				System.exit(0);
			}
			default:
			System.out.println("Enter the valid choice:");
			}
		}while(true);
	   
	 }catch ( Exception e ) {
		 e.printStackTrace();
	 }
   }
}