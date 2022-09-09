import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemList;
    private File inventoryText;

    public Inventory() {
        this.itemList = new ArrayList<>();
        this.inventoryText = new File("inventory.txt");
    }

    public void addItem(Item item) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(inventoryText);
    		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
    		
    		objectOutput.writeObject(item);

            itemList.add(item);
            displayItem(item);

            fileOutput.close();
            objectOutput.close();

        } catch(Exception e) {
            System.out.println(e);
		}
    }

    public void discontinueItem(Item item) {
        try {
            item.setItemName("Discontinued");
            item.setStockAmount(0);

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void displayItem(Item item) {
        System.out.println();
        System.out.printf("%s%d%n", "Stock ID: ", item.getStockId());
        System.out.printf("%s%s%n", "Item Name: ", item.getItemName());
        System.out.printf("%s%d%n", "Stock Amount: ", item.getStockAmount());
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
}
