package LC_INTERVIEW50;
import java.util.*;

public class BEST_TIME_TO_BUY_AND_SELL_STOCK_121 {
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
        int min_price = Integer.MAX_VALUE;
        int max_profit = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price < min_price) {
                min_price = price;
            } else if (price - min_price > max_profit) {
                max_profit = price - min_price;
            }
        }

        return Math.max(max_profit, 0);
    }
}
