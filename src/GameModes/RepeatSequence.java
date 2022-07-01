package GameModes;

import java.util.Random;
import Utilities.Color;
import Utilities.Player;

public class RepeatSequence extends GameMode {

    private final String DEFEAT_MESSAGE = String.format("%s, você perdeu!", currentPlayer.getName());
    private final String WIN_MESSAGE = String.format("Parabéns, %s, você ganhou!", currentPlayer.getName());
    private final String REQUEST_SEQUENCE_MESSAGE = String.format("Chegou a hora, %s, insira a sequência: ", currentPlayer.getName());



    public RepeatSequence(Player currentPlayer) {
        super(currentPlayer);
    }

    @Override
    public void run(int difficulty) throws InterruptedException {
        while(sequence.size() < difficulty){
            update();
            clearConsole();
            printSequence();
            clearConsole();
            System.out.println(REQUEST_SEQUENCE_MESSAGE);
            for(Color color : sequence){
                Color playerChoice = currentPlayer.choose();
                if(color != playerChoice){
                    defeat();
                    return;
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

    private Color getRandomColor(){
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    @Override
    protected void defeat() {
        System.out.println(DEFEAT_MESSAGE);
    }

    @Override
    protected void win() {
        System.out.println(WIN_MESSAGE);
        currentPlayer.incrementScore();        
    }
    
    
}
