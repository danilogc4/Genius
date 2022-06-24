import java.util.ArrayList;

import GameModes.GameMode;
import Utilities.Color;

public class Game {
    private GameMode gameMode;
    int difficulty;

    public Game(GameMode gameMode, int difficulty) {
        this.gameMode = gameMode;
        this.difficulty = difficulty;
    }

    public void play() throws InterruptedException{
        gameMode.run(difficulty);
    }

}
