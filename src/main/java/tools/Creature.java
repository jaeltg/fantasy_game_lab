package tools;

import players.Magician;

public class Creature {
    private String name;
    private String type;
    private int power;

    public Creature(String name, String type, int power){
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public void protect(Magician magician){
        magician.setHealthPoints(magician.getHealthPoints() + this.power);
    }

}
