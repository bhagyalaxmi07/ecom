package E_commerce_Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Email {
    private String name = "User";

    public void importAmount() {
        String filePath = "D:\\order.txt";
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void sendConfirmationEmail() {
        LocalDate currentDate = LocalDate.now();
        String message = "Order confirmed on " + currentDate + ".\nThank you for your order \nRegards";

        System.out.println(message);
    }

    public static void main(String[] args) {
        Email email = new Email();
        email.importAmount();
        email.sendConfirmationEmail();
    }
}
