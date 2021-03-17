package utility;

public class Measurement {

    private final double dimension;
    public final Unit unit;

    public Measurement(double dimension, Unit unit) throws InvalidMeasurementException {
        if (dimension <= 0)
            throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Measurement)) return false;

        Measurement measurement = (Measurement) object;
        return this.unit.dimensionInMeter(dimension) == measurement.unit.dimensionInMeter(measurement.dimension);
    }


    public Measurement add(Measurement measurement) throws InvalidMeasurementException {
        double sum = this.unit.dimensionInMeter(dimension) + measurement.unit.dimensionInMeter(measurement.dimension);

        return new Measurement(sum, Unit.Meter);
    }


    public Measurement subtract(Measurement measurement) {

        double difference = this.unit.dimensionInMeter(dimension) - measurement.unit.dimensionInMeter(measurement.dimension);

        try {
            return new Measurement(difference, Unit.Meter);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }
}