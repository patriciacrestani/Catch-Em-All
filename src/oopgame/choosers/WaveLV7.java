package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV7 extends Wave {
    public WaveLV7(GameBase screen){
        super(screen);
    }
    
    @Override
    public Enemy getWave1(){
        this.n = rand.nextInt(100);
        if (n < 25){
            return new EnemyNormal("cubone", screen, Enemy.NORMAL);
        }
        if (n < 50){
            return new EnemyNormal("farfetch'd", screen, Enemy.NORMAL);        
        }
        if (n < 75){
            return new EnemyNormal("nidoranF", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("nidoranM", screen, Enemy.NORMAL); 
    }
    
    @Override
    public Enemy getWave2(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("doduo", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("exeggcute", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("krabby", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("mankey", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave3(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("marowak", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("pikachu", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("nidorina", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("nidorino", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave4(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("dodrio", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("exeggutor", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("kingler", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("primeape", screen, Enemy.NORMAL);
    }
    
    @Override
    public Enemy getWave5(){
        this.n = rand.nextInt(100);
        if (n < 20){
            return getWave2();
        }
        if (n < 40){
            return new EnemyNormal("tauros", screen, Enemy.SLOW);
        }
        if (n < 60){
            return new EnemyNormal("raichu", screen, Enemy.SLOW);
        }
        if (n < 80){
            return new EnemyNormal("nidoqueen", screen, Enemy.NORMAL);
        }
        return new EnemyNormal("nidoking", screen, Enemy.NORMAL);
    }

}

