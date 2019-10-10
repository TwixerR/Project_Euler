package Utils;

public class Tuple_i_i_i{
    private Object x;
    private Object y;
    private Object z;
    public Tuple_i_i_i(Object x, Object y, Object z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "{ "+x.toString()+" ,"+y.toString()+" ,"+z.toString()+" }";
    }

    // TODO: 08-Oct-19 Add try/catch capturing incompatible types 
    public int[] toIntArr() {
        int[] ret = {Integer.parseInt((String) x), Integer.parseInt((String) y), Integer.parseInt((String) z)};
        return ret;
    }
}