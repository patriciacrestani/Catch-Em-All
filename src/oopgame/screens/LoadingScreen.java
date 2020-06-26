package oopgame.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import oopgame.gadgets.Timer;

public class LoadingScreen extends ScreenTemplate {
    private Timer timer;
    private int state;
    private Timer timerToLoad;
    private Image backGround;
    private Image e1;
    private Image e2;
    private Image e3;
    private Image e4;
    
    
    public LoadingScreen(){  
        timer = new Timer(0.1);
        state = 1;
        timerToLoad = new Timer(10);
        backGround = new ImageIcon("images/loading/a.jpg").getImage();
        e1 = new ImageIcon("images/loading/staryu1.png").getImage();
        e2 = new ImageIcon("images/loading/staryu2.png").getImage();
        e3 = new ImageIcon("images/loading/staryu3.png").getImage();
        e4 = new ImageIcon("images/loading/staryu4.png").getImage();
    }
    
    @Override
    public void loop(double dt) {
        repaint();
        tick(dt);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(backGround, 0, 0, this);
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35)); 
        //g.drawString("Loading", 390, 540);
        
        switch(state){
            case 1: g.drawImage(e1, 530, 510, 50, 50, this);
                    break;
            case 2: g.drawImage(e2, 530, 510, 50, 50, this);
                    break;
            case 3: g.drawImage(e3, 530, 510, 50, 50, this);
                    break;
            case 4: g.drawImage(e4, 530, 510, 50, 50, this);
                    break;
        }
    }

    @Override
    public void tick(double dt) {
        timer.tick(dt);
        if (timer.isReady()){
            timer.reset();
            state++;
            if (state > 4) state = 1;
        }
        timerToLoad.tick(dt);
        //if (timer.isReady())
        
    }
    
}
