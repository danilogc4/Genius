package Utilities;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    

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
    
    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.score);
    }
}
