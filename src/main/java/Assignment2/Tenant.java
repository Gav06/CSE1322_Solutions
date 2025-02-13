package Assignment2;

public class Tenant {

    public String name;
    public double rent;
    public int age;

    public Tenant(String name, int age, double rent) {
        this.name = name;
        this.rent = rent;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ") | $" + rent + "/mo";
    }
}
