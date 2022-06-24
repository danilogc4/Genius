package Utilities;
import java.util.Scanner;

public class Player {
    String name;
    int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public Color choose(){
        try (Scanner sc = new Scanner(System.in)) {
            return Color.valueOf(sc.nextLine());
        }
    }

    public String getName() {
        return name;
    }

    public void incrementScore(){
        this.score++;
    }
}
