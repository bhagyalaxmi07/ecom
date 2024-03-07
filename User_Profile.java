import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User_Profile {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter details for user " + i + " or type 'exit' to stop:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Language: ");
            String lang = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();

            // Write user details to a file
            String fileName = "D://user" + i + ".txt";
            FileWriter fw = new FileWriter(fileName, true); // true for append mode
            fw.write("Name: " + name + "\n");
            fw.write("Language: " + lang + "\n");
            fw.write("Email: " + email + "\n");
            fw.write("Phone Number: " + phoneNumber + "\n");
            fw.write("Address: " + address + "\n\n");
            fw.close();
        }
        scanner.close();
    }
}
