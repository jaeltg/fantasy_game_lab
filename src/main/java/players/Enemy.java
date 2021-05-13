package players;

import tools.Weapon;

import java.util.ArrayList;

public class Enemy extends Fighter{
    private int healthPoints;
    private String type;
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;

    public Enemy(String type, int healthPoints){
        super(type, healthPoints);
        this.weapons = new ArrayList<>();
        this.currentWeapon = null;
    }



}
