import java.math.BigInteger;

public class Problem6 extends Solution {
    /**
     *The sum of the squares of the first ten natural numbers is,
     * 1^2 + 2^2 + ... + 10^2 = 385
     * The square of the sum of the first ten natural numbers is,
     * (1 + 2 + ... + 10)^2 = 552 = 3025
     * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 2640.
     * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     */

    //given range can be adjusted here
    private final static int AMOUNT = 100;

    public static Object solve(){
        BigInteger square_of_sums;
        int sum_of_squares = 0;

        int sum = 0;

        for(int i = 1; i<=AMOUNT; i++){
            sum+=i;
            sum_of_squares+= i*i;
        }

        square_of_sums = new BigInteger(Integer.toString(sum)).multiply(new BigInteger(Integer.toString(sum)));


        return square_of_sums.add(new BigInteger(Integer.toString(sum_of_squares)).negate());
    }
}
