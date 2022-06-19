package Utilities;

public enum Color { 
    GREEN(0), RED(1), YELLOW(2), BLUE(3);

    private int value;

    private Color(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
};
