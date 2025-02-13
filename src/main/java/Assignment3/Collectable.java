package Assignment3;

public class Collectable extends DigitalGood {
    private String type;

    public Collectable(String name, double price, String description, String type) {
        super(name, price, description);
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        switch (type) {
            case "emoticon":
            case "avatar":
            case "background":
                this.type = type;
                break;
            default:
                this.type = "nothing";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tCan be used as " + type;
    }
}