import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import GameModes.CreateSequence;
import GameModes.GameMode;
import GameModes.Multiplayer;
import GameModes.RepeatSequence;
import Utilities.Player;

public class Game {
    private GameMode gameMode;
    int difficulty;
    Scanner sc;
    private final String START_MESSAGE = "Bem-vindo(a) ao Genius!";
    private final String MENU_OPTIONS = "1 - Repita a sequência \n2 - Crie sua própria sequencia\n3 - Repita a sequência 2 a 4 jogadores\n4 - Mostrar score\nS - Sair";
    private final String REQUEST_NAME_SINGLEPLAYER = "Digite seu nick: ";
    private final String REQUEST_NAME_MULTIPLAYER = "Digite o nick do jogador %s: ";
    private final String REQUEST_NUMBER_PLAYER = "Digite o número de jogadores: ";
    private final String ERROR_MENU_MESSAGE = "Digite uma opção de 1 a 4 ou 's' para sair";
    private final String REQUEST_DIFFICULTY_MESSAGE = "Qual dificuldade?";
    private final String DIFFICULTY_OPTIONS = "A - Fácil\nB - Médio\nC - Difícil\nD - Insano";
    private final String ERROR_DIFFICULTY_MESSAGE = "Digite uma opção de dificuldade válida: ";
    private final String CLOSING_MESSAGE = "Saindo...";
    private final String NUMBER_OF_PLAYERS_ERROR = "Só é possível jogar multiplayer de 2 a 4 jogadores!";

    private final int EASY = 2;
    private final int MEDIUM = 14;
    private final int HARD = 20;
    private final int INSANE = 31;

    private HashMap<String, Player> playerDb;
    


    public Game() {
        sc = new Scanner(System.in);
        System.out.println(START_MESSAGE);
        this.playerDb = new HashMap<String, Player>();
    }

    public void play() throws InterruptedException{
        gameMode.run(difficulty);
    }

    public void showMenu() throws InterruptedException{  
        char c;
        do{
            System.out.println(MENU_OPTIONS);
            c = sc.next().charAt(0); 
            switch(c){
                case '1':
                case '2':
                case '3':
                    setGameMode(c);
                    setDifficulty();
                    this.gameMode.run(difficulty);
                    break;
                case '4':
                    showScore();
                    break;
                case 's':
                case 'S':
                    System.out.println(CLOSING_MESSAGE);
                    break;
                default:
                    System.out.println(ERROR_MENU_MESSAGE);
            }
        } while(c != 's');
    }

    private void setDifficulty() {
        System.out.printf("%s\n%s\n", REQUEST_DIFFICULTY_MESSAGE, DIFFICULTY_OPTIONS);
        char c = sc.next().charAt(0);   
        do{
            switch(c){
                case 'A':
                case 'a':
                    this.difficulty = EASY;
                    break;
                case 'B':
                case 'b':
                    this.difficulty = MEDIUM;
                    break;
                case 'C':
                case 'c':
                    this.difficulty = HARD;
                    break;
                case 'D':
                case 'd':
                    this.difficulty = INSANE;
                    break;
                default:
                    System.out.println(ERROR_DIFFICULTY_MESSAGE);
            }
        } while(c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'A' && c != 'B' && c != 'C' && c != 'D');

    }

    public void showScore(){
        System.out.println(String.format("Nome do jogador - Score\n\n\n%s", this.playerDb));
    }

    private void setGameMode(char op){
        switch(op){
            case '1':
                this.gameMode = new RepeatSequence(requestPlayers(1).get(0));
                break;
            case '2':
                this.gameMode = new CreateSequence(requestPlayers(1).get(0));
                break;
            case '3':
                sc.nextLine();
                int n;
                do {
                    System.out.println(REQUEST_NUMBER_PLAYER);
                    n = sc.nextInt();
                    if(n < 1 || n > 4){
                        System.out.println(NUMBER_OF_PLAYERS_ERROR);
                    }
                } while(n < 1 || n > 4);
                this.gameMode = new Multiplayer(requestPlayers(n));
        }
    }


    private ArrayList<Player> requestPlayers(int n){
        ArrayList<Player> players = new ArrayList<Player>();
        if(n == 1){
            sc.nextLine();
            System.out.print(REQUEST_NAME_SINGLEPLAYER);
            String playerName = sc.nextLine();
            Player player =  new Player(playerName);
            this.playerDb.put(playerName, player);
            players.add(player);

        } else if(n > 1 && n <=4){
            sc.nextLine();
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

    public void updatePlayer(Player player){
        this.playerDb.put(player.getName(), player);
    }

}
