package oopgame.gadgets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import oopgame.screens.ScreenTemplate;

public class PokedexInfo {
    private final int QUANTITY;
    private List<Pokemon> pokemonList;
    private ScreenTemplate screen;
    
    public PokedexInfo(ScreenTemplate screen){
        pokemonList = new ArrayList<>();
        QUANTITY = 151;
        addToPokedexFromFile();
    }
    
    public void addToPokedexFromFile(){
        try{
            Scanner file = new Scanner(new File("text/test.txt"));
            for(int i = 0; i < QUANTITY; i++){
                pokemonList.add(new Pokemon(i, file.next(), file.nextInt(), screen));
            }
            file.close();     
        }catch(IOException io){
            
        } 
    }
    
    public void addToFileFromPokedex(){
        try{
            PrintWriter writer = new PrintWriter("text/test.txt", "UTF-8");
            for(int i = 0; i < QUANTITY; i++){
                writer.print(pokemonList.get(i).getName() + " ");
                writer.print(pokemonList.get(i).isCaptured());
                writer.println();
            }
            writer.close();
        }catch(IOException e){
            
        }
    }
    
    public int getQuantity(){
        return QUANTITY;
    }
    
    public List<Pokemon> getPokemonList(){
        return pokemonList;
    }
}
