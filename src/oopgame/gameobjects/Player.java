package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public class Player extends GameObject {
    private GameBase screen;
    private int hp;
    private boolean left;
    private boolean right;
    private Image playerLeft1;
    private Image playerLeft2;
    private Image playerRight1;
    private Image playerRight2;
    private Image playerStanding;
    private Image playerInvLeft1;
    private Image playerInvLeft2;
    private Image playerInvRight1;
    private Image playerInvRight2;
    private Image playerInvStanding;
    private Image playerFast1;
    private Image playerFast2;
    private final double K;
    
    private Timer timerChange;
    private boolean can;
    ////// Status ////////
    private Timer sleepTime;
    private boolean sleep;
    private Timer invincibilityTime;
    private boolean invincibility;
    private Timer fastTime;
    private boolean fast;
    private double fastSpeed;
    private int damage;
    
    public Player(GameBase screen){
        this.screen = screen;
        x = 270;
        y = 500;  
        velX = 250;
        velY = 0;
        hp = 5;
        damage = 1;
        left = false;
        right = false;
        playerLeft1 = new ImageIcon("images/player/left1.png").getImage();
        playerLeft2 = new ImageIcon("images/player/left2.png").getImage();
        playerRight1 = new ImageIcon("images/player/right1.png").getImage();
        playerRight2 = new ImageIcon("images/player/right2.png").getImage();
        playerStanding = new ImageIcon("images/player/standing.png").getImage();
        playerInvLeft1 = new ImageIcon("images/player/invLeft1.png").getImage();
        playerInvLeft2 = new ImageIcon("images/player/invLeft2.png").getImage();
        playerInvRight1 = new ImageIcon("images/player/invRight1.png").getImage();
        playerInvRight2 = new ImageIcon("images/player/invRight2.png").getImage();
        playerInvStanding = new ImageIcon("images/player/invStanding.png").getImage();
        playerFast1 = new ImageIcon("images/player/fast1.png").getImage();
        playerFast2 = new ImageIcon("images/player/fast2.png").getImage();
        width = playerStanding.getWidth(screen);
        height = playerStanding.getHeight(screen);
        timerChange = new Timer(0.1);
        K = 2.5;
        
        ////// status effects ///////
        sleepTime = new Timer(1);
        sleep = false;
        invincibilityTime = new Timer(5);
        invincibility = false;
        fastTime = new Timer(5);
        fast = false;
    }
    
    @Override
    public void tick(double dt){ 
        move(dt);
        timerChange.tick(dt);
        checkPowerUps();
        sleep = statusEffect(sleep, sleepTime, dt);
        invincibility = statusEffect(invincibility, invincibilityTime, dt);
        fast = statusEffect(fast, fastTime, dt);
        if (timerChange.isReady()){
            timerChange.reset();
            can = !can;
        }
    }
    
    @Override
    public void render(Graphics2D g){
        if(left && !sleep){
            if(can){
                if(invincibility) g.drawImage(playerInvLeft1, (int)(x-K),(int)(y-K),(int)((width+2)*K),(int)((height+2)*K), screen);
                else g.drawImage(playerLeft1, (int)x, (int)y, (int)(width*2.5),(int)(height*2.5), screen);
            }else{
                if(invincibility) g.drawImage(playerInvLeft2, (int)(x-K),(int)(y-K),(int)((width+2)*K),(int)((height+2)*K), screen);
                else g.drawImage(playerLeft2, (int)x, (int)y, (int)(width*K),(int)(height*K), screen);
            }
            if(fast){
                g.drawImage(playerFast1,(int)(x-K*2),(int)y,(int)(playerFast1.getWidth(screen)*K),(int)(playerFast1.getHeight(screen)*K),screen);
            }
        }else if(right && !sleep){
            if(can){
                if(invincibility) g.drawImage(playerInvRight1, (int)(x-K),(int)(y-K),(int)((width+2)*K),(int)((height+2)*K), screen);
                else g.drawImage(playerRight1, (int)x, (int)y, (int)(width*2.5),(int)(height*2.5), screen);
            }else{
                if(invincibility) g.drawImage(playerInvRight2,(int)(x-K),(int)(y-K),(int)((width+2)*K),(int)((height+2)*K), screen);
                else g.drawImage(playerRight2, (int)x, (int)y, (int)(width*K),(int)(height*K), screen);
            }
            if(fast){
                g.drawImage(playerFast2,(int)(x-K*2),(int)y,(int)(playerFast2.getWidth(screen)*K),(int)(playerFast2.getHeight(screen)*K),screen);
            }
        }else{
            if(invincibility) g.drawImage(playerInvStanding, (int)(x-K),(int)(y-K),(int)((width+2)*K),(int)((height+2)*K), screen);
            else g.drawImage(playerStanding, (int)x, (int)y, (int)(width*K),(int)(height*K), screen);
        }
    }
    
    public void move(double dt){
            if(left && x > 0) x -= velX*dt;
            else if(right && x < 594 - width) x += velX*dt;
    }
    
    public void damage(){
            hp -= damage;
    }
    
    public boolean isDead(){
        return hp<=0;
    } 
    
    public int getDamageZone(){
        return 460;
    }
    
    public boolean statusEffect(boolean effect, Timer effectTime, double dt){
        if(effect){
            effectTime.tick(dt);
            if(effectTime.isReady()){
                effect = false;
                effectTime.reset();
            }
        }
        return effect;
    }
    
    public void activatePowerUp(String powerType){
        if("INVINCIBILITY".equals(powerType)) invincibility();
        else if("FAST".equals(powerType)) fast();
        else if("LIFE".equals(powerType)) life();
    }
    
    
    public void sleep(){
        sleep = true;
        sleepTime.reset();
    }
    
    public void invincibility(){
        invincibility = true;
        invincibilityTime.reset();
    }
    
    public void fast(){
        fast = true;
        fastTime.reset();
    }
    
    public void life(){
        hp+=1;
    }
    
        
    public void checkPowerUps(){
        if(fast) velX = 500;
        if(sleep) velX = 0;
        if(!fast && !sleep) velX = 250;
        
        if(invincibility) damage = 0;
        else damage = 1;
    }
    
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
        }
    }
    
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }
    }
    
    /// metodos para a HUD
    
    public int getHP(){
        return hp;
    }
    
    public double getSleepTime(){
        return sleepTime.getTime();
    }
    
    public double getInvincibilityTime(){
        return invincibilityTime.getTime();
    }
    
    public double getFastTime(){
        return fastTime.getTime();
    }
    
    @Override
    public Rectangle2D getHitbox(){
        return new Rectangle2D.Double(x, y, width + 25, height);
    }
   

}
