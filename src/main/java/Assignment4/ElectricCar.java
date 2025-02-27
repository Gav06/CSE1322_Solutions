package Assignment4;

public class ElectricCar extends Car implements ElectricEngine {
    private double maxBattery;
    private double currentCharge;

    public ElectricCar(double maxBattery, double currentCharge) {
        this.maxBattery = maxBattery;
        this.currentCharge = currentCharge;
    }

    @Override
    public double rechargeBattery(double amount) {
        double needed = maxBattery - currentCharge;
        double recharged = Math.min(needed, amount);
        currentCharge += recharged;
        return recharged;
    }

    @Override
    public double getMaxBattery() {
        return maxBattery;
    }

    @Override
    public double getCurrentCharge() {
        return currentCharge;
    }

    @Override
    public String toString() {
        return String.format("Car: %d | Current Charge: %.2f/%.2f kW", getId(), currentCharge, maxBattery);
    }
}