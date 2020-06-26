package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV2 extends Wave {

    public WaveLV2(GameBase screen) {
        super(screen);
    }

    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("rattata", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("pidgey", screen, Enemy.SLOW);
        }
        if (n < 75){
            return new EnemyNormal("spearow", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("doduo", screen, Enemy.NORMAL);
    }

    @Override
    public Enemy getWave2() {
        this.n = rand.nextInt(100);
        if (n < 37.5){
            return getWave1();
        }
        if (n < 50){
            return new EnemyNormal("ditto",screen,Enemy.NORMAL);
        }
        if (n < 62.5){
            return new EnemyNormal("raticate",screen,Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("farfetch'd",screen,Enemy.NORMAL);
        }
        if (n < 87.5){
            return new EnemyNormal("dodrio",screen,Enemy.NORMAL);
        }
        return new EnemyNormal("lickitung", screen, Enemy.NORMAL);
    }

    @Override
    public Enemy getWave3() {
        this.n = rand.nextInt(100);
        if (n < 37.5){
            return getWave2();
        }
        if (n < 50){
            return new EnemyNormal("fearow",screen,Enemy.NORMAL);
        }
        if (n < 62.5){
            return new EnemyNormal("chansey",screen,Enemy.NORMAL);
        }
        if (n < 75){
            return new EnemyNormal("hitmonlee",screen,Enemy.NORMAL);
        }
        if (n < 87.5){
            return new EnemyNormal("hitmonchan",screen,Enemy.NORMAL);
        }
        return new EnemyNormal("pidgeotto", screen, Enemy.NORMAL);
    }

    @Override
    public Enemy getWave4() {
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave3();
        }
        if (n < 40){
            return new EnemyNormal("eevee",screen,Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("jolteon",screen,Enemy.NORMAL);
        }
        if (n < 80){
            return new EnemyNormal("flareon",screen,Enemy.NORMAL);
        }
        return new EnemyNormal("vaporeon", screen, Enemy.NORMAL);
    }

    @Override
    public Enemy getWave5() {
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave4();
        }
        if (n < 40){
            return new EnemyNormal("kangaskhan",screen,Enemy.NORMAL);
        }
        if (n < 60){
            return new EnemyNormal("snorlax",screen,Enemy.NORMAL);
        }
        if (n < 80){
            return new EnemyNormal("porygon",screen,Enemy.NORMAL);
        }
        return new EnemyNormal("pidgeot", screen, Enemy.NORMAL);
    }
    
    
}
