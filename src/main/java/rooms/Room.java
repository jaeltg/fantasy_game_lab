package rooms;

import players.Enemy;

public class Room {
    String name;
    Treasure treasure;
    Enemy enemy;

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

}
