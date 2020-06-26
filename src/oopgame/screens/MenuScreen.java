package oopgame.screens;

import oopgame.screencontrol.ScreenControl;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class MenuScreen extends ScreenTemplate {
    private ScreenControl control;
    private Image menu;
    private Image pokeball;
    private int selection;
    
    public MenuScreen(ScreenControl control){
        this.control = control;
        menu = new ImageIcon("images/background/menu.png").getImage();
        pokeball = new ImageIcon("images/balls/pokeball.png").getImage();
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
        g2d.drawImage(menu, 0, 0, this);
        if(selection == 1){
            g2d.drawImage(pokeball, 160, 430, this);
        }else if (selection == 2){
            g2d.drawImage(pokeball, 160, 479, this);
        }else{
            g2d.drawImage(pokeball, 160, 538, this);
        }
    }
    
    @Override
    public void tick(double dt) {
    }
    
    @Override
    public void keyDown(KeyEvent e){  //Vejo o input do usuario e mudo a tela de acordo
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            selection--;
            if (selection < 1) selection = 3;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            selection++;
            if (selection > 3) selection = 1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            switch (selection) {
                case 1:
                    control.changeGameState(GameState.MissionSelect);
                    break;
                case 2:
                    control.changeGameState(GameState.Pokedex);
                    break;
                default:
                    control.changeGameState(GameState.Quit);
                    break;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_L){
            control.changeGameState(GameState.Loading);
        }
        else if(e.getKeyCode() == KeyEvent.VK_P){
            control.changeGameState(GameState.Pokedex);
        }
        
    }
}
