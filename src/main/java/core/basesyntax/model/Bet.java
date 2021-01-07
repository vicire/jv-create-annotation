package core.basesyntax.model;

public class Bet {
    private int betValue;
    private double coefficient;

    public Bet(int betValue, double coefficient) {
        this.betValue = betValue;
        this.coefficient = coefficient;
    }

    public int getBetValue() {
        return betValue;
    }

    public void setBetValue(int betValue) {
        this.betValue = betValue;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Bet {"
                + "value = " + betValue
                + ", coefficient = " + coefficient
                + "}";
    }
}
