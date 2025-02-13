package Assignment3;

public class Tradable extends DigitalGood {
    private int saleDelay;

    public Tradable(String name, double price, String description, int saleDelay) {
        super(name, price, description);
        setSaleDelay(saleDelay);
    }

    public int getSaleDelay() {
        return saleDelay;
    }

    public void setSaleDelay(int saleDelay) {
        if (saleDelay >= 0) {
            this.saleDelay = saleDelay;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tItem can only be sold after being owned for " + saleDelay + " days";
    }
}