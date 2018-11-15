public class Problem2 extends Solution {
    private static final int LIMIT = 4000000;//four million
    public static Object solve(){
        //{a,b} - sequence terms, tmp - buffer
        int a=1, b=1, ret=0, tmp;
        while(b<=LIMIT){
                //performs a 'next step' through sequence on (a,b)
                tmp=b;
                b+=a;
                a=tmp;
                if(b%2==0)//summarizes even Fibonacci terms for solution
                    ret+=b;
        }
        return ret;
    }
}
