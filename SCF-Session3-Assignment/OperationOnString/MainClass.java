//Class for running the Output and test the functionallity according to user Input
package OperationOnString;

import java.util.Scanner;

public class MainClass {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		OperationOnString operation = new OperationOnString();
		int choice = 0;
		Scanner stringinput = new Scanner(System.in);

		do {

			System.out.println("1. Compare");
			System.out.println("2. Reverse");
			System.out.println("3. Case Change");
			System.out.println("4. Find Largest word");
			System.out.println("5. Exit");

			try {
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out
						.println("Enter your choice in Integer i.e, digits from 1 to 5 And Enter correct Input");
				sc.next();
			}
			switch (choice) {
			case 1: {
				String string1 = "", string2 = "";

				try {

					System.out.println("Enter two strings : ");
					string1 = stringinput.nextLine();
					string2 = stringinput.nextLine();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Enter Something Please !!");

				}
				int compareString = operation.CompareStrings(string1, string2);
				if (compareString == 1) {
					System.out.println("Both Strings are Same");
				} else {
					System.out.println("Both Strings are !!NOT!! Same");
				}
				break;
			}
			case 2: {
				String string = "";
				try {

					System.out.println("Enter the string : ");
					string = stringinput.nextLine();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Enter Something Please !!");

				}
				String newReversedString = operation.reverseString(string);
				System.out.println("Reversed String is : " + newReversedString);
				break;
			}
			case 3: {
				String string = "";
				try {
					System.out.println("Enter the string : ");
					string = stringinput.nextLine();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Enter Something Please !!");

				}
				String NewString = operation.CaseChange(string);
				System.out.println("Case changed String is : " + NewString);
				break;
			}
			case 4: {
				String string = "";
				try {
					System.out.println("Enter the string : ");
					string = stringinput.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Enter Something Please !!");
				}
				System.out.println(operation.LongestWordFromString(string));
				break;
			}
			case 5: {
				System.exit(0);
			}
			default: {
				System.out.println("Invalid choice");
			}
			}
		} while (true);

	}
}