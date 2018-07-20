/**Shows Marksheet of List of Students with Some functions :
 *
 *Average(int[]) : int
 *MaximumGrade(int[]) : int
 *MinimumGrade(int[]) : int 
 *PassedPercentageOfStudents(int[]) : int
 */

package Marksheet;

public class Marksheet {

	/**
	 * Function to validate wether String is correctly input or not
	 * 
	 * @param string
	 * @return true if String is valid Or false if Invalid
	 */
	boolean isValid(String string) {
		char CharSequesnce[] = new char[string.length()];

		for (int i = 0; i < string.length(); i++) {
			if (CharSequesnce[i] >= 65 || CharSequesnce[i] <= 90
					|| CharSequesnce[i] >= 97 || CharSequesnce[i] <= 122
					|| CharSequesnce[i] == 32) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Function to calculate Average
	 * 
	 * @param grades
	 * @return average
	 */
	float Average(int grades[]) {
		int sum = 0;
		float average = 0;

		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		average = (float) (sum / grades.length);

		return average;
	}

	int MaximumGrade(int grades[]) {
		int maximum = 0;

		for (int i = 0; i < grades.length; i++) {
			if (maximum < grades[i]) {
				maximum = grades[i];
			}
		}
		return maximum;
	}

	int MinimumGrade(int grades[]) {
		int minimum = grades[0];

		for (int i = 0; i < grades.length; i++) {
			if (minimum > grades[i]) {
				minimum = grades[i];
			}
		}
		return minimum;
	}

	float PassedPercentageOfStudents(int grades[]) {
		float percentage = 0;
		int count = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 40) {
				count++;
			}
		}
		percentage = (float) ((count / grades.length) * 100);
		return percentage;
	}
}