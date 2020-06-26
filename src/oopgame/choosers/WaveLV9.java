package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV9 extends Wave {
    public WaveLV9(GameBase screen){
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("grimer", screen, Enemy.NORMAL);
        }
        if (n < 50){
            return new EnemyNormal("koffing", screen, Enemy.NORMAL);        
        }
        if (n < 75){
            return new EnemyNormal("voltorb", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("zubat", screen, Enemy.NORMAL); 
    }
    
    @Override
    public Enemy getWave2(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave1();
        }
        if (n < 40){
            return new EnemyNormal("ekans", screen, Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("magnemite", screen, Enemy.NORMAL);        
        }
        if (n < 80){
            return new EnemyNormal("meowth", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("raticate", screen, Enemy.NORMAL); 
    }
    
    @Override
    public Enemy getWave3(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("electrode", screen, Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("golbat", screen, Enemy.NORMAL);        
        }
        if (n < 80){
            return new EnemyNormal("hypno", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("weezing", screen, Enemy.NORMAL); 
    }
    
    @Override
    public Enemy getWave4(){
        this.n = rand.nextInt(100);
        if (n < 16){
            return getWave3();
        }
        if (n < 33){
            return new EnemyNormal("magneton", screen, Enemy.NORMAL);
        }
        if (n < 50){
            return new EnemyNormal("persian", screen, Enemy.NORMAL);        
        }
        if (n < 66){
            return new EnemyNormal("rhyhorn", screen, Enemy.NORMAL);
        }
        if (n < 83){
            return new EnemyNormal("tauros", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("venomoth", screen, Enemy.NORMAL); 
    }
    
    @Override
    public Enemy getWave5(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave4();
        }
        if (n < 40){
            return new EnemyNormal("arbok", screen, Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("electabuzz", screen, Enemy.NORMAL);        
        }
        if (n < 80){
            return new EnemyNormal("muk", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("rhydon", screen, Enemy.NORMAL); 
    }
}
