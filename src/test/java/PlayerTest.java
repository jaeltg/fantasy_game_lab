import org.junit.Before;
import org.junit.Test;
import players.*;
import tools.Creature;

public class PlayerTest {

    Fighter fighter1;
    Magician magician1;
    Cleric cleric1;
    Enemy enemy1;
    Creature creature1;

    @Before
    public void setUp(){
        fighter1 = new Fighter("Dwarf", 20);
        creature1 = new Creature("Jack", "Dragon", 10);
        magician1 = new Magician("Wizard", 30, creature1);
        cleric1 = new Cleric("Cleric", 40);
        enemy1 = new Enemy("Orc",50);

    }

    @Test
    public void canChangeWeapon(){

    }
}
