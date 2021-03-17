package utility;

public enum Unit {
    Centimeter("centimeter"),
    Meter("meter"),
    Kilometer("kilometer"),
    Gram("gram"),
    Kilogram("kilogram");

    private final String name;

    private Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double dimensionInMeter(double dimensionValue) {
        if (name.equalsIgnoreCase("centimeter"))
            return dimensionValue / 100;
        else if (name.equalsIgnoreCase("kilometer"))
            return dimensionValue * 1000;
        else if (name.equalsIgnoreCase("gram"))  // 0.001 meter = 1000gram  =1kg
            return dimensionValue / 1000000;
        else if (name.equalsIgnoreCase("kilogram"))
            return dimensionValue / 1000;
        else
            return dimensionValue;
    }
}
