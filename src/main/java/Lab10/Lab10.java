package Lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab10 {

    public static void main(String[] args) {
        System.out.println("[Alarm System]");
        System.out.println("1. Create new alarm");
        System.out.println("2. View all alarms");
        System.out.println("3. Quit");

        final ArrayList<Alarm> alarms = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // iterate through a copy of alarms,
            // to avoid a concurrentmodificationexception

            System.out.print("Enter option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            alarms.removeIf(a -> a.getState() == Thread.State.WAITING);

            switch (choice) {
                case 1:
                    // create new alarm
                    System.out.print("Enter alarm name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter alarm timer in seconds: ");
                    int seconds = Integer.parseInt(scanner.nextLine());

                    Alarm a = new Alarm(name, seconds);
                    alarms.add(a);
                    System.out.println(a);
                    a.start();
                    break;
                case 2:
                    // view all alarms
                    if (alarms.isEmpty()) {
                        System.out.println("There are no alarms currently running.");
                        break;
                    }

                    System.out.println("Here are all the alarms still running:");
                    for (Alarm alarm : alarms) {
                        System.out.println(alarm);
                        System.out.println(alarm.getState().toString());
                    }

                    break;
                case 3:
                    // quit
                    running = false;
                    if (!alarms.isEmpty()) {
                        System.out.println("Stopping all alarms...");
                        for (Alarm alarm : alarms) {
                            alarm.interrupt();
                        }
                        alarms.clear();
                    }
                    break;
                default:
                    System.out.println("Invalid option entered.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Shutting off...");

    }
}
