//Class for taking Inputs and Showing Outputs
package Marksheet;

import java.util.Scanner;

public class MainClass{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Scanner scanFull = new Scanner(System.in);
		Marksheet marksheet = new Marksheet();

		int choice = 0, n;
		int grades[] = {};
		String studentName[] = {};

		try {
			System.out.println("Enter Total number of Students : ");
			n = sc.nextInt();
			if (n <= 0) {
				throw new ArithmeticException();
			}

			studentName = new String[n];
			grades = new int[n];

			for (int i = 0; i < n; i++) {
				System.out.println("Enter Student " + (i + 1) + " Name : ");
				studentName[i] = scanFull.nextLine();
				if (studentName[i].equals(null) || studentName[i].equals(" ")
						|| !(marksheet.isValid(studentName[i]))) {
					throw new NullPointerException();
				}
				System.out.println("Enter Grade " + (i + 1) + " for "
						+ studentName[i] + " : ");
				grades[i] = sc.nextInt();
				if (grades[i] < 0 && grades[i] > 100) {
					throw new Exception("Out of range");
				}
			}

		} catch (ArithmeticException e) {
			System.out
					.println("Number of Students cannot be negative or Zero !! Please Input correctly !! ");
			sc.next();
		} catch (NullPointerException e1) {
			System.out.println("Student Name cannot be Null");
			scanFull.next();
		} catch (Exception e3) {
			System.out.println("Range of Grades should be between (0-100)");
			sc.next();
		}

		do {
			System.out.println("1. Average");
			System.out.println("2. Maximum");
			System.out.println("3. Minimum");
			System.out.println("4. Percentage Student Passed");
			System.out.println("5. Exit");

			try {
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter correct inoput");
				sc.next();
			}
			switch (choice) {
			case 1: {
				System.out.println("Average of Grades : ");
				float average =marksheet.Average(grades);
				System.out.printf("%.2f",average);
				System.out.println();
				break;
			}
			case 2: {
				System.out.println("Maximum of Grades : "
						+ marksheet.MaximumGrade(grades));
				break;
			}
			case 3: {
				System.out.println("Minimum of Grades : "
						+ marksheet.MinimumGrade(grades));
				break;
			}
			case 4: {
				System.out.println("Passing percentage of students : ");
				float passPercentage = marksheet.PassedPercentageOfStudents(grades);
				System.out.printf("%.2f",passPercentage);
				System.out.println();
				break;
			}
			case 5: {
                 System.exit(0);
				 break;
			}
			default: {
				System.out.println("Invalid choice");
			}
			}
		} while (true);
	}
}
