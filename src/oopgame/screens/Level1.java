package oopgame.screens;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import oopgame.choosers.WaveLV1;
import oopgame.gadgets.SpawnControl;
import oopgame.choosers.userinterface.HUD;
import oopgame.screencontrol.ScreenControl;

public class Level1 extends GameBase {
    private HUD hud;
    private WaveLV1 wave;
    private SpawnControl spawnControl;
    
    public Level1(ScreenControl control,String level){
        super(control, level);
        wave = new WaveLV1(this);
        hud = new HUD(player, wave, this);
        spawnControl = new SpawnControl(wave, enemyList, control);
        backGround.setBackGround("insectPlant");
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
    
    @Override
    public void keyUp(KeyEvent e){    ///Para teste de funcoes
        super.keyUp(e);
//        if(e.getKeyCode() == KeyEvent.VK_S)
//            spawnControl.spawnNow();
//        if(e.getKeyCode() == KeyEvent.VK_D)
//            player.sleep();
//        if(e.getKeyCode() == KeyEvent.VK_E)
//            player.invincibility();
//        if(e.getKeyCode() == KeyEvent.VK_F)
//            player.fast();
    }
    
}
