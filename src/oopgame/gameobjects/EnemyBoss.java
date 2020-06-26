package oopgame.gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public class EnemyBoss extends Enemy{
    private Random rand;
    private double newX;
    private Image hpBar;
    private Timer timerToTeleport;
    private Timer timerToShoot;
    private String projName;
    private String projType;
    private int totalHp;
    
    public EnemyBoss(String imgName, GameBase screen,int velocity , String projName, String projType) {
        super(imgName, screen);
        this.projName = projName;
        this.projType = projType;
        hpBar = new ImageIcon("images/hpBoss.png").getImage();
        rand = new Random();
        timerToTeleport = new Timer(2);
        timerToShoot = new Timer(1);
        newX = (rand.nextInt(6)+1)*100-50 - width/2;
        y = 70;
        velY = velocity;
        hp = 10;
        totalHp = hp;
    }

    @Override
    public void tick(double dt) {
        super.tick(dt);
        timerToTeleport.tick(dt);
        timerToShoot.tick(dt);
        if(timerToTeleport.isReady())
            teleport();
        if(timerToShoot.isReady())
            shoot();
        
        if(y>400 || y<20) velY *= -1; 
    }
    
    @Override
    public void damage(){
        hp -= 1;
        timerToTeleport.setGoal(0.1*hp +0.5);
        timerToShoot.setGoal(0.05*hp +0.5);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.drawImage(hpBar, 50, 10,screen);
        g.setColor(Color.GREEN);
        for(int i = 0; i < hp; i++){
            g.fillRect(i*(490/totalHp) + 55, 15, 490/totalHp, 20);
        }
        g.setColor(Color.BLACK);
        Rectangle.Double rect2 = new Rectangle.Double(newX,y,width,height);
        g.draw(rect2);
        
        
    }
    
    public void teleport(){
        x = newX;
        while(newX == x)
            newX = (rand.nextInt(6)+1)*100-50 - width/2;
        timerToTeleport.reset();
    }
    
    public void shoot(){
        screen.addProjectile(x+width/2, y + height/2, velY, projName, projType);
        timerToShoot.reset();
    }
    
}
