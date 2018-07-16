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
       
   public static void main(String args[]){
	  
	
	  
	   int choice,i=0;
	   shoppingCart obj = new shoppingCart();
	   
	   do{
			System.out.println("1. Add Product and Details");
			System.out.println("2. Remove Product and Details");
			System.out.println("3. Show items in the cart");
			System.out.println("4. EXIT");
			
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
				System.exit(0);
			}
			default:
			System.out.println("Enter the valid choice:");
			}
		}while(true);
	   
   }
}
