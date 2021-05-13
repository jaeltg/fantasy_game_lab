package rooms;

import players.Enemy;
import players.Player;

import java.util.ArrayList;

public class Room {
    private String name;
    private Treasure treasure;
    private Enemy enemy;
    private ArrayList<Player> team;


    public Room(String name, Treasure treasure, Enemy enemy){
        this.name = name;
        this.treasure = treasure;
        this.enemy = enemy;
    }

    public boolean roomCompleted(){
        if (this.enemy.getHealthPoints() == 0 && this.treasure.isCollected()){
            return true;
        }
        return false;
    }


    public Treasure getTreasure() {
        return treasure;
    }

    public Enemy getEnemy() {
        return enemy;
    }


}
