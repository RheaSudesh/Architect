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

    public double dimensionInSpecificUnits( double dimensionValue){
        if(name.contains("gram"))
            return dimensionInKilogram(dimensionValue);
        else
            return dimensionInMeter(dimensionValue);
    }

    public double dimensionInMeter(double dimensionValue) {
        if (name.equalsIgnoreCase("centimeter"))
            return dimensionValue / 100;
        else if (name.equalsIgnoreCase("kilometer"))
            return dimensionValue * 1000;
        else
            return dimensionValue;
    }

    public double dimensionInKilogram(double massValue) {
        System.out.println("gram"+ massValue);
        if (name.equalsIgnoreCase("gram"))
            return massValue / 1000;
        else return massValue;
    }
}