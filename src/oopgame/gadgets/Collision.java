package oopgame.gadgets;

import java.util.List;
import java.util.Random;
import oopgame.gameobjects.*;
import oopgame.screencontrol.ScreenControl;
import oopgame.screens.GameBase;
import oopgame.screens.GameState;

public class Collision {
    private Random rand;
    private Player player;
    private List<Enemy> enemyList;
    private List<Projectile> projList;
    private PokeBall[] pokeBallList;
    private List<PowerUps> powerList;
    private ScreenControl control;
    private GameBase screen;
    
    
    public Collision(Player player, List<Enemy> enemyList, List<Projectile> projList, PokeBall[] pokeBallList, List<PowerUps> powerList, ScreenControl control, GameBase screen){
        this.player = player;
        this.enemyList = enemyList;
        this.projList = projList;
        this.pokeBallList = pokeBallList;
        this.powerList = powerList;
        this.control = control;
        rand = new Random();
    }
    
    public void checkCollision(){
        for(PokeBall poke : pokeBallList){
            for(Enemy enem : enemyList){
                if(poke.getHitbox().intersects(enem.getHitbox()) && !enem.isFading()){
                    for(Pokemon pok : control.getPokedexScreen().getPokedexInfo().getPokemonList()){
                        if(pok.getName().equals(enem.getImgName())){
                            pok.captured();
                        }
                    }
                    if(rand.nextInt(25) == 0) powerList.add(new PowerUps(enem.getX(), enem.getY(), screen));
                    enem.damage();
                    if(enem.isDead()) enem.startFading();
                    poke.hit();
                }
                if(enem.getAlpha()==0)enemyList.remove(enem);
                if(enem.getY()+ enem.getHeight() > player.getDamageZone() ){
                    enemyList.remove(enem);
                    player.damage();
                    if(player.isDead())
                        control.changeGameState(GameState.GameOver);
                }
                if(enem.getX() < -50 || enem.getX() > 650)
                    enemyList.remove(enem);
            }
        }
        for(Projectile proj: projList){
            if(proj.getHitbox().intersects(player.getHitbox())){
                projList.remove(proj);
                if("sleep".equals(proj.getType())) player.sleep();
                else player.damage();
                if(player.isDead())
                        control.changeGameState(GameState.MenuScreen);
            }
            if(proj.getY() + proj.getHeight() > 600){
                projList.remove(proj);
            }
        }
        
        for(PowerUps power: powerList){
            if(power.getHitbox().intersects(player.getHitbox())){
                player.activatePowerUp(power.getPowerType());
                powerList.remove(power);
            }
            if(power.getTimer().isReady()){
                powerList.remove(power);
            }
            if(power.getY() > 600){
                powerList.remove(power);
            }
        }
    }
    
    
    public void checkPlayerPokeBallCollision(){
        for(PokeBall poke : pokeBallList){
                if(player.getHitbox().intersects(poke.getHitbox())) 
                    poke.startMovement();
        }
    }
}
