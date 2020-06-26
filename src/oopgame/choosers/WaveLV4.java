package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV4 extends Wave {
    
    public WaveLV4(GameBase screen) {
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("abra", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("gastly", screen, Enemy.SLOW);
        }
        if (n < 75){
            return new EnemyNormal("koffing", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("slowpoke", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave2(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return getWave1();
        }
        if (n < 50){
            return new EnemyNormal("drowzee", screen, Enemy.SLOW);
        }
        if (n < 75){
            return new EnemyNormal("ekans", screen, Enemy.SLOW);
        }
        return new EnemyNormal("grimer", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave3(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("haunter", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("kadabra", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("slowbro", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("weezing", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave4(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave3();
        }
        if (n < 40){
            return new EnemyNormal("arbok", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("hypno", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("mr.mime", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("muk", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave5(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return getWave4();
        }
        if (n < 50){
            return new EnemyNormal("aerodactyl", screen, Enemy.SLOW);
        }
        if (n < 75){
            return new EnemyNormal("alakazam", screen, Enemy.SLOW);
        }
        return new EnemyNormal("gengar", screen, Enemy.NORMAL);
    }
    
}
