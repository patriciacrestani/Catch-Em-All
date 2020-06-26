package oopgame.choosers.userinterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import oopgame.choosers.Wave;
import oopgame.gadgets.Timer;
import oopgame.gameobjects.Player;
import oopgame.screens.GameBase;

public class HUD {
    private Player player;
    private Wave wave;
    private Timer time;
    private GameBase screen;
    private Image hpBar;
    private Image fence;
    private int totalHp;
    private int currentHp;
    
    public HUD(Player player, Wave wave , GameBase screen){
        this.player = player;
        this.wave = wave;
        this. screen = screen;
        hpBar = new ImageIcon("images/hp.png").getImage();
        fence = new ImageIcon("images/fence.png").getImage();
        totalHp = player.getHP();
        time = new Timer(0);
    }
    
    public void tick(double dt){
        time.tick(dt);
    }
    
    public void render(Graphics2D g){
        g.drawImage(fence, 0, 460, screen);
        /// health bar /////
        g.drawImage(hpBar, 5, 5, screen);
        g.setColor(Color.GREEN);
        currentHp = player.getHP();
        if (currentHp > totalHp) currentHp = totalHp;
        for(int i = 0; i < currentHp; i++){
            g.fillRect(i*(200/totalHp) +64, 7, 200/totalHp, 6);
            
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g.drawString(String.valueOf(player.getHP()) + "/" + String.valueOf(totalHp), 248, 26);
        ////////////////////
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
        g.drawString(String.format("%.02f",time.getTime()), 540, 30);
//        g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 
//        g.drawString("wave "+ String.valueOf(wave.getWave()), 540, 60);
//        g.drawString("s - spawn", 540, 80);
//        g.drawString("r - restart", 540, 100);
//        g.drawString("d - sleep", 540, 120);
//        g.drawString("sleep: " + String.format("%.02f",player.getSleepTime()), 540, 140);
//        g.drawString("e - god Mod", 540, 160);
//        g.drawString("inv: " + String.format("%.02f",player.getInvincibilityTime()), 540, 180);
//        g.drawString("f - fast", 540, 200);
//        g.drawString("fast: " + String.format("%.02f",player.getFastTime()), 540, 220);
        
    }
    
    
}
