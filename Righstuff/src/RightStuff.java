import java.util.ArrayList;
import java.util.List;

public class RightStuff {

    private static final double ACCEPTABLE_ERROR_PERCENT = 5.0;
    private static final double PRECISION_RANGE_PERCENT = 10.0;

    public static void main(String[] args) {
        List<double[]> dataSets = new ArrayList<>();

        // Manually add the data sets
        dataSets.add(new double[]{2.75, 2.68, 2.70, 2.71, 2.75, 2.75, 2.76});
        dataSets.add(new double[]{3.14, 2.14, 4.14, 2.14, 4.14, 2.14, 4.14, 2.14, 4.14});
        dataSets.add(new double[]{9.99, 6.99, 7.01, 7.11, 6.98, 7.00, 7.05, 7.09});

        for (double[] dataSet : dataSets) {
            double acceptedValue = dataSet[0];
            double[] dataValues = new double[dataSet.length - 1];
            System.arraycopy(dataSet, 1, dataValues, 0, dataValues.length);

            if (isAccurate(acceptedValue, dataValues) && isPrecise(dataValues)) {
                System.out.println("Both");
            } else if (isAccurate(acceptedValue, dataValues)) {
                System.out.println("Accurate");
            } else if (isPrecise(dataValues)) {
                System.out.println("Precise");
            } else {
                System.out.println("Neither");
            }
        }
    }

    private static boolean isAccurate(double acceptedValue, double[] dataValues) {
        double average = calculateAverage(dataValues);
        double absoluteError = Math.abs(acceptedValue - average);
        double errorPercent = (absoluteError / acceptedValue) * 100.0;

        return errorPercent <= ACCEPTABLE_ERROR_PERCENT;
    }

    private static boolean isPrecise(double[] dataValues) {
        double range = calculateRange(dataValues);
        double average = calculateAverage(dataValues);
        double precisionRatio = (range / average) * 100.0;

        return precisionRatio <= PRECISION_RANGE_PERCENT;
    }

    private static double calculateAverage(double[] dataValues) {
        double sum = 0.0;
        for (double value : dataValues) {
            sum += value;
        }
        return sum / dataValues.length;
    }

    private static double calculateRange(double[] dataValues) {
        double minValue = Double.MAX_VALUE;
        double maxValue = Double.MIN_VALUE;

        for (double value : dataValues) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        return maxValue - minValue;
    }
}
