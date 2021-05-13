package tools;

import behaviours.IAttack;
import players.Player;

public class Spell implements IAttack {
    private String type;
    private int power;

    public Spell(String type, int power){
        this.type = type;
        this.power = power;
    }

    public void attack(Player player){
        player.setHealthPoints(player.getHealthPoints() - this.power);
    }

}
