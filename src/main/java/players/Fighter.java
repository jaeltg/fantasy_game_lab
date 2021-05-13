package players;

import tools.Spell;
import tools.Weapon;

import java.util.ArrayList;

public class Fighter extends Player {
    private int healthPoints;
    private String type;
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;

    public Fighter(String type, int healthPoints){
        super(healthPoints);
        this.type = type;
        this.weapons = new ArrayList<>();
        this.currentWeapon = null;
    }

    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
    }

    public Weapon removeWeapon(Weapon weapon){
        return this.weapons.remove(weapons.indexOf(weapon));
    }

    public void changeWeapon(Weapon weapon){
        if (weapons.contains(weapon)) {
            this.removeWeapon(weapon);
            this.currentWeapon = weapon;
            this.addWeapon(this.currentWeapon);
        } else {
            this.currentWeapon = this.currentWeapon;
        }
    }

    public String getType() {
        return type;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }
}
