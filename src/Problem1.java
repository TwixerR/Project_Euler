public final class Problem1 extends Solution{

    public static Object solve(){
        int ret = 0;
        for(int i = 3; i<1000; i++)
            if (i % 3 == 0 || i % 5 == 0)
                ret += i;
        return ret;
    }
}
