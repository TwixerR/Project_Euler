import java.math.BigInteger;

public class Problem3 extends Solution{
    //600851475143
    private static BigInteger ret;

    /*
    private static boolean isPrime(int arg){
        int i = arg;
        while(--arg > 1){
            if(arg%i == 0)
                return false;
        }
        return true;
    }*/

    public static Object solve(){
        ret = new BigInteger("600851475143");
        //do a primitive round-down to little-more-than the root of given argument
        //root of  number is statistically certain to contain largest prime factor of given number
        BigInteger iter = new BigInteger("2");
        BigInteger limit = ret.shiftRight(ret.bitLength()/2 - 1);

//        System.out.println("arg: " + ret.toString() + ", limit: " + limit.toString());

        //while iter != limit
        while(!(iter.equals(limit))){
            //if(iter is prime && ret%iter == 0
            if(iter.isProbablePrime(10) && ret.mod(iter).equals(new BigInteger("0")) ) {
                //if iter is equal to ret, then ret is the solution
                if(iter.compareTo(ret) == 0) {
                    break;
                }
                ret = ret.divide(iter);
                iter = new BigInteger("2");
                //if iter exceeds ret, then the given number hs no prime factors
//                if(iter.compareTo(ret) > 0)
//                    break;
                continue;
            }
            iter = iter.add(new BigInteger("1"));
        }
        return ret.toString();
    }
}
