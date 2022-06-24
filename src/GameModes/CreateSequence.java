package GameModes;

import Utilities.Color;
import Utilities.Player;

public class CreateSequence extends GameMode {

    private final String DEFEAT_MESSAGE = String.format("%s, você perdeu!", currentPlayer.getName());
    private final String WIN_MESSAGE = String.format("Parabéns, %s, você ganhou!", currentPlayer.getName());
    private final String ADD_NEW_COLOR_MESSAGE = "Adicione a nova cor";

    public CreateSequence(Player currentPlayer) {
        super(currentPlayer);
    }

    @Override
    public void run(int difficulty) throws InterruptedException {
        while(sequence.size() < difficulty){
            update();
            clearConsole();
            printSequence();
            clearConsole();
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
        System.out.println(ADD_NEW_COLOR_MESSAGE);
        sequence.add(this.currentPlayer.choose());     
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
