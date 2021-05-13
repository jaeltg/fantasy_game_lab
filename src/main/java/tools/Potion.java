package tools;

import behaviours.IHeal;
import players.Player;

public class Potion implements IHeal {
    private String type;
    private int power;

    public Potion(String type, int power){
        this.type = type;
        this.power = power;
    }


    public void heal(Player player) {
        player.setHealthPoints(player.getHealthPoints() + this.power);
    }
}
