package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementTest {

    @Test
    public void testEqualsIsTrueFor1CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double dimension = 1;
        Measurement firstMeasurement = new Measurement(dimension, Unit.Centimeter);
        Measurement secondMeasurement = new Measurement(dimension, Unit.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double firstDimension = 2;
        double secondDimension = 1;
        Measurement firstMeasurement = new Measurement(firstDimension, Unit.Centimeter);
        Measurement secondMeasurement = new Measurement(secondDimension, Unit.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        Measurement firstMeasurement = new Measurement(dimension, Unit.Centimeter);
        Integer secondMeasurement = 1;

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        Measurement measurement = new Measurement(dimension, Unit.Centimeter);

        boolean actual = measurement.equals(measurement);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new Measurement(dimension, Unit.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new Measurement(dimension, Unit.Centimeter));
    }

    @Test
    public void testEqualsIsTrueFor1MeterEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);

        boolean actual = measurementInCentimeter.equals(measurementInMeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEquals1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);

        boolean actual = measurementInMeter.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInKilometer = new Measurement(dimensionInKilometer, Unit.Kilometer);

        boolean actual = measurementInCentimeter.equals(measurementInKilometer);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInKilometer = new Measurement(dimensionInKilometer, Unit.Kilometer);

        boolean actual = measurementInKilometer.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);
        Measurement expected = new Measurement(2, Unit.Meter);

        Measurement actual = measurementInMeter.add(measurementInCentimeter);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInKilometer = new Measurement(dimensionInKilometer, Unit.Kilometer);
        Measurement expected = new Measurement(100200, Unit.Centimeter);

        Measurement actual = measurementInKilometer.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);
        Measurement expected = new Measurement(2, Unit.Kilometer);

        Measurement actual = measurementInMeter.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);
        Measurement expected = new Measurement(0.5, Unit.Meter);

        Measurement actual = measurementInMeter.subtract(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);
        Measurement expected = new Measurement(1900, Unit.Centimeter);

        Measurement actual = measurementInCentimeter.subtract(measurementInMeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInCentimeter.subtract(measurementInMeter));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInMeter = 1;
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);

        assertThrows(IllegalArgumentException.class, () -> measurementInMeter.subtract(measurementInMeter));
    }

    @Test
    public void testEqualsIsTrueFor1GramEquals1Gram() throws InvalidMeasurementException {
        double weightInGram = 1;
        Measurement firstMeasurement = new Measurement(weightInGram, Unit.Gram);
        Measurement secondMeasurement = new Measurement(weightInGram, Unit.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2GramsEquals1Gram() throws InvalidMeasurementException {
        double twoGramWeight = 2;
        double oneGramWeight = 1;
        Measurement firstMeasurement = new Measurement(twoGramWeight, Unit.Gram);
        Measurement secondMeasurement = new Measurement(oneGramWeight, Unit.Gram);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForOneTenthKilogramEquals100Gram() throws InvalidMeasurementException {
        double oneTenthOfkilogramWeight=0.1;
        double hundredGramWeight = 100;
        Measurement measurementInKilogram = new Measurement(oneTenthOfkilogramWeight, Unit.Kilogram);
        Measurement measurementInGram = new Measurement(hundredGramWeight, Unit.Gram);

        boolean actual = measurementInKilogram.equals(measurementInGram);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100GramsEqualsOneTenthKilogram() throws InvalidMeasurementException {
        double oneTenthOfkilogramWeight=0.1;
        double hundredGramWeight = 100;
        Measurement measurementInKilogram = new Measurement(oneTenthOfkilogramWeight, Unit.Kilogram);
        Measurement measurementInGram = new Measurement(hundredGramWeight, Unit.Gram);

        boolean actual = measurementInGram.equals(measurementInKilogram);

        assertTrue(actual);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws InvalidMeasurementException {
        double onekilogramWeight=1;
        double tenGramWeight = 10;
        Measurement measurementInKilogram = new Measurement(onekilogramWeight, Unit.Kilogram);
        Measurement measurementInGram = new Measurement(tenGramWeight, Unit.Gram);
        Measurement expectedSum = new Measurement(1010, Unit.Gram);

        Measurement actualSum = measurementInKilogram.add(measurementInGram);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSubtractIs1KilogramForRemoving500GramsFromOneAndAHalfKilogram() throws InvalidMeasurementException {
        double oneAndAHalfkilogramWeight=1.5;
        double fiveHundredGramWeight = 500;
        Measurement measurementInKilogram = new Measurement(oneAndAHalfkilogramWeight, Unit.Kilogram);
        Measurement measurementInGram = new Measurement(fiveHundredGramWeight, Unit.Gram);
        Measurement expectedDifference = new Measurement(1, Unit.Kilogram);

        Measurement actualDifference = measurementInKilogram.subtract(measurementInGram);

        assertEquals(expectedDifference, actualDifference);
    }
}