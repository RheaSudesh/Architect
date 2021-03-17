package utility;

public enum Unit {
    Centimeter("centimeter"),
    Meter("meter"),
    Kilometer("kilometer"),
    Gram("gram");

    private final String name;

    private Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double dimensionInMeter(double dimensionValue) {
        if (this.name.equalsIgnoreCase("centimeter"))
            return dimensionValue / 100;
        else if (this.name.equalsIgnoreCase("kilometer"))
            return dimensionValue * 1000;
        else if (this.name.equalsIgnoreCase(("gram")))  // 1 meter = 100000gram
            return dimensionValue / 1000000;
        else
            return dimensionValue;
    }
}
