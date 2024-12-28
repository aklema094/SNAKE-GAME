
package snakegame;

import javax.swing.JFrame;

public class Snake extends JFrame {
    
    Snake(){ 
        add(new Board());
        pack();
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
    public static void main(String[] args) {
     
          new Snake().setVisible(true);
       
    }
    
}
