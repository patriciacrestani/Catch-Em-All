package oopgame.screens;

import oopgame.gameobjects.*;
import oopgame.screencontrol.ScreenControl;

public class LevelBoss extends GameBase{
    
     public LevelBoss(ScreenControl control,String level){
        super(control, level);  
        backGround.setBackGround("boss");
        
        enemyList.add(new EnemyBoss("mewtwo", this, Enemy.BOSS, "shadowBall", "normal"));
    }
    
}
