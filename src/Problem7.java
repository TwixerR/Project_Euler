import Utils.Primer;

public class Problem7 extends Solution {
    /**By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * What is the 10 001st prime number?
     *
     * @return returns 10001st prime number
     */
    public static Object solve(){
        int num = 13;
        for (int itr = 6; itr < 10001; itr++) {
            num = Primer.nextPrime(num);
        }
        return num;
    }
}
