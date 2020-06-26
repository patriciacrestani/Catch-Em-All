package oopgame.gameobjects;

import java.util.Random;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public class EnemyNormalProjectile extends EnemyNormal {
    private Timer timer;
    private Random rand;
    String projName;
    String projType;
    
    public EnemyNormalProjectile(String imgName, GameBase screen, int velocity, String projName, String projType) {
        super(imgName, screen, velocity);
        this.projName = projName;
        this.projType = projType;
        rand = new Random();
        timer = new Timer(rand.nextDouble()*2);
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
        screen.addProjectile(x+width/2, y, velY, projName, projType);
        timer.stopTimer();
    }
    
}
