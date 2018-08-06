package nestedList;


public class Main {
public static void main(String args[]){
	
	Input input = new Input();
	
	ReadAndPerformOperations read = new ReadAndPerformOperations(input.inputInObject());

	
	System.out.println("Sum : "+read.getSum());
	System.out.println("Largest : "+read.getLargest());
	System.out.println("Search : "+read.Search(2));
	System.out.println("ExtractedElement : "+read.getValue("TTHH"));
	
	
	
}
}
