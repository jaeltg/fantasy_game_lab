import org.junit.Before;
import org.junit.Test;
import players.*;
import rooms.Room;
import rooms.Treasure;
import tools.Creature;
import tools.Potion;
import tools.Spell;
import tools.Weapon;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Treasure treasure1;
    Treasure treasure2;
    Treasure treasure3;
    Treasure treasure4;
    Fighter fighter1;
    Magician magician1;
    Cleric cleric1;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
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
    public void SetUp(){
        game = new Game();
        treasure1 = new Treasure("Gold",100);
        treasure2 = new Treasure("Emerald",200);
        treasure3 = new Treasure("Diamond",300);
        treasure4 = new Treasure("Ruby",400);
        enemy1 = new Enemy("Orc",20);
        enemy2 = new Enemy("Troll",40);
        enemy3 = new Enemy("Orc",30);
        enemy4 = new Enemy("Troll",50);
        room1 = new Room("Golden Room",treasure1,enemy1);
        room2 = new Room("Emerald Room",treasure2,enemy2);
        room3 = new Room("Diamond Room",treasure3,enemy3);
        room4 = new Room("Ruby Room",treasure4,enemy4);
        weapon1 = new Weapon("Sword",10);
        weapon2 = new Weapon("Axe",15);
        weapon3 = new Weapon("Club",5);
        spell1 = new Spell("Fireball",12);
        spell2 = new Spell("Lightening",20);
        spell3 = new Spell("Strike",8);
        potion1 = new Potion("Herbs",4);
        potion2 = new Potion("Potion",7);
        potion3 = new Potion("Unicorn Tears",10);
        fighter1 = new Fighter("Dwarf", 20);
        creature1 = new Creature("Jack", "Dragon", 10);
        magician1 = new Magician("Wizard", 30, creature1);
        cleric1 = new Cleric("Cleric", 40);
        game.addPlayer(fighter1);
        game.addPlayer(magician1);
        game.addPlayer(cleric1);
        game.addRoom(room1);
        game.addRoom(room2);
        game.addRoom(room3);
        game.addRoom(room4);
    }

    @Test
    public void canStartGame(){
        game.startGame();
        assertEquals(room1, game.getCurrentRoom());
    }

    @Test
    public void canMoveToNextRoomIfRoomCompleted(){
        game.startGame();
        Fighter fighter = (Fighter) game.getPlayers().get(0);
        fighter.addWeapon(weapon1);
        fighter.setCurrentWeapon(weapon1);
        Enemy enemy = game.getCurrentRoom().getEnemy();
        fighter.useWeapon(enemy);
        fighter.useWeapon(enemy);
        fighter.collectTreasure(game.getCurrentRoom());
        game.goToNextRoom();
        assertEquals(room2, game.getCurrentRoom());
    }

    @Test
    public void cantMoveToNextRoomIfRoomNotCompleted(){
        game.startGame();
        Fighter fighter = (Fighter) game.getPlayers().get(0);
        fighter.addWeapon(weapon1);
        fighter.setCurrentWeapon(weapon1);
        Enemy enemy = game.getCurrentRoom().getEnemy();
        fighter.useWeapon(enemy);
        fighter.collectTreasure(game.getCurrentRoom());
        game.goToNextRoom();
        assertEquals(room1, game.getCurrentRoom());
    }

    @Test
    public void canCompleteGame(){
        Game game1 = new Game();
        game1.addRoom(room1);
        game1.addPlayer(fighter1);
        game1.startGame();
        Fighter fighter = (Fighter) game1.getPlayers().get(0);
        fighter.addWeapon(weapon1);
        fighter.setCurrentWeapon(weapon1);
        Enemy enemy = game1.getCurrentRoom().getEnemy();
        fighter.useWeapon(enemy);
        fighter.useWeapon(enemy);
        fighter.collectTreasure(game1.getCurrentRoom());
        game1.goToNextRoom();
        assertEquals(room1, game1.getCurrentRoom());
        assertEquals(true, game1.isCompleted());
    }
}
