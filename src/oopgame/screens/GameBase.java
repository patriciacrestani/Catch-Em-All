package oopgame.screens;

import oopgame.gameobjects.*;
import oopgame.screencontrol.ScreenControl;
import oopgame.gadgets.Collision;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import oopgame.gadgets.PauseMenu;


public abstract class GameBase extends ScreenTemplate {
    
    protected ScreenControl control;
    protected String level;
    protected Player player;
    protected List<Enemy> enemyList;
    protected List<Projectile> projList;
    protected List<PowerUps> powerList;
    protected PokeBall[] pokeBallList;
    protected BackGround backGround;
    protected Collision collision;
    private PauseMenu pause;
    
    public GameBase(ScreenControl control,String level){
        this.control = control;
        this.level = level;
        /////// Criacao dos objetos do jogo /////////
        player = new Player(this);
        pokeBallList = new PokeBall[6];
        for (int i = 0; i < 6; i++)
            pokeBallList[i] = new PokeBall(this, 35 + 100*i);
        enemyList = new CopyOnWriteArrayList<>(); // Quem decide quais inimigos serao colocdos eh o level
        projList = new CopyOnWriteArrayList<>();
        powerList = new CopyOnWriteArrayList<>();
        ////////////////////////////////////////////
        collision = new Collision(player, enemyList, projList, pokeBallList, powerList, control, this);
        backGround = new BackGround(this);
        pause = new PauseMenu(this, control, level);
    }
    
    @Override
    public void loop(double dt){
        if (!pause.isPaused()){
            tick(dt);
            collision.checkCollision();
        }
        repaint();
    }
    
    @Override
    public void tick(double dt) {
        player.tick(dt);
        for (int i = 0; i < 6; i++)
            pokeBallList[i].tick(dt);
        for(Enemy enemy : enemyList)
            enemy.tick(dt);
        for(Projectile proj : projList)
            proj.tick(dt);
        for(PowerUps power : powerList){
            power.tick(dt);
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2d = (Graphics2D) g;
        backGround.render(g2d);
        for (int i = 0; i < 6; i++)
            pokeBallList[i].render(g2d);
        for(Enemy enemy : enemyList)
            enemy.render(g2d);
        for(Projectile proj : projList)
            proj.render(g2d);
        for(PowerUps power : powerList){
            power.render(g2d);
        }
        player.render(g2d);
        if (pause.isPaused() == true){
            pause.render(g2d);
        }
    }
    
    
    @Override
    public void keyDown(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.keyPressed(e);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            collision.checkPlayerPokeBallCollision();
        }
    }
    
    @Override
    public void keyUp(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.keyReleased(e);
        }
        if (pause.isPaused()){
            pause.keyPressed(e);
        }
        else if (!pause.isPaused()){
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            pause.pauseGame();
            }
        }
    }
    
    public void addProjectile(double x, double y, double velY, String projName, String projType){
        projList.add(new Projectile(x, y, velY, projName ,this, projType));
    }
    
    public Player getPlayer(){
        return player;
    }
    
}
