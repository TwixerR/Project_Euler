package Utils;

public class Tuple_i_i{
    private int x;
    private int y;
    public Tuple_i_i(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "{ "+x+" ,"+y+" }";
    }
}
