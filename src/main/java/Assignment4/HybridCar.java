package Assignment4;

public class HybridCar extends Car implements GasEngine, ElectricEngine {

    private double maxBattery;
    private double currentCharge;
    private double tankCapacity;
    private double currentVolume;

    public HybridCar(double maxBattery, double currentCharge, double tankCapacity, double currentVolume) {
        this.maxBattery = maxBattery;
        this.currentCharge = currentCharge;
        this.tankCapacity = tankCapacity;
        this.currentVolume = currentVolume;
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
    public double refuelTank(double amount) {
        double needed = tankCapacity - currentVolume;
        double refueled = Math.min(needed, amount);
        currentVolume += refueled;
        return refueled;
    }

    @Override
    public double getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public double getCurrentVolume() {
        return currentVolume;
    }

    @Override
    public String toString() {
        return String.format("Car: %d | Current Charge: %.2f/%.2f kW | Current Fuel: %.2f/%.2f gals",
                getId(), currentCharge, maxBattery, currentVolume, tankCapacity);
    }
}