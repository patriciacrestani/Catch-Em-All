package oopgame.screens;

import oopgame.gadgets.InputHandler;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public abstract class ScreenTemplate extends JPanel{
    
    public ScreenTemplate(){  //Interface KeyListener do JPanel. Ela detecta input do usuário a todo momento
        addKeyListener(new InputHandler(this));
    }
    
    public abstract void loop(double dt);
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    public abstract void tick(double dt);
    
    public void keyDown(KeyEvent e){ //esse método é chamado sempre que aperto uma tecla
        
    }
    public void keyUp(KeyEvent e){ //é chamado sempre que solto uma tecla
        
    }  
    
}
