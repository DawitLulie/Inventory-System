import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Item> items = new ArrayList<>();

    // Add item
    public void addItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter item's name: ");
        String name = input.nextLine();

        System.out.println("Enter item's price: ");
        double price = input.nextDouble();

        System.out.println("Enter item's quantity: ");
        int quantity = input.nextInt();
        input.nextLine(); // consume leftover newline

        items.add(new Item(name, quantity, price));
        System.out.println("Item added successfully!\n");
    }

    // Remove item
    public void removeItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter item's name to remove: ");
        String name = input.nextLine();

        Item foundItem = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                foundItem = item;
                break;
            }
        }

        if (foundItem != null) {
            items.remove(foundItem);
            System.out.println("Item removed successfully!\n");
        } else {
            System.out.println("Item not found!\n");
        }
    }

    // Display all items
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.\n");
            return;
        }
        System.out.println("Items in Inventory:");
        for (Item item : items) {
            System.out.println("Name: " + item.getName() +
                    ", Quantity: " + item.getQuantity() +
                    ", Price: " + item.getPrice());
        }
        System.out.println();
    }

    // Show total number of items
    public void totalItems() {
        System.out.println("Total items in inventory: " + items.size() + "\n");
    }

    // Main menu
    public static void main(String[] args) {
        Main2 system = new Main2();
        Scanner input = new Scanner(System.in); 
        int choice;

        do {
            System.out.println("=== Simple Inventory System ===");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Items");
            System.out.println("4. Total Items");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    system.addItem();
                    break;
                case 2:
                    system.removeItem();
                    break;
                case 3:
                    system.displayItems();
                    break;
                case 4:
                    system.totalItems();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        } while (choice != 5);
    }
}
