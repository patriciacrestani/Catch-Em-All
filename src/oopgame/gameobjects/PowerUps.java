package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public class PowerUps extends GameObject{

    protected GameBase screen;
    private Random rand;
    private Image invencibility;
    private Image fast;
    private Image life;
    private Timer timer;
    private int powerUpChooser;
    String powerType;
    
    public PowerUps(double x, double y, GameBase screen){
        this.screen = screen;
        this.x = x;
        this.y = y;
        velY = 75;
        rand = new Random();
        timer = new Timer(2);
        invencibility = new ImageIcon("images/powerUp/invencibility.png").getImage();
        fast = new ImageIcon("images/powerUp/fast.png").getImage();
        life = new ImageIcon("images/powerUp/life.png").getImage();
        powerUpChooser = rand.nextInt(9);
        if(powerUpChooser > 7 ) powerType = "INVINCIBILITY";
        else if(powerUpChooser > 4) powerType = "LIFE";
        else powerType = "FAST";
        width = 20;
        height = 20;
    }
    
    
    @Override
    public void tick(double dt) {
        if (y < 510){
            y += velY*dt;
        }else{
            timer.tick(dt);
        } 
    }

    @Override
    public void render(Graphics2D g) {
        if("INVINCIBILITY".equals(powerType)){
            g.drawImage(invencibility, (int)x, (int)y, screen);
        }else if("FAST".equals(powerType)){
            g.drawImage(fast, (int)x, (int)y, screen);
        }else if("LIFE".equals(powerType)){
            g.drawImage(life, (int)x, (int)y, screen);
        }
    }
    
    public String getPowerType(){
        return powerType;
    }
    
    public Timer getTimer(){
        return timer;
    }
    
}
