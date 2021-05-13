package rooms;

import players.Enemy;

public class Treasure {

    private String type;
    private int value;
    private boolean collected;

    public Treasure(String type, int value, boolean collected){
        this.type = type;
        this.value = value;
        this.collected = false;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }


}
