package oopgame.screens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import oopgame.choosers.WaveLV2;
import oopgame.gadgets.SpawnControl;
import oopgame.choosers.userinterface.HUD;
import oopgame.screencontrol.ScreenControl;

public class Level2 extends GameBase {
    private HUD hud;
    private WaveLV2 wave;
    private SpawnControl spawnControl;

    public Level2(ScreenControl control, String level){
        super(control,level);
        wave = new WaveLV2(this);
        hud = new HUD(player, wave, this);
        spawnControl = new SpawnControl(wave, enemyList, control);
        backGround.setBackGround("normal");
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