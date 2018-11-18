package Utils;

public class Primer {


    public static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    /**Returns next prime number for given int argument
     * @param num number for which to yield next prime number
     * @return next prime number
     */
    public static int nextPrime(int num){
        if(num<1)
            return 2;
        do{ num++; }
        while(!isPrime(num));
        return num;
    }
}
