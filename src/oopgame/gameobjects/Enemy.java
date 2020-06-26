package oopgame.gameobjects;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import oopgame.gadgets.Timer;
import oopgame.screens.GameBase;

public abstract class Enemy extends GameObject {
    protected GameBase screen;
    private Image pokemon;
    private Image pokemon2;
    private Random rand; 
    private Timer timer;
    private float alpha;
    protected int hp;
    private boolean can;
    private boolean fade;
    private String imgName;
    public static final int SLOW = 90;
    public static final int NORMAL = 150;
    public static final int FAST = 200;
    public static final int BOSS = 130;
   
    
    public Enemy(String imgName, GameBase screen){
        this.screen = screen;
        this.pokemon = new ImageIcon("images/pokemon/" + imgName + ".png").getImage();
        this.pokemon2 = new ImageIcon("images/pokemon/" + imgName + "2.png").getImage();
        this.imgName = imgName;
        width = pokemon.getWidth(screen) * 2;
        height = pokemon.getHeight(screen) * 2;
        this.rand = new Random();
        x = (rand.nextInt(6)+1)*100-50 - width/2;
        y = -70;
        timer = new Timer(0.1);
        alpha = 1f;
        hp = 1;
        if (pokemon.getWidth(screen) <= 0) System.out.println("nome ta errado: " + imgName);
    }
    
    @Override
    public void tick(double dt) {
        move(dt);
        timer.tick(dt);
        if (timer.isReady()){
            timer.reset();
            can = !can;
        }
        if(fade){
            if(alpha - dt > 0) alpha -= dt;
            else alpha = 0;
        }
    }
    
    public void damage(){
        hp -= 1;
    }
    
    public boolean isDead(){
        return hp<=0;
    }
    
    public void startFading(){
        velX = 0;
        velY = 0;
        fade = true;
    }
    
    public float getAlpha(){
        return alpha;
    }
    
    public boolean isFading(){
        return fade;
    }
    
    public String getImgName(){
        return imgName;
    }

    @Override
    public void render(Graphics2D g) {
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
        
        if(can)
            g.drawImage(pokemon, (int)x,(int)y, width, height, screen);
        else
            g.drawImage(pokemon2,(int)x,(int)y, width, height, screen);
        
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1));
    }
    
    public void move(double dt){
        y += velY*dt;
        x += velX*dt;
    }
    
    public int getHeight(){
        return height;
    }
    
}
