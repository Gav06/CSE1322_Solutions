package Assignment3;

public class Item {
    private static int nextId = 0;
    private final int id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.id = nextId++;
        this.name = name;
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return String.format("Item: %s (#%d) | Price: $%.2f", name, id, price);
    }
}