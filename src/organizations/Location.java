package organizations;

public class Location {

    private long x; //Поле не может быть null
    private long y;
    private int z;

    public Location(long x, long y, int z){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + "," + z + ")";
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
