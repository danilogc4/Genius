package GameModes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Utilities.Color;
import Utilities.Player;

public class Multiplayer extends GameMode {
    
    ArrayList<Player> players;
    private final String ELIMINATION_MSG = String.format("%s, você foi eliminado!", currentPlayer.getName());

    public Multiplayer(Player currentPlayer) {
        super(currentPlayer);
    }

    public Multiplayer(ArrayList<Player> players){
        super(players.get(0));
        this.players = players;
    }



    @Override
    public void run(int difficulty) throws InterruptedException {
        while(sequence.size() < difficulty && players.size() > 1){
            update();
            clearConsole();
            printSequence();
            clearConsole();
            System.out.println(players);
            for(int i = 0; i < sequence.size(); i++){
                currentPlayer = this.players.get(i % this.players.size());
                System.out.println("Vez de " + currentPlayer.getName());
                Color playerChoice = currentPlayer.choose();
                if(sequence.get(i) != playerChoice){
                    defeat();
                    continue;
                }
            }
        }
        win();  
    }

    @Override
    public void update() {        
        this.round++;
        sequence.add(getRandomColor());
    }

    @Override
    protected void defeat() {
        System.out.println(ELIMINATION_MSG);
        players.remove(this.currentPlayer);
    }

    @Override
    protected void win() {
        System.out.println(players);        
    }

    private Color getRandomColor(){
        return Color.values()[new Random().nextInt(Color.values().length)];
    }
    
}
