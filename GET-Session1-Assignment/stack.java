//Array implementation of stack

import java.util.Scanner;

public class stack {
	
	static int sizeOfArray,top=-1;
	static int stack[];
	
/**
* Operation : push(element) 
* @param element is the value to be pushed in the stack 
*/	
	void push(int element){
		
		//Checking Overflow
		if(top == (stack.length)-1){
			System.out.println("Stack Overflow");
		}else{
			top++;
			stack[top] = element;
			System.out.println("Element Inserted in stack at Position "+top+" --> "+element);
		}
	}

/**
 * Operation : pop()	
 */
	void pop(){
		
		//Checking Underflow
		if(top == -1){
			System.out.println("Stack Underflow");
		}else{
			top--;
			System.out.println("Element Poped Success !!");
		}
	}

/**
 * show() : Display stack elements	
 * check if stack isEmpty()
 */
	void show(){
		int show = top;
		if(show == -1){
			System.out.println("Stack is Empty");
		}else{
			while(show >= 0){
				System.out.println("Stack Element at Position "+show+" --> "+stack[show]);
				show--;
			}
		}
		
	}
	
  public static void main(String args[]){
	  
	  int choice;
	  Scanner sc = new Scanner(System.in);
	  stack st = new stack();
	  
	  System.out.println("Enter the size of Array : ");
	  sizeOfArray = sc.nextInt();
	  stack = new int[sizeOfArray];
	  
	  do{
			System.out.println("1. Push(element)");
			System.out.println("2. Pop()");
			System.out.println("3. show() or check stack isEmpty()");
			System.out.println("4. EXIT");
			
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:{
				System.out.println("Enter the element to be pushed:");
				st.push(sc.nextInt());
				break;
			}
			case 2:{
				st.pop();
				break;
			}
			case 3:{
				st.show();
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
