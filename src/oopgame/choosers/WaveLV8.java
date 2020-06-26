package oopgame.choosers;

import oopgame.screens.GameBase;
import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;

public class WaveLV8 extends Wave {
    public WaveLV8(GameBase screen){
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        n = rand.nextInt(100);
        if (n < 33){
            return new EnemyNormal("clefairy", screen, Enemy.NORMAL);
        }
        if (n < 66){
            return new EnemyNormal("dratini", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("vulpix", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave2(){
        n = rand.nextInt(100);
        if (n < 25){
            getWave1();
        }
        if (n < 50){
            return new EnemyNormal("butterfree", screen, Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("dewgong", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("jynx", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave3(){
        n = rand.nextInt(100);
        if (n < 20){
            getWave1();
        }
        if (n < 40){
            return new EnemyNormal("dragonair", screen, Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("jigglypuff", screen, Enemy.NORMAL);
        }
        if (n < 80){
            return new EnemyNormal("ninetales", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("persian", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave4(){
        n = rand.nextInt(100);
        if (n < 25){
            getWave1();
        }
        if (n < 50){
            return new EnemyNormal("chansey", screen, Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("clefable", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("slowpoke", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave5(){
        n = rand.nextInt(100);
        if (n < 25){
            getWave1();
        }
        if (n < 50){
            return new EnemyNormal("dragonite", screen, Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("porygon", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("wigglypuff", screen, Enemy.NORMAL);
    }
    
    
    
}
