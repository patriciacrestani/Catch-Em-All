package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.util.Random;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public class EnemyTeleport extends Enemy {
    private Timer timer;
    private Random rand;
    private double newX;
    
    public EnemyTeleport(String imgName, GameBase screen, int velocity){
        super(imgName,screen);
        rand = new Random();
        timer = new Timer(1 + (rand.nextDouble())/2);
        velY = velocity;
        newX = x;
    }
    
    @Override
    public void tick(double dt){
        super.tick(dt);
        timer.tick(dt);
        if (timer.isReady())
            teleport();
    }
    
    @Override
    public void render(Graphics2D g){
        super.render(g);
        
    }
    
    public void teleport(){
        while(newX == x)
            newX = (rand.nextInt(6)+1)*100-50 - width/2;
        x = newX;
        timer.stopTimer();
    }
    
    
}
