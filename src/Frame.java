import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class Frame
{
    private int k;
    private Location h;
    private GameManager u;
    private UI userInterface;
    
    public void repaintCall()
    {
        if (this.h != null)
        {
            this.u.placePiece(this.h, this.userInterface.getPlayer(this.k));
            this.userInterface.changeTurn();
            
            if (!this.userInterface.isFinished())
            {
                if (!this.userInterface.isAgainstComp())
                {
                    if (this.k == 1)
                        this.k = 2;
                    else {
                        this.k = 1;
                    }
                }
                else
                {
                    this.u.placePiece(null, this.userInterface.getPlayer(2));
                    this.userInterface.changeTurn();
                }
            }
        }
        this.userInterface.repaint();
    }
    
    public Frame()
    {
        this.u = new GameManager();
        this.k = 1;
        this.h = null;
        this.userInterface = new UI(this.u);
        
        KeyListener listener = new KeyListener()
        {
            public void keyPressed(KeyEvent arg0)
            {
                int key = arg0.getKeyCode();
                
                if ((key >= 49) && (key <= 57) && (!Frame.this.userInterface.isFinished()))
                {
                    Frame.this.h = Frame.this.u.getLocAbovePieceInCol(key - 49);
                }
                
                if (key == 82)
                {
                    Frame.this.h = null;
                    Frame.this.u.reset();
                    Frame.this.userInterface.reset();
                }
                
                Frame.this.repaintCall();
            }
            
            public void keyReleased(KeyEvent e)
            {
            }
            
            public void keyTyped(KeyEvent e)
            {
            }
        };
        MouseListener listener2 = new MouseListener()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                int xPos = arg0.getX();
                
                if (((xPos - 190) / 90 >= 0) && ((xPos - 190) / 90 < 7) && (!Frame.this.userInterface.isFinished())) {
                    Frame.this.h = Frame.this.u.getLocAbovePieceInCol((xPos - 190) / 90);
                }
                if (Frame.this.userInterface.isFinished())
                {
                    Frame.this.h = null;
                    Frame.this.u.reset();
                    Frame.this.userInterface.reset();
                }
                
                Frame.this.repaintCall();
            }
            
            public void mouseEntered(MouseEvent e)
            {
            }
            
            public void mouseExited(MouseEvent e)
            {
            }
            
            public void mouseReleased(MouseEvent e)
            {
            }
            
            public void mousePressed(MouseEvent e)
            {
            }
        };
        this.userInterface.addKeyListener(listener);
        this.userInterface.addMouseListener(listener2);
        this.userInterface.setFocusable(true);
        JFrame frame = new JFrame();
        frame.setTitle("Connect 4");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(3);
        frame.add(this.userInterface);
        frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        Frame x = new Frame();
    }
}