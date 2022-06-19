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

}
