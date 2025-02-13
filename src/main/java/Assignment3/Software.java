package Assignment3;

public class Software extends Item {
    private String publisher;

    public Software(String name, double price, String publisher) {
        super(name, price);
        setPublisher(publisher);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher.isEmpty()) {
            this.publisher = "Unknown";
        } else {
            this.publisher = publisher;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tPublisher: " + publisher;
    }
}