package oopgame.screens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import oopgame.choosers.WaveLV3;
import oopgame.gadgets.SpawnControl;
import oopgame.choosers.userinterface.HUD;
import oopgame.screencontrol.ScreenControl;

public class Level3 extends GameBase {
    private HUD hud;
    private WaveLV3 wave;
    private SpawnControl spawnControl;

    public Level3(ScreenControl control, String level){
        super(control, level);
        wave = new WaveLV3(this);
        hud = new HUD(player, wave, this);
        spawnControl = new SpawnControl(wave, enemyList, control);
        backGround.setBackGround("cave");
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
