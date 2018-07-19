import java.util.Scanner;


public class palindromeUsingStack {
	static int top=-1;
	static char stack[]; 

	
/**
* Operation : push(character) 
* @param character is the value to be pushed in the stack 
*/	
		void push(char character){
			
			top++;
			stack[top] = character;
			System.out.println("Character Inserted in stack at Position "+top+" --> "+character);
			
		}

		
/**
* Operation : pop()	
* @return popedItem
*/
		char pop(){
		 
		 char popedItem = stack[top];
		 System.out.println("Element Poped Success !! At position "+top+" --> "+popedItem);
		 top--;
		 return popedItem;
		 
		}
		
		
     public static void main(String args[]){
    	 
    	 Scanner sc = new Scanner(System.in);
    	 palindromeUsingStack palindrome = new palindromeUsingStack();
    	 String stringPoped = "";
    	 System.out.println("Enter the String to be Checked Palindrome OR NOT a Palindrome : ");
         String stringPushed = sc.next();
         stack = new char[stringPushed.length()];
         
         for(int i=0 ; i<stack.length ; i++)
        	 palindrome.push(stringPushed.charAt(i));
         
         for(int i=0 ; i<stack.length ; i++)
         stringPoped += palindrome.pop();
         
         if(stringPushed.equals(stringPoped))
        	 System.out.println("String is a Palindrome");
         else
        	 System.out.println("String is !! NOT !! a Palindrome");
     }
}
