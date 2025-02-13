package Lab4;

public class ParkWallet {

    private int tickets;
    private static boolean holiday = false;

    public ParkWallet() {
        this(0);
    }

    public ParkWallet(int tix) {
        this.tickets = tix;
    }

    public int getTickets() {
        return tickets;
    }

    public static boolean isHoliday() {
        return holiday;
    }

    public void setTickets(int amount) {
        if (amount >= 0) {
            tickets = amount;
        }
    }

    public static void toggleHoliday() {
        holiday = !holiday;
    }

    public void addTickets(int tix) {
        if (tix > 0) {
            this.tickets += tix;
        }
    }

    public boolean removeTickets(int tix) {
        if (tix > 0 && tickets - tix >= 0) {
            tickets -= tix;
            return true;
        }

        return false;
    }
}
