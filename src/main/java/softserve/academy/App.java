package softserve.academy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();
        Triangle triangle;
        String answer = "y";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter triangle info following the pattern: <name>, <side>, <side>, <side> : ");
            String input = scanner.nextLine();

            if (!checkForCommas(input)) {
                System.out.println("Incorrect input! ");
            } else {
                String[] parsedInput = parseInput(input);
                try {
                    triangle = Triangle.createTriangle(parsedInput);
                    triangles.add(triangle);
                    System.out.println("Do you want to add another triangle? (y/yes or n/no)");
                    answer = scanner.nextLine();
                } catch (NumberFormatException ex) {
                    System.out.println("Check the input. Sizes must be numbers");
                } catch (IllegalArgumentException ex) {
                    System.out.println("Check the input. These cannot be sides of a triangle");
                }
            }
        }
        while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));

        triangles.sort(Comparator.comparing(Triangle::getSquare));
        for (Triangle tr : triangles) {
            System.out.println(tr);
        }
    }

    private static boolean checkForCommas(String input) {
        Pattern pattern = Pattern.compile(",");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count == 3;
    }

    private static String[] parseInput(String input) {
        String[] inputArr = input.split(",");
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputArr[i].trim();
        }
        return inputArr;
    }
}
