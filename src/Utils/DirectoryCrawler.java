package Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Vector;

public class DirectoryCrawler {
    /**Function returns String[] of files in given directory
     * @param root directory to search for files
     */
    public static String listFiles(String root) throws NullPointerException{
        Vector<String> vec = new Vector<>();
        try {
            File cwd = new File(root);
            File[] list = cwd.listFiles();
            for (File fil:
                 list) {
                if(fil.isFile()){
                    vec.add(fil.getName());
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return vec.toString();
    }
}
