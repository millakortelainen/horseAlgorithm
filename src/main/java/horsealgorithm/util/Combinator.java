package horsealgorithm.util;

public class Combinator {

    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result*= i;
        }
        System.out.println(result);
        return result;
    }

}