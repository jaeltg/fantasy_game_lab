import org.junit.Before;
import org.junit.Test;
import players.*;
import tools.Creature;
import tools.Potion;
import tools.Spell;
import tools.Weapon;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Fighter fighter1;
    Magician magician1;
    Cleric cleric1;
    Enemy enemy1;
    Creature creature1;
    Weapon weapon1;
    Weapon weapon2;
    Weapon weapon3;
    Spell spell1;
    Spell spell2;
    Spell spell3;
    Potion potion1;
    Potion potion2;
    Potion potion3;

    @Before
    public void setUp(){
        weapon1 = new Weapon("Sword",10);
        weapon2 = new Weapon("Axe",15);
        weapon3 = new Weapon("Club",5);
        spell1 = new Spell("Fireball",12);
        spell2 = new Spell("Lightening",20);
        spell3 = new Spell("Srike",8);
        potion1 = new Potion("Herbs",4);
        potion2 = new Potion("Potion",7);
        potion3 = new Potion("Unicorn Tears",10);
        fighter1 = new Fighter("Dwarf", 20);
        creature1 = new Creature("Jack", "Dragon", 10);
        magician1 = new Magician("Wizard", 30, creature1);
        cleric1 = new Cleric("Cleric", 40);
        enemy1 = new Enemy("Orc",50);

    }

    @Test
    public void canChangeWeapon(){
        fighter1.addWeapon(weapon1);
        fighter1.addWeapon(weapon2);
        fighter1.addWeapon(weapon3);
        fighter1.setCurrentWeapon(weapon1);
        fighter1.changeWeapon(weapon2);
        assertEquals(weapon2, fighter1.getCurrentWeapon());
        assertEquals(2, fighter1.getWeapons().size());
    }

    @Test
    public void canChangeSpell(){
        magician1.addSpell(spell1);
        magician1.addSpell(spell2);
        magician1.setCurrentSpell(spell1);
        magician1.changeSpell(spell2);
        assertEquals(spell2, magician1.getCurrentSpell());
        assertEquals(2, magician1.getSpells().size());
    }

    @Test
    public void canChangePotion(){
        cleric1.addPotion(potion1);
        cleric1.addPotion(potion2);
        cleric1.addPotion(potion3);
        cleric1.setCurrentPotion(potion1);
        cleric1.changePotion(potion3);
        assertEquals(potion3, cleric1.getCurrentPotion());
        assertEquals(2, cleric1.getPotions().size());
    }

    @Test
    public void playerCanAttack(){
        fighter1.addWeapon(weapon1);
        fighter1.setCurrentWeapon(weapon1);
        fighter1.useWeapon(enemy1);
        assertEquals(40, enemy1.getHealthPoints());
    }

    @Test
    public void clericCanHeal(){
        cleric1.addPotion(potion1);
        cleric1.setCurrentPotion(potion1);
        enemy1.addWeapon(weapon1);
        enemy1.setCurrentWeapon(weapon1);
        enemy1.useWeapon(fighter1);
        cleric1.usePotion(fighter1);
        assertEquals(14, fighter1.getHealthPoints());
    }

    @Test
    public void creatureCanProtectMagician(){
        enemy1.addWeapon(weapon1);
        enemy1.setCurrentWeapon(weapon1);
        enemy1.useWeapon(magician1);
        magician1.getCreature().protect(magician1);
        assertEquals(30, magician1.getHealthPoints());
    }
}
