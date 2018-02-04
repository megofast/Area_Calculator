import java.util.Scanner;
import static java.lang.Math.PI;

public class Area_Calculator {
    public static void main(String args[]) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("Select an option to calculate area.");
            System.out.println("1. Circle");
            System.out.println("2. Square");
            System.out.println("3. Rectangle");
            System.out.println("4. Triangle");
            System.out.println("5. Exit");
            System.out.print("Make your selection: ");

            try {       // Check to make sure the user entered an integer
                input = Integer.valueOf(scanner.next());
            } catch(Exception e) {      // The user did not enter an integer, default to 0 to try again
                input = 0;
            }

            if (input < 1 || input > 5) {
                System.out.println("Invalid entry, please try again.");
            } else {
                switch (input) {
                    case 1:
                        System.out.println("The area of your circle is " + circle(scanner));
                        break;
                    case 2:
                        System.out.println("The area of your square is " + square(scanner));
                        break;
                    case 3:
                        System.out.println("The area of your rectangle is " + rectangle(scanner));
                        break;
                    case 4:
                        System.out.println("The area of your triangle is " + triangle(scanner));
                        break;
                    case 5:
                        loop = false;
                        break;
                    default:
                        System.out.println("There was an error, try again.");
                }
            }
        } while (loop == true);
    }

    // check_double will ensure the user enters a valid double number and returns the number
    public static double check_double(String text, Scanner scan) {
        double value = 0;
        boolean loop = false;

        do {
            try {       // Try to parse the user input to a double
                value = Double.valueOf(text);
                loop = false;
            } catch (Exception e) {         // Parsing failed, ask the user to try again
                loop = true;
                System.out.print("Please try again: ");
                text = scan.next();
            }
        } while (loop == true);
        return value;
    }

    // circle will calculate the area of a circle
    public static double circle(Scanner scan) {
        double radius, area;

        System.out.print("Please enter the radius of the circle: ");
        radius = check_double(scan.next(), scan);
        area = (radius * radius) * PI;
        return area;
    }

    // Square will calculate the area of a square
    public static double square(Scanner scan) {
        double length, area;

        System.out.print("Please enter the length of the sides: ");
        length = check_double(scan.next(), scan);
        area = length * length;
        return area;
    }

    // Rectangle will calculate the area of a rectangle
    public static double rectangle(Scanner scan) {
        double side1, side2, area;

        System.out.print("Please enter the length of side 1: ");
        side1 = check_double(scan.next(), scan);
        System.out.print("Please enter the length of side 2: ");
        side2 = check_double(scan.next(), scan);
        area = side1 * side2;
        return area;
    }

    // Triangle will calculate the area of a triangle
    public static double triangle(Scanner scan) {
        double side1, side2, area;

        System.out.print("Please enter the length of side 1: ");
        side1 = check_double(scan.next(), scan);
        System.out.print("Please enter the length of side 2: ");
        side2 = check_double(scan.next(), scan);
        area = (side1 * side2) / 2;
        return area;
    }
}
