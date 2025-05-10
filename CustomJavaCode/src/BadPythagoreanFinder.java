public class BadPythagoreanFinder {
    public static int findNumberOfPythagoreanTriples(int[] numbers) {
        int n = numbers.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int a = numbers[i];
                    int b = numbers[j];
                    int c = numbers[k];

                    if (a * a + b * b == c * c) {
                        count++;
                    }
                }
            }
        }

        return count / 2;
    }
}
