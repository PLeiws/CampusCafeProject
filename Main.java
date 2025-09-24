package campusCafee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();
//	Introduction to menu
        System.out.println("Welcome to the Store!");

        boolean running = true;
        while (running) {
            menu.display();
            System.out.print("Enter item number (0 to checkout): ");
//	handles and prompts for user choice
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (choice == 0) {
                running = false;
                break;
            }

            if (choice < 1 || choice > menu.getProducts().size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Product base = menu.getProducts().get(choice - 1);
            Product selected = null;

            // portion to ask for beverage size
            if (base instanceof Beverage) {
                System.out.println("Choose size: 1) SMALL  2) MEDIUM  3) LARGE");
                Size size = Size.SMALL; // default
                try {
                    int sizeChoice = Integer.parseInt(sc.nextLine());
                    switch (sizeChoice) {
                        case 2 -> size = Size.MEDIUM;
                        case 3 -> size = Size.LARGE;
                        default -> size = Size.SMALL;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Defaulting to SMALL.");
                }
                selected = new Beverage(base.getId(), base.getName(), base.getBasePrice(), size);
            }
            // Portion to ask for extra cheese
            else if (base instanceof Food) {
                System.out.print("Add extra cheese? (y/n): ");
                boolean extra = sc.nextLine().trim().equalsIgnoreCase("y");
                selected = new Food(base.getId(), base.getName(), base.getBasePrice(), extra);
            }

            // portion to ask for quantity of product
            System.out.print("Enter quantity: ");
            int qty;
            try {
                qty = Integer.parseInt(sc.nextLine());
                if (qty <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Try again.");
                continue;
            }

            order.addItem(selected, qty);
            System.out.println("Added to order: " + selected.getDisplayName() + " x" + qty);
        }

        // Checkout and receit portion
        System.out.println("\n=== RECEIPT ===");
        for (LineItem li : order.getItems()) {
            System.out.printf("%s x%d - $%.2f%n",
                    li.getProduct().getDisplayName(),
                    li.getQuantity(),
                    li.lineTotal());
        }
        System.out.printf("Subtotal: $%.2f%n", order.subtotal());
        System.out.printf("Tax: $%.2f%n", order.tax());
        System.out.printf("Total: $%.2f%n", order.total());

        sc.close();
    }
}
