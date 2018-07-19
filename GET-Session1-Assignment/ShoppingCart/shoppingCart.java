//Class to add Product along with details in the cart

package ShoppingCart;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class shoppingCart {
	 static Scanner sc = new Scanner(System.in);
	 ArrayList<Object> cart = new ArrayList<Object>();
	
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
 * Function to remove product with details
 * @param index
 */
       void removeItem(int index){
    	   cart.remove(index);
       }
 
/**
 * Function to show Product along with details
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
    	   int i=0,totalAmount=0;
    	   while(iterator.hasNext()){
    		
    		  Product product = (Product)cart.get(i);
    		  
    		  totalAmount += (product.getPrice())*(product.getQuantity());
    		  i++;
    		  iterator.next();
    	   }
    	return totalAmount;   
       }
       
       
   public static void main(String args[]){
	  
	
	  
	   int choice,i=0;
	   shoppingCart obj = new shoppingCart();
	   
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
				System.out.println("Total Amount of Cart is : "+totalAmountInCart);
				break;
			}
			case 6:{
				System.exit(0);
			}
			default:
			System.out.println("Enter the valid choice:");
			}
		}while(true);
	   
   }
}
