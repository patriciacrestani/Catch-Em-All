package oopgame.screencontrol;

import oopgame.screens.*;
import javax.swing.JFrame;

public class ScreenControl{
    private boolean running;
    private Window window;
    private ScreenTemplate screen;
    private GameState state;
    private JFrame frame;
    /////////Telas///////////
    private MenuScreen menuScreen;
    private MissionSelect missionSelect;
    private LoadingScreen loadingScreen;
    private PokedexScreen pokedexScreen;
    private GameOverScreen gameOverScreen;
    private GameBase gameBase;
    /////////////////////////
    
    public ScreenControl(){
        
        window = new Window();
        frame = window.getFrame();
        running = true;
        createScreens();
        setScreen(menuScreen);
        
    }
    
    private void setScreen(ScreenTemplate screen){  //Mudo a tela do jogo
        this.screen = screen;  //Digo que a tela atual é essa que acabei de receber
        frame.getContentPane().removeAll();  //Removo a outra tela que estava antes na janela
        frame.getContentPane().revalidate();   //É preciso chamar esse método sempre que um objeto é removido da janela, faz parte do Swing
        frame.getContentPane().repaint(); //É preciso chamar esse método logo dps do revalidade
        frame.add(screen);  //Adiciono na janela a tela que recebi
        this.screen.requestFocus();  //Forço o foco pra janela
    }
    
    public ScreenTemplate getScreen(){
        return screen;
    }
    
    public PokedexScreen getPokedexScreen(){
        return pokedexScreen;
    }
    
    public JFrame getFrame(){
        return frame;
    }
    //////create de telas///////
    private void createScreens(){
        menuScreen = new MenuScreen(this);
        pokedexScreen = new PokedexScreen(this);
        missionSelect = new MissionSelect(this);
        gameOverScreen = new GameOverScreen(this);
        
    }
    /////////////////////////////
    
    public void changeGameState(GameState state){
        this.state = state;
        if(state == GameState.MenuScreen){
            getPokedexScreen().getPokedexInfo().addToFileFromPokedex();
            setScreen(menuScreen);
        }
        else if(state == GameState.MissionSelect){
            setScreen(missionSelect);
        }
        else if(state == GameState.Level1){
            gameBase = new Level1(this,"1");
            setScreen(gameBase);
        }
        else if(state == GameState.Level2){
            gameBase = new Level2(this,"2");
            setScreen(gameBase);
        }
        else if(state == GameState.Level3){
            gameBase = new Level3(this,"3");
            setScreen(gameBase);
        }
        else if(state == GameState.Level4){
            gameBase = new Level4(this,"4");
            setScreen(gameBase);
        }
        else if(state == GameState.Level5){
            gameBase = new Level5(this,"5");
            setScreen(gameBase);
        }
        else if(state == GameState.Level6){
            gameBase = new Level6(this,"6");
            setScreen(gameBase);
        }
        else if(state == GameState.Level7){
            gameBase = new Level7(this,"7");
            setScreen(gameBase);
        }
        else if(state == GameState.Level8){
            gameBase = new Level8(this,"8");
            setScreen(gameBase);
        }
        else if(state == GameState.Level9){
            gameBase = new Level9(this,"9");
            setScreen(gameBase);
        }
        else if(state == GameState.Level10){
            gameBase = new LevelBoss(this,"10");
            setScreen(gameBase);
        }
        else if (state == GameState.Loading){
            loadingScreen = new LoadingScreen();
            setScreen(loadingScreen);
        }
        else if (state == GameState.Pokedex){
            setScreen(pokedexScreen);
        }
        else if(state == GameState.GameOver){
            setScreen(gameOverScreen);
        }
        else if (state == GameState.Quit){
            running = false;
        }
        
    }
    
    public boolean isRunning(){
        return running;
    }
}
