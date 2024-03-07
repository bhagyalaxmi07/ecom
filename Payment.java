import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Payment {
    private String paymentMethod;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Cash");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                enterCreditCardDetails(scanner);
                break;
            case 2:
                enterDebitCardDetails(scanner);
                break;
            case 3:
                enterCashDetails();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                makePayment();
                break;
        }

        displayAmountFileContents();
        System.out.println("Payment successful.");
    }

    private void enterCreditCardDetails(Scanner scanner) {
        System.out.println("Enter credit card number:");
        cardNumber = scanner.nextLine();
        System.out.println("Enter CVV:");
        cvv = scanner.nextLine();
        System.out.println("Enter expiry date:");
        expiryDate = scanner.nextLine();
    }

    private void enterDebitCardDetails(Scanner scanner) {
        System.out.println("Enter debit card number:");
        cardNumber = scanner.nextLine();
        System.out.println("Enter CVV:");
        cvv = scanner.nextLine();
        System.out.println("Enter expiry date:");
        expiryDate = scanner.nextLine();
    }

    private void enterCashDetails() {
        // No details required for cash payment
    }

    private void displayAmountFileContents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D://order.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading amount file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.makePayment();
    }
}
