import java.util.HashSet;
import java.util.Random;

public class RandomArrayGenerator {
    public static int[] generateRandoms(int n, int m) {
        Random rand = new Random();

        HashSet<Integer> numbers = new HashSet<>();
        while (numbers.size() < n){
            numbers.add(rand.nextInt(m - 1) + 1);
        }

        int[] result = new int[n];
        int i = 0;
        for (int num : numbers) {
            result[i++] = num;
        }
        return result;
    }

}
