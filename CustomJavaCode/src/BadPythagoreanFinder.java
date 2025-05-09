import java.util.ArrayList;

public class BadPythagoreanFinder {
    public static int findNumberOfPythagoreanTriples(int[] numbers) {
        int n = numbers.length;

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int a = numbers[i];
                    int b = numbers[j];
                    int c = numbers[k];

                    if (a * a + b * b == c * c) {
                        results.add(1);
                    }
                    else{
                        results.add(0);
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < results.stream().count(); i++){
            count += results.get(i);
        }
        return count/2;
    }
}
