package players;

import tools.Creature;
import tools.Spell;
import tools.Weapon;

import java.util.ArrayList;

public class Magician extends Player {
    private int healthPoints;
    private String type;
    private ArrayList<Spell> spells;
    private Spell currentSpell;
    private Creature creature;

    public Magician(String type, int healthPoints, Creature creature) {
        super(healthPoints);
        this.type = type;
        this.spells = new ArrayList<>();
        this.currentSpell = null;
        this.creature = creature;
    }

    public void changeSpell(Spell spell) {
        if (spells.contains(spell)) {
            this.currentSpell = spell;
        } else {
            this.currentSpell = this.currentSpell;
        }
    }

    public void addSpell(Spell spell){
        spells.add(spell);
    }

    public String getType() {
        return type;
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


}