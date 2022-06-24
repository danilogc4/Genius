package GameModes;

import java.util.ArrayList;

import Utilities.Color;
import Utilities.Player;

public abstract class GameMode {
    protected ArrayList<Color> sequence;
    protected int round;
    protected Player currentPlayer;

    public GameMode(Player currentPlayer) {
        this.round = 0;
        this.currentPlayer = currentPlayer;
        this.sequence = new ArrayList<Color>();
    }

    public abstract void run(int difficulty) throws InterruptedException;
    public abstract void update();
    protected abstract void defeat();
    protected abstract void win();
    protected void printSequence() throws InterruptedException{
        for(Color color : sequence){
            System.out.printf(color.getValue() + " - " +color.getDescription());
            Thread.sleep(2000);
            clearConsole();
        }

    }

    protected void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
