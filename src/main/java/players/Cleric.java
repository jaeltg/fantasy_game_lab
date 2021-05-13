package players;

import tools.Potion;
import tools.Weapon;

import java.util.ArrayList;

public class Cleric extends Player{
    private int healthPoints;
    private String type;
    private ArrayList<Potion> potions;
    private Potion currentPotion;

    public Cleric(String type, int healthPoints){
        super(healthPoints);
        this.type = type;
        this.potions = new ArrayList<>();
        this.currentPotion = null;
    }

    public void addPotion(Potion potion){
        potions.add(potion);
    }

    public Potion removePotion(Potion potion){
        return this.potions.remove(potions.indexOf(potion));
    }

    public void changePotion(Potion potion){
        if (potions.contains(potion)) {
            this.removePotion(potion);
            this.currentPotion = potion;
            this.addPotion(this.currentPotion);
        } else {
            this.currentPotion = this.currentPotion;
        }
    }

    public String getType() {
        return type;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public Potion getCurrentPotion() {
        return currentPotion;
    }

    public void setCurrentPotion(Potion currentPotion) {
        this.currentPotion = currentPotion;
    }
}
