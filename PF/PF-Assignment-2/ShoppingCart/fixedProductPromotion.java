//class for fixed product promotion in the cart

package ShoppingCart;

import java.text.SimpleDateFormat;
import java.util.Date;


public class fixedProductPromotion implements Promotion {

    private int discount;
    private int minPrice;
    
    public void setFixedDiscount(int discount) {
		this.discount = discount;
	}

	public void setMinimumPrice(int minPrice) {
	    this.minPrice = minPrice;	
	}
	
	public int getFixedDiscount() {
	return this.discount;
	}

	public int getMinimumPrice() {
	 return this.minPrice;	
	}

	/**
	 * Take the promocode and current date as parameter and check wether the promocode is applicable or not
	 * @param code
	 * @param currentDate
	 * @return true or false
	 */	
	public boolean isPromotionApplicable(String code,Date currentDate) {
	
	promotionEnum promotionenum = new promotionEnum();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	long start = 0;
	long end = 0;
	long current = 0;
	
	         try{
	             Date startDate = simpleDateFormat.parse(promotionenum.startDate);
	             Date endDate = simpleDateFormat.parse(promotionenum.endDate);
	
	             start = startDate.getTime();
                 end = endDate.getTime();
                 current = currentDate.getTime();
	
                 System.out.println(start +"  "+end+"  "+current);
	            }catch(Exception e){
		         e.printStackTrace();
	            }
	
	 if((promotionenum.code).equals(code) && current < end && current > start){
			return true;
     }
	 
   return false;
	
  }
}
