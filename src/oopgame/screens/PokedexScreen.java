package oopgame.screens;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import oopgame.gadgets.PokedexInfo;
import oopgame.gadgets.Pokemon;
import oopgame.screencontrol.ScreenControl;

public class PokedexScreen extends ScreenTemplate {
    private Image pokedexImage;
    private Image upImage;
    private Image downImage;
    private Image frame; 
    private Image outFrame;
    private Image frameBackGround;
    private Image unknown;
    private Image scroll;
    private Image pokeball;
    private ScreenControl control;
    private List<Pokemon> pokemonList;
    private int quantity;
    private int selection;
    private int unknownWidth;
    private int unknownHeight;
    private PokedexInfo info;
    
    public PokedexScreen(ScreenControl control){
        this.control = control;
        pokedexImage = new ImageIcon("images/pokedex/pokedex.png").getImage();
        upImage = new ImageIcon("images/pokedex/up.png").getImage();
        downImage = new ImageIcon("images/pokedex/down.png").getImage();
        frame = new ImageIcon("images/pokedex/frame.png").getImage();
        outFrame = new ImageIcon("images/pokedex/outFrame.png").getImage();
        pokeball = new ImageIcon("images/pokedex/pokeball.png").getImage();
        frameBackGround = new ImageIcon("images/pokedex/frameBackGround.png").getImage();
        unknown = new ImageIcon("images/pokedex/unknown.png").getImage();
        scroll = new ImageIcon("images/pokedex/scroll.png").getImage();
        
        selection = 0;
        unknownWidth = unknown.getWidth(this);
        unknownHeight = unknown.getHeight(this);

        info = new PokedexInfo(this);
        pokemonList = info.getPokemonList();
        quantity = info.getQuantity();
        
    }
    
    @Override
    public void loop(double dt) {
        tick(dt);
        repaint();
    }

    @Override
    public void tick(double dt) {
        for (int i = 0; i < quantity; i++){
            pokemonList.get(i).tick(dt);
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(upImage, 40, 96, this);
        g.drawImage(downImage, 40, 432, this);
        g.drawImage(frameBackGround, 250, 66,this);
        g.drawImage(outFrame, 263, 269, this);
        for (int i = 0; i < quantity; i++){
            g.drawImage(frame, 266, pokemonList.get(i).getPosition()*100 + 272, this);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString(String.valueOf(pokemonList.get(i).getName()), 280, pokemonList.get(i).getPosition()*100 + 305);
            g.drawString(String.valueOf(i+1),480, pokemonList.get(i).getPosition()*100 + 305);
            if(pokemonList.get(i).isCaptured() == 1){
                pokemonList.get(i).render(g);
                g.drawImage(pokeball, 254, pokemonList.get(i).getPosition()*100 + 286, this);
                
            }else{
                g.drawImage(unknown, 142 - unknownWidth *3, (i - selection)*160 +295  - unknownHeight*3, unknownWidth*6 ,unknownHeight*6, this);
            } 
        }
        g.drawImage(pokedexImage, 0, 0, this);
        g.drawImage(scroll, 532, (int)(((432.0/150.0)*selection) + 72) , this); // 72 a 504 = 432
    }
    
    public PokedexInfo getPokedexInfo(){
        return info;
    }
    
    @Override
    public void keyDown(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(selection >= 0 && selection < quantity - 1){
                for(int i = 0; i < quantity; i++) pokemonList.get(i).moveDown();
                selection ++;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(selection > 0 && selection < quantity){
                for(int i = 0; i < quantity; i++) pokemonList.get(i).moveUp();
                selection--;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            control.changeGameState(GameState.MenuScreen);
        }
    }
    
}
