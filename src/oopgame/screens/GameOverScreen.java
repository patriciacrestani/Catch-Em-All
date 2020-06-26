package oopgame.screens;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import oopgame.screencontrol.ScreenControl;

public class GameOverScreen extends ScreenTemplate {
    private ScreenControl control;
    private Image gameOver;
    
    
    public GameOverScreen(ScreenControl control){
        this.control = control;
        gameOver = new ImageIcon("images/background/gameOver.png").getImage();
    }
    
    @Override
    public void loop(double dt) {
        repaint();
        tick(dt);
    }

    @Override
    public void tick(double dt) {
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(gameOver, 0, 0, this);
    }
    
    @Override
    public void keyDown(KeyEvent e){  //Vejo o input do usuario e mudo a tela de acordo
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            control.changeGameState(GameState.MenuScreen);
        }
    }
    
}
