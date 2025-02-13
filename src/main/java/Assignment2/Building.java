package Assignment2;

public class Building {

    private Tenant[] apartments;
    private int id;

    private static double balance = 0;
    private static int nextId = 1;

    public Building(int size) {
        this.apartments = new Tenant[size];
        this.id = nextId;
        nextId++;
    }

    public static double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public int countTenants() {
        int count = 0;
        for (Tenant t : apartments) {
            if (t != null)
                count++;
        }

        return count;
    }

    public boolean addTenant(Tenant tenant, int id) {
        if (id > apartments.length - 1 || id < 0)
            return false;

        if (apartments[id] != null)
            return false;

        apartments[id] = tenant;
        return true;
    }

    public boolean removeTenant(int id) {
        if (id > apartments.length - 1 || id < 0)
            return false;

        if (apartments[id] == null)
            return false;

        apartments[id] = null;
        return true;
    }

    public String listTenants() {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < apartments.length; i++) {
            final Tenant tenant = apartments[i];
            sb.append("Apartment ").append(i).append(": ");

            if (tenant == null) {
                sb.append("Empty");
            } else {
                sb.append(tenant);
            }

            sb.append('\n');
        }

        return sb.toString();
    }

    public Tenant getTenant(int id) {
        if (id < 0 || id >= apartments.length)
            return null;

        return apartments[id];
    }

    public static void collectRent(Tenant tenant) {
        balance += tenant.rent;
    }

    public static void payForService(double amount) {
        balance -= amount;
    }
}
