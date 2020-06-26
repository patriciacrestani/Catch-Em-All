package oopgame.choosers;

import oopgame.gameobjects.Enemy;
import oopgame.gameobjects.EnemyNormal;
import oopgame.screens.GameBase;

public class WaveLV5 extends Wave{
    public WaveLV5(GameBase screen){
        super(screen);
        lastWave = 6;
    }
    
    @Override
    public Enemy getWave1(){
        return new EnemyNormal("magikarp", screen, Enemy.SLOW);
    }
    
    @Override
    public Enemy getWave2(){
        n = rand.nextInt(100);
        if (n < 16){
            return getWave1();
        }
        if (n < 33){
            return new EnemyNormal("goldeen", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("poliwag", screen, Enemy.SLOW);
        }
        if (n < 66){
            return new EnemyNormal("seel", screen, Enemy.SLOW);
        }
        if (n < 83){
            return new EnemyNormal("slowpoke", screen, Enemy.SLOW);
        }
        return new EnemyNormal("squirtle", screen, Enemy.SLOW);  
    }
    
    @Override
    public Enemy getWave3(){
        n = rand.nextInt(100);
        if (n < 16){
            return getWave2();
        }
        if (n < 33){
            return new EnemyNormal("krabby", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("psyduck", screen, Enemy.SLOW);
        }
        if (n < 66){
            return new EnemyNormal("shellder", screen, Enemy.SLOW);
        }
        if (n < 83){
            return new EnemyNormal("staryu", screen, Enemy.SLOW);
        }
        return new EnemyNormal("tentacool", screen, Enemy.SLOW);  
    }
    
    @Override
    public Enemy getWave4(){
        n = rand.nextInt(100);
        if (n < 14){
            return getWave3();
        }
        if (n < 28){
            return new EnemyNormal("horsea", screen, Enemy.SLOW);
        }
        if (n < 42){
            return new EnemyNormal("poliwhirl", screen, Enemy.SLOW);
        }
        if (n < 57){
            return new EnemyNormal("seaking", screen, Enemy.SLOW);
        }
        if (n < 71){
            return new EnemyNormal("slowbro", screen, Enemy.SLOW);
        }
        if (n < 89){
            return new EnemyNormal("vaporeon", screen, Enemy.SLOW);
        }
        return new EnemyNormal("wartortle", screen, Enemy.SLOW);  
    }
    
    @Override
    public Enemy getWave5(){
        n = rand.nextInt(100);
        if (n < 14){
            return getWave4();
        }
        if (n < 28){
            return new EnemyNormal("cloyster", screen, Enemy.SLOW);
        }
        if (n < 42){
            return new EnemyNormal("dewgong", screen, Enemy.SLOW);
        }
        if (n < 57){
            return new EnemyNormal("golduck", screen, Enemy.SLOW);
        }
        if (n < 71){
            return new EnemyNormal("kingler", screen, Enemy.SLOW);
        }
        if (n < 89){
            return new EnemyNormal("starmie", screen, Enemy.SLOW);
        }
        return new EnemyNormal("tentacruel", screen, Enemy.SLOW);  
    }
    
    @Override
    public Enemy getWave6(){
        n = rand.nextInt(100);
        if (n < 16){
            return getWave5();
        }
        if (n < 33){
            return new EnemyNormal("blastoise", screen, Enemy.SLOW);
        }
        if (n < 50){
            return new EnemyNormal("gyarados", screen, Enemy.SLOW);
        }
        if (n < 66){
            return new EnemyNormal("lapras", screen, Enemy.SLOW);
        }
        if (n < 83){
            return new EnemyNormal("poliwrath", screen, Enemy.SLOW);
        }
        return new EnemyNormal("seadra", screen, Enemy.SLOW);  
    }
    
}
