package oopgame.gadgets;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import oopgame.screens.ScreenTemplate;

public class InputHandler implements KeyListener{
    
    private ScreenTemplate screen;
    
    public InputHandler(ScreenTemplate screen){
        this.screen = screen;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        screen.keyDown(ke);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        screen.keyUp(ke);
    }
    
}
