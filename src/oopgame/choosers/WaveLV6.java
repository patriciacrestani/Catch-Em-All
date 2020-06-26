package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV6 extends Wave {
    
    public WaveLV6(GameBase screen){
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("diglett", screen, Enemy.NORMAL);
        }
        if (n < 50){
            return new EnemyNormal("geodude", screen, Enemy.NORMAL);        
        }
        if (n < 75){
            return new EnemyNormal("ponyta", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("sandshrew", screen, Enemy.NORMAL); 
    }
    
    @Override
    public Enemy getWave2(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("charmander", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("cubone", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("dugtrio", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("flareon", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave3(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("graveler", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("growlithe", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("sandslash", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("vulpix", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave4(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("charmaleon", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("magmar", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("marowak", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("rapidash", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave5(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("arcanine", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("charizard", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("golem", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("ninetales", screen, Enemy.NORMAL);
    }

}
