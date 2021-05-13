package players;

import behaviours.ICollect;
import rooms.Room;
import rooms.Treasure;
import tools.Creature;
import tools.Spell;
import tools.Weapon;

import java.util.ArrayList;

public class Magician extends Player implements ICollect {
    private int healthPoints;
    private String type;
    private ArrayList<Spell> spells;
    private Spell currentSpell;
    private Creature creature;

    private ArrayList<Treasure> treasures;

    public Magician(String type, int healthPoints, Creature creature) {
        super(healthPoints);
        this.type = type;
        this.spells = new ArrayList<>();
        this.currentSpell = null;
        this.creature = creature;
        this.treasures = new ArrayList<>();

    }

    public void changeSpell(Spell spell) {
        if (spells.contains(spell)) {
            this.currentSpell = spell;
        } else {
            this.currentSpell = this.currentSpell;
        }
    }

    public void useSpell(Enemy enemy){
        currentSpell.attack(enemy);
    }

    public void addSpell(Spell spell){
        spells.add(spell);
    }

    public String getType() {
        return type;
    }

    public Creature getCreature() {
        return creature;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public Spell getCurrentSpell() {
        return currentSpell;
    }

    public void setCurrentSpell(Spell currentSpell) {
        this.currentSpell = currentSpell;
    }

    public void collectTreasure(Room room) {
        if (room.getEnemy().getHealthPoints() == 0){
            this.treasures.add(room.getTreasure());
            room.getTreasure().setCollected(true);
        }

    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }



}