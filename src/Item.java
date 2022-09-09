import java.io.Serializable;

public class Item implements Serializable {
    private int stockId;
    private String itemName;
    private int stockAmount;

    public Item(int stockId, String itemName, int stockAmount) {
        this.stockId = stockId;
        this.itemName = itemName;
        this.stockAmount = stockAmount;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
