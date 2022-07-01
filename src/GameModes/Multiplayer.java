package GameModes;

import java.util.ArrayList;
import java.util.Random;

import Utilities.Color;
import Utilities.Player;

public class Multiplayer extends GameMode {
    
    ArrayList<Player> players;
    private final String ELIMINATION_MSG = String.format("%s, você foi eliminado!", currentPlayer.getName());
    private final String UNIQUE_WIN_MESSAGE = String.format("Parabéns, %s, você foi o ganhador único!", currentPlayer.getName());
    private final String MULTIPLE_WIN_MENSSAGE = ("Parabéns, %s, vocês ganharam!");

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
        System.out.println(players.size() == 1 ? UNIQUE_WIN_MESSAGE : String.format(MULTIPLE_WIN_MENSSAGE, buildWinnersList()));
        for(Player player : players){
            player.incrementScore();
        }        
    }

    private Color getRandomColor(){
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    private String buildWinnersList(){
        String s = "";
        for(int i = 0; i < players.size() - 2; i++){
            s+=String.format("%s,", players.get(i).getName());
        }
        s+=String.format("%s e %s", players.get(players.size() - 2).getName(), players.get(players.size() - 1).getName());
        return s;
    }
    
}
