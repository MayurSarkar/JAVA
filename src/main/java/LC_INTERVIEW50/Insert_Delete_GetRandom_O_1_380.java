package LC_INTERVIEW50;
import java.util.*;

public class Insert_Delete_GetRandom_O_1_380 {
    private List<Integer> v;
    private Map<Integer, Integer> m;

    public Insert_Delete_GetRandom_O_1_380() {
        v = new ArrayList<>();
        m = new HashMap<>();
    }

    public boolean insert(int val) {
        if (m.containsKey(val)) {
            return false;
        }
        v.add(val);
        m.put(val, v.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!m.containsKey(val)) {
            return false;
        }
        int index = m.get(val);
        int lastElement = v.get(v.size() - 1);

        v.set(index, lastElement);
        m.put(lastElement, index);

        v.remove(v.size() - 1);
        m.remove(val);
        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return v.get(rand.nextInt(v.size()));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insert_Delete_GetRandom_O_1_380 obj = new Insert_Delete_GetRandom_O_1_380();

        System.out.println("1: Insert, 2: Remove, 3: Get Random, 4: Exit");

        while (true) {
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            if (choice == 1) {
                System.out.print("Enter value to insert: ");
                int val = scanner.nextInt();
                boolean inserted = obj.insert(val);
                System.out.println("Inserted: " + inserted);
            } else if (choice == 2) {
                System.out.print("Enter value to remove: ");
                int val = scanner.nextInt();
                boolean removed = obj.remove(val);
                System.out.println("Removed: " + removed);
            } else if (choice == 3) {
                System.out.println("Random value: " + obj.getRandom());
            }
        }
    }
}
