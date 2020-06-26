package oopgame.choosers;

import java.util.Random;
import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public abstract class Wave {
    protected GameBase screen;
    protected Random rand;
    protected int n;
    protected int wave;
    protected int enemyCounter;
    protected int lastWave;
    
    public Wave(GameBase screen){
        this.screen = screen;
        rand = new Random();
        wave = 1;
        enemyCounter = 0;
        lastWave = 5;
    }
    
    public int getWave(){
        return wave;
    }
    
    public void checkWaveChanger(){
        enemyCounter++;
        if(enemyCounter > 20 && wave <= lastWave){
            wave++;
            enemyCounter = 0;
        }
    }
    
    public Enemy getPokemon(){
        checkWaveChanger();
        switch (getWave()){
                case 1:
                    return getWave1();
                case 2:
                    return getWave2();
                case 3:
                    return getWave3();
                case 4:
                    return getWave4();
                case 5:
                    return getWave5();
                default:
                    return getWave6();
            }
    }
    
    public abstract Enemy getWave1();
    public abstract Enemy getWave2();
    public abstract Enemy getWave3();
    public abstract Enemy getWave4();
    public abstract Enemy getWave5();
    
    public Enemy getWave6(){
        return new EnemyNormal("debugMagikarp", screen, Enemy.SLOW);
    }
    
    
    public int getLastWave(){
        return lastWave;
    }
    
}
