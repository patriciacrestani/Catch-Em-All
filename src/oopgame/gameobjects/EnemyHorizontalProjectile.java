package oopgame.gameobjects;

import java.util.Random;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public class EnemyHorizontalProjectile extends Enemy{
    private Timer timer;
    private Random rand;
    private String projName;
    private String projType;
    
    public EnemyHorizontalProjectile(String imgName, GameBase screen, int velocity, String projName, String projType) {
        super(imgName, screen);
        this.projName = projName;
        this.projType = projType;
        rand = new Random();
        if(rand.nextInt(2)==1){
            velX = -200;
            x = 600;
        }else{
            velX = 200;
            x = 0;
        }
        velY = 0;
        y = rand.nextInt((300 - 50) + 1) + 50;
        timer = new Timer(rand.nextDouble()*3);
    }
    
    @Override
    public void tick(double dt){
        super.tick(dt);
        timer.tick(dt);
        if(timer.isReady()){
            shoot();
        }
    }
    
    public void shoot(){
        screen.addProjectile(x, y, 50, projName, projType);
        timer.stopTimer();
    }
}
