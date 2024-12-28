
package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    
    private int dots;
    private final int allDots = 2500;
    private final int dotSize = 14;
    private final int rendomPos = 30;
    private int x[] = new int[allDots];
    private int y[] = new int[allDots];
    private Image apple;
    private Image head;
    private Image body;
    private int point =0;
    private int appleX;
    private int appleY;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
   
    

    public Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);

        loadImages();
        startGame();
    }
    private void loadImages() {
        ImageIcon i1 = new ImageIcon(getClass().getResource("apple.png"));
        apple = i1.getImage();
        ImageIcon i2 = new ImageIcon(getClass().getResource("head.png"));
        head = i2.getImage();
        ImageIcon i3 = new ImageIcon(getClass().getResource("dot.png"));
        body = i3.getImage();
    }

    private void startGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50-i*dotSize;    
        }
      locateApple();
      timer = new Timer(140,this);
      timer.start();
      
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    public void move(){
        for (int i = dots; i>0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(left){
            x[0] -= dotSize;
        }
        if(right){
            x[0] += dotSize;
        }
        if(up){
            y[0] -= dotSize;
        }
        if(down){
            y[0] += dotSize;
        }
        
    }
    public void locateApple(){
        int r = (int) (Math.random()*rendomPos);
        appleX = r*10;
        r = (int) (Math.random()*rendomPos);
        appleY = r*10;
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(apple, appleX, appleY, this);
        for (int i = 0; i < dots; i++) {
            if (i==0) {
               g.drawImage(head, x[i], y[i], this);
            }else{
                 g.drawImage(body, x[i], y[i], this);
            } 
        }
        Toolkit.getDefaultToolkit().sync();
    }
    
     public class TAdapter extends KeyAdapter{
         
        @Override
        public void keyPressed(KeyEvent e){
            
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_LEFT && (!right)){
                left = true;
                up = false;
                down =false;
            }
            if(key == KeyEvent.VK_RIGHT && (!left)){
                right = true;
                up = false;
                down =false;
            }
            if(key == KeyEvent.VK_UP && (!down)){
                up = true;
                left = false;
                right =false;  
            }
            if(key == KeyEvent.VK_DOWN && (!up)){
                down = true;
                left = false;
                right =false;
            }
            
        }
        
    }



   

    
    
}

