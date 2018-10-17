package softserve.academy;

import java.text.DecimalFormat;

public class Triangle implements Comparable<Triangle> {
    private String name;
    private double side1;
    private double side2;
    private double side3;
    private double square;

    private Triangle(String name, double side1, double side2, double side3) {
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private static boolean isTriangle(double side1, double side2, double side3) {
        return (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1);
    }

    static Triangle createTriangle(String[] parsedInput) throws IllegalArgumentException {
        String name = parsedInput[0];
        double side1 = Double.parseDouble(parsedInput[1]);
        double side2 = Double.parseDouble(parsedInput[2]);
        double side3 = Double.parseDouble(parsedInput[3]);

        if (isTriangle(side1, side2, side3)) {
            return new Triangle(name, side1, side2, side3);
        } else {
            throw new IllegalArgumentException();
        }
    }

    double getSquare() {
        if (square == 0) {
            square = calculateSquare();
        }
        return square;
    }

    private double calculateSquare() {
        double semiPerimeter = getSemiPerimeter();
        double diff1 = semiPerimeter - side1;
        double diff2 = semiPerimeter - side2;
        double diff3 = semiPerimeter - side3;

        return Math.sqrt(semiPerimeter * diff1 * diff2 * diff3);
    }

    private double getSemiPerimeter() {
        return (side1 + side2 + side3) / 2;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String square = df.format(getSquare());
        return "[" + name + "]: " +
                square + " cm";
    }

    @Override
    public int compareTo(Triangle triangle) {
        double t1Square = this.getSquare();
        double t2Square = triangle.getSquare();
        return Double.compare(t1Square, t2Square);
    }
}
