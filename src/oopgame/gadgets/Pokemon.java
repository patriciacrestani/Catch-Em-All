package oopgame.gadgets;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import oopgame.screens.ScreenTemplate;

public class Pokemon {
    private String name;
    private int captured;
    private ScreenTemplate screen;
    
    Image pokeImage;
    Image pokeImage2;
    private int width;
    private int height;
    private int position;
    private Timer timer;
    private boolean can;
    
    
    public Pokemon(int position, String name, int captured, ScreenTemplate screen){
        this.name = name;
        this.captured = captured;
        this.screen = screen;
        this.position = position;
        pokeImage = new ImageIcon("images/pokemon/" + name + ".png").getImage();
        pokeImage2 = new ImageIcon("images/pokemon/" + name + "2.png").getImage();
        width = pokeImage.getWidth(screen);
        height = pokeImage.getHeight(screen);
        timer = new Timer(0.1);
    }
    
    public void tick(double dt){
        timer.tick(dt);
        if (timer.isReady()){
            timer.reset();
            can = !can;
        }
    }
    
    public void render(Graphics g){
        if(can){
            g.drawImage(pokeImage, 142 - width *3, position*160 +295  - height*3 , width*6 ,height*6, screen);
        }else{
            g.drawImage(pokeImage2, 142 - width *3, position*160 +295  - height*3 , width*6 ,height*6, screen);
        }
    }
    
    public void captured(){
        captured = 1;
    }
    
    public Image getImage(){
        return pokeImage;
    }
    
    public int isCaptured(){
        return captured;
    }
    
    public String getName(){
        return name;
    }  
    
    public int getPosition(){
        return position;
    }
    
    public void moveUp(){
        position++;
    }
    
    public void moveDown(){
        position--;
    }
    
}
