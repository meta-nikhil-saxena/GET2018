import java.util.Scanner;

//Computes Area of Triangle,Rectangle,Circle,Square
public class Area {

	/**
	 * Area of Triangle
	 * 
	 * @param height
	 * @param base
	 * @return area
	 */
	double AreaTriangle(double height, double base) {
		double area = (double) (0.5) * (base * height);
		return area;
	}

	/**
	 * Area of Rectangle
	 * 
	 * @param width
	 * @param height
	 * @return area
	 */
	double AreaRectangle(double width, double height) {
		double area = (width * height);
		return area;
	}

	/**
	 * Area of Circle
	 * 
	 * @param radius
	 * @return area
	 */
	double AreaCircle(double radius) {
		double area = (double) ((3.14) * radius * radius);
		return area;
	}

	/**
	 * Area of square
	 * 
	 * @param sides
	 * @return area
	 */
	double AreaSquare(double sides) {
		double area = (double) (sides * sides);
		return area;
	}

	public static void main(String args[]) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		Area area = new Area();

		do {
			try {
				System.out.println("1. Triangle");
				System.out.println("2. Rectangle");
				System.out.println("3. Circle");
				System.out.println("4. Square");
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
					int base, height;
					System.out.println("Enter Base : ");
					base = sc.nextInt();
					if (base <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Enter Height : ");
					height = sc.nextInt();
					if (height <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Triangle : "
							+ area.AreaTriangle(height, base));
					break;
				}
				case 2: {
					int width, height;
					System.out.println("Enter Width : ");
					width = sc.nextInt();
					if (width <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Enter Height : ");
					height = sc.nextInt();
					if (height <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Rectangle : "
							+ area.AreaRectangle(height, width));
					break;
				}
				case 3: {
					int radius;
					System.out.println("Enter Radius : ");
					radius = sc.nextInt();
					if (radius <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Circle : "
							+ area.AreaCircle(radius));
					break;
				}
				case 4: {
					int sides;
					System.out.println("Enter Side : ");
					sides = sc.nextInt();
					if (sides <= 0) {
						throw new ArithmeticException();
					}
					System.out.println("Area of Square : "
							+ area.AreaSquare(sides));
					break;
				}
				case 5: {
					System.exit(0);
				}
				default: {
					System.out.println("Invalid choice");
					break;
				}
				}
			} catch (ArithmeticException e) {
				System.out.println("!! Input cannot be negative or Zero !!");
				continue;
			} catch (Exception e1) {
				System.out.println("Enter valid Input Please !!");
				continue;
			}
		} while (true);

	}
}
