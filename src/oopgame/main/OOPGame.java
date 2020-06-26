package oopgame.main;

import oopgame.screencontrol.ScreenControl;

public class OOPGame {

    private ScreenControl control;
    
    public OOPGame(){
        
        control = new ScreenControl();
        loop();
    }
    
    private void loop(){
        
        double last_time = System.nanoTime();
        double time;
        double delta_time;
        
        while(control.isRunning()){
            time = System.nanoTime();
            delta_time = ((time - last_time)/1000000000);
            last_time = time;
            control.getScreen().loop(delta_time);
        }
        control.getFrame().dispose();
    }
    
    public static void main(String[] args) {
        OOPGame oopgame = new OOPGame();
    }
}