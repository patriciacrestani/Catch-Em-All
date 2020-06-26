package oopgame.gameobjects;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import oopgame.screens.GameBase;

public class PokeBall extends GameObject {
    private GameBase screen;
    private Image pokeball;
    
    public PokeBall(GameBase screen, int x){
        this.screen = screen;
        this.x = x;
        y = 471;
        velX = 0;
        velY = 0;
        pokeball = new ImageIcon("images/balls/pokeball.png").getImage();
        width = pokeball.getWidth(screen);
        height = pokeball.getHeight(screen);
    }
    
    @Override
    public void tick(double dt){
        y += velY*dt;
        if(y < -height) hit();
    }
    
    @Override
    public void render(Graphics2D g){ 
        g.drawImage(pokeball, (int)x, (int)y, screen);
    }
    
    public void startMovement(){
        velY = -200;
    }
    
    public void hit(){
        reset();
    }
    
    public void reset(){
        velY = 0;
        y = 471;
    }
}
