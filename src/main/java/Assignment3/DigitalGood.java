package Assignment3;

public class DigitalGood extends Item {
    private String description;

    public DigitalGood(String name, double price, String description) {
        super(name, price);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tDescription: " + description;
    }
}