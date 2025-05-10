public class Main {

    public static void main(String[] args) {
        int n = 800;
        int m = 100000;
        int[] numbers = RandomArrayGenerator.generateRandoms(n, m);
        System.out.println("randoms generated.");
        int pythagoreanTriplesCnt = GoodPythagoreanFinder.findNumberOfPythagoreanTriples(numbers);
        System.out.println(pythagoreanTriplesCnt);
    }
}
