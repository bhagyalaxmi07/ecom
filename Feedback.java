/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E_commerce_Application;
import java.util.Scanner;

public class Feedback {
    private Scanner scanner;

    public Feedback() {
        this.scanner = new Scanner(System.in);
    }
    public void review() {
        int userReview;
        do {
            System.out.print("Enter your review (1-Lowest to 5-Highest): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // consume non-integer input
            }
            userReview = scanner.nextInt();

            // Additional messages based on user input
            switch (userReview) {
                case 0:
                case 1:
                case 2:
                    System.out.println("Let us know what went wrong:");
                    break;
                case 3:
                case 4:
                    System.out.println("What could be done better:");
                    break;
                case 5:
                    System.out.println("Hope you liked our product");
                    System.out.println("do you want to give any feedback of this product:");
                    break;
            }
        } while (userReview < 1 || userReview > 5);

        
    }

    // Method for the user to provide product feedback (string input)
    public void productFeedback() {
        scanner.nextLine(); // Consume the newline character left by nextInt()
        String productFeedback = scanner.nextLine();
        System.out.println("Thank you for your feedback. We really appreciate it!");
    }

    // Close the Scanner object
    public void closeScanner() {
        scanner.close();
    }

    // Main method for testing the Feedback class
    public static void main(String[] args) {
        // Create a feedback instance
        Feedback feedback = new Feedback();

        // Get user review
        feedback.review();

        // Get product feedback
        feedback.productFeedback();

        // Close the scanner when done
        feedback.closeScanner();
    }
}