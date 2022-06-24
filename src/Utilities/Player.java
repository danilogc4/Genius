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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return Color.fromInt(n);
    }

    public String getName() {
        return name;
    }

    public void incrementScore(){
        this.score++;
    }
}
