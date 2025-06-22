public class FinancialForecast {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;

        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.printf("Future Value after %d years: ₹%.2f%n", years, futureValue);
    }
}
