import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cart {
    public void displayCartContents() {
        try {
            File cartFile = new File("D:/ekartt.txt");
            Scanner cartScanner = new Scanner(cartFile);

            while (cartScanner.hasNextLine()) {
                System.out.println(cartScanner.nextLine());
            }

            cartScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        StringBuilder orderDetails = new StringBuilder();

        try {
            File cartFile = new File("D:/ekartt.txt");
            Scanner cartScanner = new Scanner(cartFile);

            while (cartScanner.hasNextLine()) {
                String line = cartScanner.nextLine();
                orderDetails.append(line).append("\n");
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String priceStr = parts[1].trim().substring(8); // Extracting the price from "Price: $XXX.XX"
                    double price = Double.parseDouble(priceStr);
                    total += price;
                }
            }

            orderDetails.append("Total price: $").append(total);
            cartScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File orderFile = new File("D:/order.txt");
            FileWriter writer = new FileWriter(orderFile);
            writer.write(orderDetails.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the order.");
            e.printStackTrace();
        }

        return total;
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.displayCartContents();
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total price: $" + totalPrice);
    }
}
