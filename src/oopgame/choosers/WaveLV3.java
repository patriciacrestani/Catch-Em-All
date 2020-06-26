package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV3 extends Wave {
    
    public WaveLV3(GameBase screen) {
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("geodude", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("machop", screen, Enemy.SLOW);
        }
        if (n < 75){
            return new EnemyNormal("sandshrew", screen, Enemy.NORMAL);
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
            return new EnemyNormal("diglett", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("kabuto", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("omanyte", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("rhyhorn", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave3(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("abra", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("graveler", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("machoke", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("sandslash", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave4(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave3();
        }
        if (n < 40){
            return new EnemyNormal("dugtrio", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("golbat", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("kabutops", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("omaster", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave5(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave4();
        }
        if (n < 40){
            return new EnemyNormal("golem", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("onix", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("machamp", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("rhydon", screen, Enemy.NORMAL);
    }
    
    
    
}
