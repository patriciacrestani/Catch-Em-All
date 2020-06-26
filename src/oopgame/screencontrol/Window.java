package oopgame.screencontrol;

import javax.swing.JFrame;

public class Window {
    private JFrame frame;
    private final String titulo = "GAME!!!";
    private final int W = 600, H = 600;
    
    public Window(){
        frame = new JFrame(titulo);
        frame.setSize(W, H);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public JFrame getFrame(){
        return frame;
    }
}
