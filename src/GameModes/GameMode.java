package GameModes;

import java.util.ArrayList;

import Utilities.Color;

public abstract class GameMode {
    protected ArrayList<Color> sequence;
    protected int round;

    public GameMode() {
        this.round = 0;
    }

    public abstract void run();
    public abstract void update();
    protected void printSequence() throws InterruptedException{
        for(Color color : sequence){
            System.out.printf(color.getValue() + " - " +color.getDescription());
            Thread.sleep(2000);
            clearConsole();
        }

    }

    private void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
