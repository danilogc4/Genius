package Utilities;

public enum Color { 
    GREEN(0, "Verde"), RED(1, "Vermelho"), YELLOW(2, "Amarelo"), BLUE(3, "Azul");

    private int value;
    private String description;

    private Color(int value, String description){
        this.value = value;
        this.description = description;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public String getDescription(){
        return this.description;
    }
};
