public class Player
{
    private int id;
    private String name;
    
    public Player(int ID, String Name)
    {
        this.id = ID;
        this.name = Name;
    }
    
    public int getID()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
}