import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {
    private String name;
    private List<String> subcategories;

    public Category(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>();
    }

    public void addSubcategory(String subcategory) {
        subcategories.add(subcategory);
    }

    public List<String> getSubcategories() {
        return subcategories;
    }

    public static void main(String[] args) {
        Category electronics = new Category("Electronics");
        electronics.addSubcategory("Mobile_Phones");
        electronics.addSubcategory("Laptops");
        electronics.addSubcategory("Televisions");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Electronics subcategories:");
            for (int i = 0; i < electronics.getSubcategories().size(); i++) {
                System.out.println((i + 1) + ". " + electronics.getSubcategories().get(i));
            }

            System.out.print("Enter the number of the subcategory you want to choose (0 to exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice > 0 && choice <= electronics.getSubcategories().size()) {
                String selectedSubcategory = electronics.getSubcategories().get(choice - 1);
                System.out.println("You selected: " + selectedSubcategory);

                try {
                    File file = new File("D:/" + selectedSubcategory.toLowerCase().replace(" ", "") + ".txt");

                    FileWriter writer = new FileWriter("D:/ekartt.txt", true);

                    Scanner fileScanner = new Scanner(file);
                    System.out.println("Brands and Prices for " + selectedSubcategory + ":");

                    List<String> brands = new ArrayList<>();
                    List<Double> prices = new ArrayList<>();
                    int brandNumber = 1;
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split(",");
                        System.out.println(brandNumber + ". " + parts[0] + ", Price: $" + parts[1]);
                        brands.add(parts[0]);
                        prices.add(Double.parseDouble(parts[1]));
                        brandNumber++;
                    }

                    System.out.print("Enter the number of the brand you want to add to cart: ");
                    int brandChoice = scanner.nextInt();

                    if (brandChoice > 0 && brandChoice <= brands.size()) {
                        String selectedBrand = brands.get(brandChoice - 1);
                        System.out.print("Enter the quantity: ");
                        int quantity = scanner.nextInt();

                        double amount = prices.get(brandChoice - 1) * quantity;
                        writer.write(selectedBrand + ", Price: $" + prices.get(brandChoice - 1) + ", Quantity: " + quantity + ", Amount: $" + amount + "\n");
                        System.out.println("Added to cart: " + selectedBrand + ", Price: $" + prices.get(brandChoice - 1) + ", Quantity: " + quantity + ", Amount: $" + amount);
                    } else {
                        System.out.println("Invalid brand choice");
                    }

                    writer.close();
                    fileScanner.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid choice");
            }
        }

        try {
            File cartFile = new File("D:/ekartt.txt");

            while (true) {
                System.out.println("Current items in cart:");
                Scanner cartScanner = new Scanner(cartFile);

                List<String> lines = new ArrayList<>();
                int lineNumber = 1;
                while (cartScanner.hasNextLine()) {
                    String line = cartScanner.nextLine();
                    lines.add(line);
                    System.out.println(lineNumber + ". " + line);
                    lineNumber++;
                }

                cartScanner.close();

                System.out.print("Enter the number of the item you want to remove (0 to cancel): ");
                int removeChoice = scanner.nextInt();

                if (removeChoice == 0) {
                    break;
                }

                if (removeChoice > 0 && removeChoice <= lines.size()) {
                    lines.remove(removeChoice - 1);

                    FileWriter writer = new FileWriter("D:/ekartt.txt");
                    for (String line : lines) {
                        writer.write(line + "\n");
                    }
                    writer.close();

                    System.out.println("Item removed successfully.");
                } else {
                    System.out.println("Invalid item choice");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
