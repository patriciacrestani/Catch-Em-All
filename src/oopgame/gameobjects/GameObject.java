package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public abstract class GameObject {
    protected double x, y;
    protected double velX, velY;
    protected int width;
    protected int height;
    
    public abstract void tick(double dt);
    public abstract void render(Graphics2D g);
    
    public Rectangle2D getHitbox(){
        return new Rectangle2D.Double(x,y,width,height);
    }
    
    public double getY(){
        return y;
    }
    
    public double getX(){
        return x;
    }
}
