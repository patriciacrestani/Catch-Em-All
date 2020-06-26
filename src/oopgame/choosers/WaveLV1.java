package oopgame.choosers;

import oopgame.gameobjects.*;
import oopgame.screens.GameBase;

public class WaveLV1 extends Wave {
    
    public WaveLV1(GameBase screen){
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("weedle", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("caterpie", screen, Enemy.SLOW);
        }
        if (n < 75){
            return new EnemyNormal("bellsprout", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("oddish", screen, Enemy.NORMAL);
    }

    @Override
    public Enemy getWave2() {
        this.n = rand.nextInt(100);
        if (n < 37.5){
            return getWave1();
        }
        if (n < 50){
            return new EnemyNormalProjectile("bulbasaur",screen,Enemy.NORMAL,"leaf", "normal");
        }
        if (n < 62.5){
            return new EnemyNormal("kakuna",screen,Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("metapod",screen,Enemy.NORMAL);
        }
        if (n < 87.5){
            return new EnemyNormal("paras",screen,Enemy.NORMAL);
        }
        return new EnemyNormalProjectile("gloom", screen, Enemy.NORMAL, "leaf", "normal");
    }

    @Override
    public Enemy getWave3() {
        this.n = rand.nextInt(100);
        if (n < 37.5){
            return getWave2();
        }
        if (n < 50){
            return new EnemyHorizontalProjectile("weepinbell",screen,Enemy.NORMAL, "leaf", "normal");
        }
        if (n < 62.5){
            return new EnemyNormal("parasect",screen,Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("venonat",screen,Enemy.NORMAL);
        }
        if (n < 87.5){
            return new EnemyNormal("tangela",screen,Enemy.NORMAL);
        }
        return new EnemyNormal("pinsir", screen, Enemy.NORMAL);
    }

    @Override
    public Enemy getWave4() {
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave3();
        }
        if (n < 40){
            return new EnemyNormalProjectile("ivysaur",screen,Enemy.FAST, "leaf", "normal");
        }
        if (n < 60){
            return new EnemyNormal("beedrill",screen,Enemy.FAST);
        }
        if (n < 80){
            return new EnemyNormal("butterfree",screen,Enemy.NORMAL);
        }
        return new EnemyHorizontalProjectile("victreebel", screen, Enemy.NORMAL, "leaf", "hoaming");
    }

    @Override
    public Enemy getWave5() {
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave4();
        }
        if (n < 40){
            return new EnemyNormal("venomoth",screen,Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("scyther",screen,Enemy.NORMAL);
        }
        if (n < 80){
            return new EnemyHorizontalProjectile("vileplume",screen,Enemy.NORMAL, "leaf", "hoaming");
        }
        return new EnemyNormalProjectile("venusaur", screen, Enemy.NORMAL, "leaf", "hoaming");
    }
    
    
}
