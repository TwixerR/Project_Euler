import Utils.Tuple_i_i;

public class Problem4 extends Solution{
    /**A palindromic number reads the same both ways.
     * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     *
     * */

    //tests given integer for being  palindrome
    public static boolean isPalindrome(int arg){
        char[] args = Integer.toString(arg).toCharArray();
        int range = args.length/2;
        int i = 0;
        while(i <= range){
            if(args[i] != args[args.length - i - 1])
                return false;
            i++;
        }
        return true;
    }

    public static Object solve(){
        Tuple_i_i ret = new Tuple_i_i(0,0);
        int max = 0;
        //iterate over permutation of 3-digit numbers
        for(int x = 999; x>=100; x--){
            for(int y = x; y>= 100; y--){
                if(isPalindrome(x*y) && x*y > max){
                    max = x*y;
                    ret = new Tuple_i_i(x,y);
                }
            }
        }
//        return ret.toString();
        return max;
    }
}
