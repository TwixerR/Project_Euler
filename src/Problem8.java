import Utils.Tuple_i_i;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.math.BigInteger;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.time.temporal.ChronoField;

public class Problem8 extends Solution{
    private static String exerciseString = new String("https://projecteuler.net/problem=8");
    private static String wholeInput = "";
    public static Object solve() throws Exception {
        //get input data for exercise from webpage
        try {
            URL exerciseURL = new URL(exerciseString);
            URLConnection connection = exerciseURL.openConnection();
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = bufferReader.readLine()) != null) {
                //get lines from entirety of body that have the exercise input data nad store numbers in wholeInput
                if (inputLine.matches("(\\d+<br \\/>)|(\\d+<br \\/><\\/p>)")) {
                    wholeInput = wholeInput + inputLine.split("<")[0];
                }
            }
            System.out.println(wholeInput);
            bufferReader.close();
        }
        catch (MalformedURLException malformurl){
            System.out.println("URL in exercise 8 is malfunctioning.");
        }

        //BEGIN CLCULTIONS
        //calculate sum of next 13 (as specified in exercise) digits and their dispersion
        //ties with highest sums are picked according to lowest dispersion first
        int sum;
        int maxSum = 0;
        int minDispersion = 10;
        int positionOfMax = 0;
        int biggest = 0;
        int lowest = 10;
        char[] arr = new char[13];
        for (int i = 0; i < 987; i++) {
            sum = 0;
            arr = wholeInput.substring(i,i+13).toCharArray();
            int val = 0;
            for (char c :
                    arr) {
                val = Character.getNumericValue(c);
                sum+=val;
                if(val > biggest)
                    biggest = val;
                if(val < lowest)
                    lowest = val;
            }
            if((sum > maxSum)&&(biggest-lowest)>minDispersion)
                positionOfMax = i;
        }

        long ret = 1;
        arr = wholeInput.substring(positionOfMax,positionOfMax+13).toCharArray();
        for (char c :
                arr) {
            ret *= Character.getNumericValue(c);
        }

        return ret;
    }
}
