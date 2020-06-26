package oopgame.screens;

import oopgame.screencontrol.ScreenControl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class MissionSelect extends ScreenTemplate {
    private ScreenControl control;
    private int selection;
    private Image missionSelect;
    private Image arrow;
    private Image bg1;
    private Image bg2;
    private Image bg3;
    private Image bg4;
    private Image bg5;
    private Image bg6;
    private Image bg7;
    private Image bg8;
    private Image bg9;
    private Image bg10;

    public MissionSelect(ScreenControl control){
        this.control = control;
        missionSelect = new ImageIcon("images/background/menuLevel.png").getImage();
        arrow = new ImageIcon("images/arrow.png").getImage();
        bg1 = new ImageIcon("images/background/insectPlant.png").getImage();
        bg2 = new ImageIcon("images/background/normal.png").getImage();
        bg3 = new ImageIcon("images/background/cave.png").getImage();
        bg4 = new ImageIcon("images/background/dark.png").getImage();
        bg5 = new ImageIcon("images/background/water.png").getImage();
        bg6 = new ImageIcon("images/background/volcano.png").getImage();
        bg7 = new ImageIcon("images/background/safari.png").getImage();
        bg8 = new ImageIcon("images/background/fairy.png").getImage();
        bg9 = new ImageIcon("images/background/rocket.png").getImage();
        bg10 = new ImageIcon("images/background/boss.png").getImage();      
        selection = 1;
    }
    
    @Override
    public void loop(double dt){
        repaint();
        tick(dt);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(missionSelect, 0, 0, this);
        switch(selection){
            case 1: g2d.drawImage(arrow, 80, 183, this);
                    g2d.drawImage(bg1, 300, 250, 200, 200, this);
            break;
            case 2: g2d.drawImage(arrow, 80, 219 , this);
                    g2d.drawImage(bg2, 300, 250, 200, 200, this);
            break;
            case 3: g2d.drawImage(arrow, 80, 255, this);
                    g2d.drawImage(bg3, 300, 250, 200, 200, this);
            break;
            case 4: g2d.drawImage(arrow, 80, 291, this);
                    g2d.drawImage(bg4, 300, 250, 200, 200, this);
            break;
            case 5: g2d.drawImage(arrow, 80, 327, this);
                    g2d.drawImage(bg5, 300, 250, 200, 200, this);
            break;
            case 6: g2d.drawImage(arrow, 80, 363, this);
                    g2d.drawImage(bg6, 300, 250, 200, 200, this);
            break;
            case 7: g2d.drawImage(arrow, 80, 399, this);
                    g2d.drawImage(bg7, 300, 250, 200, 200, this);
            break;
            case 8: g2d.drawImage(arrow, 80, 435, this);
                    g2d.drawImage(bg8, 300, 250, 200, 200, this);
            break;
            case 9: g2d.drawImage(arrow, 80, 471, this);
                    g2d.drawImage(bg9, 300, 250, 200, 200, this);
            break;
            case 10: g2d.drawImage(arrow, 80, 507, this);
                    g2d.drawImage(bg10, 300, 250, 200, 200, this);
            break;
        }
    }
    
    @Override
    public void tick(double dt) {
    }
    
    @Override
    public void keyDown(KeyEvent e){  //Vejo o input do usuario e mudo a tela de acordo
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            switch(selection){
                case 1: control.changeGameState(GameState.Level1);
                    break;
                case 2: control.changeGameState(GameState.Level2);
                    break;
                case 3: control.changeGameState(GameState.Level3);
                    break;
                case 4: control.changeGameState(GameState.Level4);
                    break;
                case 5: control.changeGameState(GameState.Level5);
                    break;
                case 6: control.changeGameState(GameState.Level6);
                    break;
                case 7: control.changeGameState(GameState.Level7);
                    break;
                case 8: control.changeGameState(GameState.Level8);
                    break;
                case 9: control.changeGameState(GameState.Level9);
                    break;
                case 10: control.changeGameState(GameState.Level10);
                    break;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            control.changeGameState(GameState.MenuScreen);
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            selection--;
            if (selection < 1) selection = 10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            selection++;
            if (selection > 10) selection = 1;
        }
    }
}