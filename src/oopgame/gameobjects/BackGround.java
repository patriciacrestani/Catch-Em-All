package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import oopgame.screens.ScreenTemplate;

public class BackGround {
    private Image backGroundImage;
    private ScreenTemplate screen;
    
    public BackGround(ScreenTemplate screen){
        backGroundImage = new ImageIcon("images/background/orange.png").getImage();
    }
    
    public void render(Graphics2D g){
        g.drawImage(backGroundImage, 0, 0, screen);
    }
    
    public void setBackGround(String imgName){
        backGroundImage = new ImageIcon("images/background/" + imgName + ".png").getImage();
    }
}
