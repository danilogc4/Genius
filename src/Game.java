import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import GameModes.CreateSequence;
import GameModes.GameMode;
import GameModes.RepeatSequence;
import Utilities.Color;
import Utilities.Player;

public class Game {
    private GameMode gameMode;
    int difficulty;
    Scanner sc;
    private final String START_MESSAGE = "Bem-vindo(a) ao Genius! Selecione abaixo o modo de jogo: ";
    private final String MENU_OPTIONS = "1 - Repita a sequência \n2 - Crie sua própria sequencia\n3 - Repita a sequência 2 a 4 jogadores\nS - Sair";
    private final String REQUEST_NAME_SINGLEPLAYER = "Digite seu nick: ";
    private final String REQUEST_NAME_MULTIPLAYER = "Digite o nick do jogador %s: ";
    private HashMap<String, Player> playerDb;
    


    public Game(GameMode gameMode, int difficulty) {
        sc = new Scanner(System.in);
        System.out.println(START_MESSAGE);
        this.playerDb = new HashMap<String, Player>();

        this.gameMode = gameMode;
        this.difficulty = difficulty;
    }

    public void play() throws InterruptedException{
        gameMode.run(difficulty);
    }

    public void showMenu(){
        System.out.println(MENU_OPTIONS);
        String c = sc.nextLine();
    }

    private void setGameMode(String op){
        switch(op){
            case "1":
                this.gameMode = new RepeatSequence(requestPlayers(1).get(0));
                break;
            case "2":
                this.gameMode = new CreateSequence(requestPlayers(1).get(0));
                break;
        }
    }


    private ArrayList<Player> requestPlayers(int n){
        ArrayList<Player> players = new ArrayList<Player>();
        if(n == 1){
            System.out.print(REQUEST_NAME_SINGLEPLAYER);
            String playerName = sc.nextLine();
            Player player =  new Player(playerName);
            this.playerDb.put(playerName, player);
            players.add(player);

        } else if(n > 1 && n <=4){
            for(int i = 1; i <=n; i++){
                System.out.print(String.format(REQUEST_NAME_MULTIPLAYER, i));
                String playerName = sc.nextLine();
                Player player =  new Player(playerName);
                this.playerDb.put(playerName, player);
                players.add(player);
            }
        }
        return players;
    }

}
