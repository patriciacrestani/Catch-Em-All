package oopgame.gadgets;

import java.util.List;
import java.util.Random;
import oopgame.choosers.Wave;
import oopgame.gameobjects.Enemy;
import oopgame.screencontrol.ScreenControl;
import oopgame.screens.GameState;

public class SpawnControl {
    private Random rand;
    private Timer timer;
    private Wave wave;
    private List<Enemy> enemyList;
    private ScreenControl control;
    
    public SpawnControl(Wave wave, List<Enemy> enemyList, ScreenControl control){
        this.wave = wave;
        this.enemyList = enemyList;
        this.control = control;
        rand = new Random();
        timer = new Timer(rand.nextDouble() * 3);
    }
    
    public void spawn(double dt){
        timer.tick(dt);
        if (timer.isReady() && wave.getWave() < (wave.getLastWave() + 1)){
            enemyList.add(wave.getPokemon());
            timer.setGoal(rand.nextDouble() * 3);
            timer.reset();
        }
        if (wave.getWave() >= (wave.getLastWave() + 1) && enemyList.isEmpty()){
            control.changeGameState(GameState.MenuScreen);
        }
    }
    public void spawnNow(){
        timer.setGoal(0);
    }
}