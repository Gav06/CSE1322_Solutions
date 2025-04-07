package Lab10;

public class Alarm extends Thread {

    private static int nextId = 1;

    // stored in millis
    private int timer;

    private final String name;
    private final int id;

    public Alarm(String s, int i) {
        this.timer = i * 1000;
        this.id = nextId++;

        if (s == null || s.isEmpty()) {
            this.name = "Alarm " + this.id;
        } else {
            this.name = s;
        }
    }

    @Override
    public void run() {
        try {
            while (timer > 0) {
                System.out.println(this.name + " will go off in " + (timer / 1000) + " seconds");
                sleep(1000L);
                timer -= 1000;
            }

            System.out.println(this.name + " has gone off!");
            this.join();
        } catch (InterruptedException e) {
            if (this.timer > 0) {
                System.out.println(this.name + " has been interrupted at " + (timer / 1000) + " seconds.");
            }
        }
    }

    @Override
    public String toString() {
        return name + " is currently at " + (timer / 1000) + " seconds";
    }
}
