public class Moves
{
    private Location loc1;
    private Location loc2;
    
    public Moves()
    {
        this.loc1 = null;
        this.loc2 = null;
    }
    
    public void setLastLoc(Location l1, Location l2)
    {
        this.loc1 = l1;
        this.loc2 = l2;
    }
    
    public Location getLoc1()
    {
        return this.loc1;
    }
    
    public Location getLoc2()
    {
        return this.loc2;
    }
}