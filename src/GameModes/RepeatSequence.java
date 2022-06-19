package GameModes;

import java.util.Random;
import Utilities.Color;

public class RepeatSequence extends GameMode {


    public RepeatSequence() {
        super();
    }

    @Override
    public void run() {
        while(sequence.size() <= round){
            update();
            
        }  
    }

    @Override
    public void update() {
        this.round++;
        sequence.add(getRandomColor());  
    }

    private Color getRandomColor(){
        return Color.values()[new Random().nextInt(Color.values().length)];
    }
    
    
}
