
package snakegame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Snake extends JFrame {
    private ImageIcon icon;
    
    Snake(){ 
        setTitle("Snake Game");
        icon = new ImageIcon(getClass().getResource("Snake.png"));
        this.setIconImage(icon.getImage());
        add(new Board());
        pack();
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
    public static void main(String[] args) {
    
          new Snake().setVisible(true);
       
    }

    
    
}
