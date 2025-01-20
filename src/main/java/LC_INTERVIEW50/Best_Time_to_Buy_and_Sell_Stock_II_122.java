package LC_INTERVIEW50;
import java.util.Scanner;


public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days (size of the prices array): ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the stock prices for each day:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int maxProfit = maxProfit(prices);

        System.out.println("The maximum profit that can be made is: " + maxProfit);
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = prices[0];

        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > 0) {
                profit += prices[i] - min;
                min = prices[i];
            }
        }

        return profit;
    }
}
