public class Location
{
    private int row;
    private int column;
    
    public Location()
    {
        this.row = 0;
        this.column = ((int)Math.random() * 8);
    }
    
    public Location(int r, int c)
    {
        this.row = r;
        this.column = c;
    }
    
    public int getRow()
    {
        return this.row;
    }
    
    public int getCol()
    {
        return this.column;
    }
}