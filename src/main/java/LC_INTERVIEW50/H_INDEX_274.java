package LC_INTERVIEW50;
import java.util.*;

public class H_INDEX_274 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of papers: ");
        int n = scanner.nextInt();

        int[] citations = new int[n];
        System.out.println("Enter the citation counts for each paper:");
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        int hIndex = hIndex(citations);

        System.out.println("The h-index is: " + hIndex);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 1; i <= n; i++) {
            if (citations[n - i] < i) {
                return i - 1;
            }
        }
        return n;
    }
}
