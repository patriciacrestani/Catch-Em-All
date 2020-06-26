package oopgame.gameobjects;

import oopgame.screens.GameBase;

public class EnemyNormal extends Enemy {
    
    
    public EnemyNormal(String imgName, GameBase screen, int velocity){
        super(imgName, screen);
        velY = velocity;
    }
}
