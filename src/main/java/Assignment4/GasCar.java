package Assignment4;

public class GasCar extends Car implements GasEngine {

    private double tankCapacity;
    private double currentVolume;

    public GasCar(double tankCapacity, double currentVolume) {
        this.tankCapacity = tankCapacity;
        this.currentVolume = currentVolume;
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
        return String.format("Car: %d | Current Fuel: %.2f/%.2f gals", getId(), currentVolume, tankCapacity);
    }
}