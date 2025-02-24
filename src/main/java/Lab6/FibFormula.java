package Lab6;

public class FibFormula implements FindFib {

    private double goldenRatio() {
        return (1.0 + Math.sqrt(5.0)) / 2.0;
    }

    private double goldenRatioConjugate() {
        return (1.0 - Math.sqrt(5.0)) / 2.0;
    }

    @Override
    public int calculateFib(int n) {
        return (int) Math.round((Math.pow(goldenRatio(), n) - Math.pow(goldenRatioConjugate(), 2)) / Math.sqrt(5.0));
    }
}
