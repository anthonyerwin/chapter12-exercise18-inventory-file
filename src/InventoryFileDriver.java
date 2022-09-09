import java.util.Scanner;

public class InventoryFileDriver {
    public static void main(String[] args) {
        displayAppMenu();

    } // end method main
    
    public static void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        final int STOCK_ID_FORMAT = 1000;
        int menuChoice = 0;

        System.out.println();
        System.out.println("Welcome to Chapter 12 Exercise 18 Sports Store!");

        try {
            do {
                System.out.println();
                System.out.println("Inventory App Menu: ");
                System.out.println("[1] Add an Item");
                System.out.println("[2] Discontinue an Item");
                System.out.println("[3] Display an Item Stock Amount");
                System.out.println("[4] Exit");

                System.out.print("Enter menu choice: ");
                menuChoice = Integer.valueOf(scanner.nextLine());

                switch(menuChoice) {
                    case 1 -> {
                        int stockId = 0;
                        String itemName = "";
                        int stockAmount = 0;

                        do {
                            System.out.print("Enter Item Name: ");
                            itemName = scanner.nextLine();

                        } while(itemName.isEmpty());

                        do {
                            try {
                                System.out.print("Enter Initial Stock Amount: ");
                                stockAmount = Integer.valueOf(scanner.nextLine());

                            } catch(Exception e) {
                                System.out.println("Input a valid Stock Amount.");
                                stockAmount = 0;
                            }

                        } while(stockAmount <= 0);

                        // generating stock ID
                        stockId = inventory.getItemList().size() + STOCK_ID_FORMAT;

                        // initializing a new item to be added to list
                        Item item = new Item(stockId, itemName, stockAmount);
                        System.out.println();
                        System.out.println("Item added to Inventory: ");
                        inventory.addItem(item);
                    }

                    case 2 -> {
                        if(inventory.getItemList().size() == 0) {
                            System.out.println("No items in the inventory.");
                            
                        } else {
                            int stockId = 0;
                            
                            // prompt and validation to discontinue an item using stock ID
                            try {
                                do {
                                    try {
                                        System.out.print("Enter Stock ID to Discontinue: ");
                                        stockId = Integer.valueOf(scanner.nextLine());

                                    } catch(Exception e) {
                                        System.out.println("Input a valid Stock ID.");
                                        stockId = 0;
                                    }

                                } while(stockId <= 0);

                                inventory.discontinueItem(inventory.getItemList().get(stockId - STOCK_ID_FORMAT));
                                System.out.println("Discontinued Stock ID: " + stockId);

                            } catch(Exception e) {
                                System.out.println(e);
                                System.out.println("No Stock ID match.");
                            }
                        }
                    }

                    case 3 -> {
                        if(inventory.getItemList().size() == 0) {
                            System.out.println("No items in the inventory.");

                        } else {
                            // iterates through all items and displays each using displayItem method
                            inventory.getItemList().forEach((item) -> {inventory.displayItem(item);});
                        }
                    }

                    default -> {break;}
                }

            } while(menuChoice != 4);
            System.out.println("Inventory App Exit. Thank you!");

        } catch(Exception e) {
            System.out.println("Invalid input. Please choose from [1] to [4].");
            displayAppMenu();
        }

        scanner.close();
    }
}
