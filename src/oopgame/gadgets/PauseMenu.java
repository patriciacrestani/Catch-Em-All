package oopgame.gadgets;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import oopgame.screencontrol.ScreenControl;
import oopgame.screens.GameBase;
import oopgame.screens.GameState;

public class PauseMenu {
    private GameBase screen;
    private ScreenControl control;
    private String level;
    private Image menu;
    private Image arrow;
    private Image options;
    private boolean op;
    private int selection;
    private boolean paused;
    
    
    public PauseMenu(GameBase screen, ScreenControl control, String level){
        this.screen = screen;
        this.control = control;
        this.level = level;
        menu = new ImageIcon("images/pause.png").getImage();
        arrow = new ImageIcon("images/arrow.png").getImage();
        options = new ImageIcon("images/backGround/options.png").getImage();
        selection = 1;
        paused = false;
    }
    
    public void render(Graphics2D g){
        g.drawImage(menu, 196, 176, screen);
        switch(selection){
            case 1:
                g.drawImage(arrow, 220, 234,screen);
                break;
            case 2:
                g.drawImage(arrow, 220, 282,screen);
                break;
            case 3:
                g.drawImage(arrow, 220, 330,screen);
                break;
            case 4:
                g.drawImage(arrow, 220, 378,screen);
                break;
        }
        if(op) g.drawImage(options, 0, 0, screen);
        
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            selection ++;
            if (selection > 4) selection = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            selection--;
            if (selection < 1) selection = 4;
            
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            op = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            switch(selection){
                case 1:
                    paused = false;
                    break;
                case 2:
                    if ("1".equals(level)) control.changeGameState(GameState.Level1);
                    else if ("2".equals(level)) control.changeGameState(GameState.Level2);
                    else if ("3".equals(level)) control.changeGameState(GameState.Level3);
                    else if ("4".equals(level)) control.changeGameState(GameState.Level4);
                    else if ("5".equals(level)) control.changeGameState(GameState.Level5);
                    else if ("6".equals(level)) control.changeGameState(GameState.Level6);
                    else if ("7".equals(level)) control.changeGameState(GameState.Level7);
                    else if ("8".equals(level)) control.changeGameState(GameState.Level8);
                    else if ("9".equals(level)) control.changeGameState(GameState.Level9);
                    else if ("10".equals(level)) control.changeGameState(GameState.Level10);
                    break;
                case 3:
                    op = true;
                    break;
                case 4:
                    control.changeGameState(GameState.MenuScreen);
                    
            }
            
        }
    }
    
    public boolean isPaused(){
        return paused;
    }
    
    public void pauseGame(){
        this.paused = true;
        selection = 1;
    }
    
}
