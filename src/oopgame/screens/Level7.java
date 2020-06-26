package oopgame.screens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import oopgame.choosers.WaveLV7;
import oopgame.gadgets.SpawnControl;
import oopgame.choosers.userinterface.HUD;
import oopgame.screencontrol.ScreenControl;

public class Level7 extends GameBase {
    private HUD hud;
    private WaveLV7 wave;
    private SpawnControl spawnControl;

    public Level7(ScreenControl control, String level){
        super(control, level);
        wave = new WaveLV7(this);
        hud = new HUD(player, wave, this);
        spawnControl = new SpawnControl(wave, enemyList, control);
        backGround.setBackGround("safari");
    }

    @Override
    public void tick(double dt){
        super.tick(dt);
        hud.tick(dt);
        spawnControl.spawn(dt);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        hud.render(g2d);
    }
    
}