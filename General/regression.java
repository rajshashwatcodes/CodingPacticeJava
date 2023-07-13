public class regression {
    public static void main(String[] args) {
                // Sample data points
                double[] x = {1, 2, 3, 4, 5};
                double[] y = {2, 4, 6, 8, 10};
        
                // Calculate the means of x and y
                double xMean = calculateMean(x);
                double yMean = calculateMean(y);
        
                // Calculate the slope (beta1) and intercept (beta0)
                double beta1 = calculateBeta1(x, y, xMean, yMean);
                double beta0 = calculateBeta0(xMean, yMean, beta1);
        
                // Print the regression line equation
                System.out.println("Regression line equation: y = " + beta1 + "x + " + beta0);
        
                // Predict using the regression line
                double xValue = 6;
                double predictedY = predictY(xValue, beta1, beta0);
                System.out.println("Prediction for x = " + xValue + ": " + predictedY);
            }
        
            // Function to calculate the mean of an array
            public static double calculateMean(double[] array) {
                double sum = 0;
                for (double num : array) {
                    sum += num;
                }
                return sum / array.length;
            }
            
            // Function to calculate the slope (beta1)
            public static double calculateBeta1(double[] x, double[] y, double xMean, double yMean) {
                double numerator = 0;
                double denominator = 0;

                for (int i = 0; i < x.length; i++) {
                    numerator += (x[i] - xMean) * (y[i] - yMean);
                    denominator += Math.pow((x[i] - xMean), 2);
                }

                return numerator / denominator;
            }

            // Function to calculate the intercept (beta0)
            public static double calculateBeta0(double xMean, double yMean, double beta1) {
                return yMean - (beta1 * xMean);
            }

            // Function to predict y-value given x-value, slope (beta1), and intercept (beta0)
            public static double predictY(double xValue, double beta1, double beta0) {
                return (beta1 * xValue) + beta0;
    }
}
