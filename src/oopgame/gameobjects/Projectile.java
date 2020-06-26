package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import oopgame.screens.GameBase;

public class Projectile extends GameObject {
    private Image projectile;
    private GameBase screen;
    String projType;
    

    public Projectile(double x, double y, double velY, String projName ,GameBase screen, String projType){
        this.velY = Math.abs(velY) + 100;
        this.velX = 50;
        this.screen = screen;
        this.projType = projType;
        projectile = new ImageIcon("images/projectiles/" + projName +".png").getImage();
        width = projectile.getWidth(screen);
        height = projectile.getHeight(screen);
        this.x = x - width/2;
        this.y = y;
        
    }
    
    @Override
    public void tick(double dt) {
        move(dt);
    }
    
    public void move(double dt){
        if(projType.equals("homing")){
            if(screen.getPlayer().getX() > x) x += velX*dt;
            else x -= velX*dt;
        }
        y += velY*dt;
    }
    
    @Override
    public void render(Graphics2D g) {
        g.drawImage(projectile, (int)x, (int)y, screen);
    }
    
    public double getY(){
        return y;
    }
    
    public double getHeight(){
        return height;
    }
    
    public String getType(){
        return projType;
    }
    
}
