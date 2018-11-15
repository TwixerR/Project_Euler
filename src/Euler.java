import Utils.DirectoryCrawler;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static Utils.DirectoryCrawler.listFiles;

/**
 * @author Grzegorz Surdziel
 * @param ### Cannonical name is "Problem" followed immediately by up to three digits
 *                   Each Problem class sovles one of projecteuler.net/archive paradigms
 *
 */
public class Euler {

    private final static String CURRENT_WORKING_DIRECTORY_URL = "C:\\Users\\gerez\\IdeaProjects\\Project_Euler\\src";

    private static void defaultExceptionHandler(Exception exc){
        //temporarily this method handles all exceptions raised in code
            System.out.println("Solution to " +
                    //add some whitespace between problem name and number
                    exc.getMessage().substring(0,7) + " " +
                    exc.getMessage().substring(7) + " not found");
    }
    public static void main(String[] args){
        //print out all solutions
        try {
            String[]  filesArr = DirectoryCrawler.listFiles(CURRENT_WORKING_DIRECTORY_URL).split(",");
            for (String str : filesArr) {
                //get rid of leading and trailing spaces, strip off trailing '.java'
                str = str.trim();
                //strip off trailing '.java'
                str = str.substring(0, str.length()-5);
                //invoke Problem### class' static method, if it exists in directory
                if(str.matches("Problem\\d+")){
                    Class <?> clazz = Class.forName(str);
                    Method method = clazz.getMethod("solve");
                    Object o = method.invoke(null);
                    System.out.println("Solution to " + clazz.getCanonicalName() + ":\n" + o.toString() + "\n");
                }
            }
        }
        catch (ClassNotFoundException cnfe){
            defaultExceptionHandler(cnfe);
        }
        catch (NoSuchMethodException nsme){
            System.out.println("No such method exception. Probbly  tyo in Problem###.class file on method solve()");
            defaultExceptionHandler(nsme);
        }
        catch (IllegalAccessException iae){
            defaultExceptionHandler(iae);
        }
        catch (InvocationTargetException ite) {
            defaultExceptionHandler(ite);
        }
    }
}
