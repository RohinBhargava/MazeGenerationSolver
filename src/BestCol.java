public class BestCol
{
    private int col;
    private int score;
    
    public BestCol(boolean person)
    {
        this.col = ((int)Math.random() * 7);
        if (person)
            this.score = 2147483647;
        else
            this.score = -2147483648;
    }
    
    public void setScore(int s)
    {
        this.score = s;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public void setColumn(int c)
    {
        this.col = c;
    }
    
    public int getColumn()
    {
        return this.col;
    }
}