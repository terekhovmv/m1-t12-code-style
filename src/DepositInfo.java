import java.util.Objects;

public class DepositInfo {
    private final String name;
    private final double yearRate;

    public DepositInfo(String name, double yearRate) {
        this.name = name;
        this.yearRate = yearRate;
    }

    public String getName() {
        return name;
    }

    public double calculateTotal(double initialAmount, int periodInYears, boolean withCapitalization) {
        double total;

        if (withCapitalization) {
            total = initialAmount * Math.pow((1 + yearRate / 12), 12 * periodInYears);
        } else {
            total = initialAmount + initialAmount * yearRate * periodInYears;
        }

        return round(total, 2);
    }

    private double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof DepositInfo)) return false;

        DepositInfo other = (DepositInfo) otherObject;
        return Double.compare(yearRate, other.yearRate) == 0 && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearRate);
    }

    @Override
    public String toString() {
        return String.format("DepositInfo{name='%s', yearRate=%.4f}", name, yearRate);
    }
}