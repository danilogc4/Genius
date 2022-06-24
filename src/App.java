import GameModes.RepeatSequence;
import Utilities.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Player player = new Player("Danilo");
        RepeatSequence repeatSequence = new RepeatSequence(player);
        Game game = new Game(repeatSequence, 4);

        game.play();
    }
}
