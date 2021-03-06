import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class UI extends JComponent
{
    private GameManager board;
    private Player x;
    private Player y;
    private boolean turn;
    private String winnerName;
    private boolean againstComp;
    
    public UI(GameManager GM)
    {
        this.x = new Player(1, JOptionPane.showInputDialog("What is the name of the first player?"));
        if (JOptionPane.showOptionDialog(null, "Would you like to play against the computer?", "Question.", 0, 0, null, null, null) == 0)
        {
            this.y = new AIPlayer(2, "Artificial Intelligence");
            this.againstComp = true;
        }
        else
        {
            this.y = new Player(2, JOptionPane.showInputDialog("What is the name of the second player?"));
            this.againstComp = false;
        }
        GM.setPlayer1(this.x);
        GM.setPlayer2(this.y);
        this.board = GM;
        this.turn = false;
        this.winnerName = "No one.";
    }
    
    public void reset()
    {
        String name = this.y.getName();
        if ((this.y instanceof AIPlayer))
            this.y = new AIPlayer(2, name);
        else
            this.y = new Player(2, name);
    }
    
    public boolean isAgainstComp()
    {
        return this.againstComp;
    }
    
    public Player getPlayer(int i)
    {
        if (i == 1)
            return this.x;
        return this.y;
    }
    
    public GameManager getGM()
    {
        return this.board;
    }
    
    public void changeTurn()
    {
        if (!this.turn)
            this.turn = true;
        else
            this.turn = false;
    }
    
    public boolean isFinished()
    {
        Player[][] playerArena = this.board.getBoard();
        for (int i = 0; i < playerArena.length; i++)
            for (int j = 0; j < playerArena[0].length; j++)
            {
                Player o = playerArena[i][j];
                if (o != null)
                {
                    int diagonal = 0;
                    int diagonalBack = 0;
                    int vertical = 0;
                    int horizontal = 0;
                    for (int t = 0; t < 4; t++)
                    {
                        if (i <= 2)
                        {
                            Player testerVertical = playerArena[(i + t)][j];
                            if ((testerVertical != null) && (testerVertical.getID() == o.getID())) {
                                vertical++;
                            }
                        }
                        if (j <= 3)
                        {
                            Player testerHorizontal = playerArena[i][(j + t)];
                            if ((testerHorizontal != null) && (testerHorizontal.getID() == o.getID())) {
                                horizontal++;
                            }
                        }
                        if ((i <= 2) && (j <= 3))
                        {
                            Player testerDiagonal = playerArena[(i + t)][(j + t)];
                            if ((testerDiagonal != null) && (testerDiagonal.getID() == o.getID())) {
                                diagonal++;
                            }
                        }
                        if ((i <= 2) && (j >= 3))
                        {
                            Player testerDiagonal = playerArena[(i + t)][(j - t)];
                            if ((testerDiagonal != null) && (testerDiagonal.getID() == o.getID()))
                                diagonalBack++;
                        }
                    }
                    if ((vertical == 4) || (horizontal == 4) || (diagonal == 4) || (diagonalBack == 4))
                    {
                        this.winnerName = o.getName();
                        return true;
                    }
                }
            }
        return false;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        rh.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        int yPos = 15;
        for (String line : "Instructions: \n Player one either faces a human opponent or an Artificial Intelligence, indicated either by an inputted name or by 'Artificial Intellingence'. \n The objective of the game is to get four tokens in a row, either horizontally, vertically, or diagonally. \n To play, the user(s) must press a number between 1 and 7 or click on a column corresponding to the column the user wishes to drop a token in. \n After alternating turns, a player will emerge victorious after they have lined up four tokens. \n The game can be reset by pressing the 'r' key on the keyboard. \n Enjoy! \n Produced by Rohin Bhargava.".split("\n"))
            g2.drawString(line, 15, yPos += g2.getFontMetrics().getHeight());
        g2.drawRect(189, 189, 641, 551);
        g2.setColor(Color.YELLOW);
        g2.fillRect(190, 190, 640, 550);
        for (int i = 0; i < this.board.getBoard().length; i++)
            for (int j = 0; j < this.board.getBoard()[0].length; j++)
            {
                g2.setColor(Color.BLACK);
                g2.drawOval(199 + j * 90, 199 + i * 90, 81, 81);
                if (this.board.getBoard()[i][j] != null)
                {
                    if (this.board.getBoard()[i][j].getID() == this.x.getID())
                        g2.setColor(Color.RED);
                    g2.drawOval(200 + j * 90, 650 - i * 90, 80, 80);
                    g2.fillOval(200 + j * 90, 650 - i * 90, 80, 80);
                }
                else
                {
                    g2.setColor(Color.WHITE);
                    g2.fillOval(200 + j * 90, 650 - i * 90, 80, 80);
                }
            }
        int id = 0;
        String name = null;
        if (!this.turn)
        {
            g2.setColor(Color.RED);
            id = this.x.getID();
            name = this.x.getName();
        }
        else
        {
            g2.setColor(Color.BLACK);
            id = this.y.getID();
            name = this.y.getName();
        }
        
        if (!isFinished()) {
            g2.drawString("Player " + id + ": " + name, 186, 180);
        }
        else {
            if (this.winnerName == this.x.getName())
                g2.setColor(Color.RED);
            else
                g2.setColor(Color.BLACK);
            g2.drawString(this.winnerName + " has won!", 186, 180);
        }
    }
}