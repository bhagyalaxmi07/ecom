
package E_commerce_Application;
import java.util.Scanner;

public class CancelOrder {
    private Scanner scanner;

    public CancelOrder() {
        this.scanner = new Scanner(System.in);
    }

    public void cancelOrder() {
        System.out.print("Do you want to cancel the order? (yes/no): ");
        String cancelChoice = scanner.nextLine();

        switch (cancelChoice.toLowerCase()) {
            case "yes":
                System.out.println("Select a reason for cancellation:");
                System.out.println("1. Delayed delivery");
                System.out.println("2. I have changed my mind");
                System.out.println("3. Other reasons");
                int reasonChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (reasonChoice) {
                    case 1:
                        System.out.println("Cancellation due to delayed delivery.");
                        break;
                    case 2:
                        System.out.println("Cancellation due to change of mind.");
                        break;
                    case 3:
                        System.out.print("Enter the reason for cancellation: ");
                        String otherReason = scanner.nextLine();
                        System.out.println("Cancellation reason: " + otherReason);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case "no":
                System.out.println("Order not cancelled.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public static void main(String[] args) {
        CancelOrder cancelOrder = new CancelOrder();
        cancelOrder.cancelOrder();
    }
}