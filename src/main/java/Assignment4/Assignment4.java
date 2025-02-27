package Assignment4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment4 {

    private ArrayList<Car> cars = new ArrayList<>();
    private double balance = 0.0;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Assignment4 driver = new Assignment4();
        driver.run();
    }

    public void run() {
        System.out.println("Gas: $4.00/gal | Electricity: $0.20/kW");
        while (true) {
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addGasCar();
                    break;
                case 2:
                    addElectricCar();
                    break;
                case 3:
                    addHybridCar();
                    break;
                case 4:
                    refuelAllGasEngines();
                    break;
                case 5:
                    rechargeAllElectricEngines();
                    break;
                case 6:
                    refuelAndRechargeAllVehicles();
                    break;
                case 7:
                    displayAllVehicles();
                    break;
                case 8:
                    dispatchAllVehicles();
                    break;
                case 9:
                    System.out.printf("We've made a total of $%.2f today%n", balance);
                    System.out.println("Shutting off...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            printMenu();
        }
    }

    private void printMenu() {
        System.out.println("1. Add gas car");
        System.out.println("2. Add electric car");
        System.out.println("3. Add hybrid car");
        System.out.println("4. Refuel all gas engines");
        System.out.println("5. Recharge all electric engines");
        System.out.println("6. Refuel and recharge all vehicles");
        System.out.println("7. Display all vehicles");
        System.out.println("8. Dispatch all vehicles");
        System.out.println("9. Quit");
    }

    private void addGasCar() {
        int tankCapacity = randRangeInclusive(15, 30); // 15 to 30
        int currentVolume = randRangeInclusive(2, 14); // 2 to 14
        cars.add(new GasCar(tankCapacity, currentVolume));
        System.out.printf("Vehicle %d has parked at pump%n", cars.size() - 1);
    }

    private void addElectricCar() {
        int maxBattery =randRangeInclusive(40, 100); // 40 to 100
        int currentCharge = randRangeInclusive(2, 30); // 2 to 30
        cars.add(new ElectricCar(maxBattery, currentCharge));
        System.out.printf("Vehicle %d has parked at charger%n", cars.size() - 1);
    }

    private void addHybridCar() {
        int maxBattery = randRangeInclusive(40, 100); // 40 to 100
        int currentCharge = randRangeInclusive(2, 30); // 2 to 30
        int tankCapacity = randRangeInclusive(15, 30); // 15 to 30
        int currentVolume = randRangeInclusive(2, 14); // 2 to 14
        cars.add(new HybridCar(maxBattery, currentCharge, tankCapacity, currentVolume));
        System.out.printf("Vehicle %d has parked at pump-charger%n", cars.size() - 1);
    }

    private void refuelAllGasEngines() {
        double totalRefueled = 0.0;
        for (Car car : cars) {
            if (car instanceof GasEngine) {
                GasEngine gasCar = (GasEngine) car;
                double needed = gasCar.getTankCapacity() - gasCar.getCurrentVolume();
                double refueled = gasCar.refuelTank(needed);
                totalRefueled += refueled;
            }
        }
        balance += totalRefueled * 4.0;
        System.out.printf("All gas vehicles refueled. Current balance is $%.2f%n", balance);
    }

    private void rechargeAllElectricEngines() {
        double totalRecharged = 0.0;
        for (Car car : cars) {
            if (car instanceof ElectricEngine) {
                ElectricEngine electricCar = (ElectricEngine) car;
                double needed = electricCar.getMaxBattery() - electricCar.getCurrentCharge();
                double recharged = electricCar.rechargeBattery(needed);
                totalRecharged += recharged;
            }
        }
        balance += totalRecharged * 0.20;
        System.out.printf("All electric vehicles recharged. Current balance is $%.2f%n", balance);
    }

    private void refuelAndRechargeAllVehicles() {
        refuelAllGasEngines();
        rechargeAllElectricEngines();
        System.out.printf("All vehicles refueled and recharged. Current balance is $%.2f%n", balance);
    }

    private void displayAllVehicles() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void dispatchAllVehicles() {
        cars.clear();
        System.out.println("All vehicles have left.");
    }

    private static int randRangeInclusive(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }
}