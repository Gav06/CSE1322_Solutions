package Assignment4;

public abstract class Car {

    private int id;
    private static int nextId = 0;

    public Car() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }
}