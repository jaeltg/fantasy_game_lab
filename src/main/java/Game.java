import players.Player;
import rooms.Room;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Room> rooms;
    private Room currentRoom;
    private boolean completed;


    public Game(){
        this.players = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.currentRoom = null;
        this.completed = false;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void startGame() {
        this.currentRoom = this.rooms.get(0);
    }

    public void goToNextRoom(){
        if (this.currentRoom.roomCompleted() && this.rooms.indexOf(currentRoom) < this.rooms.size() - 1){
            this.currentRoom = this.rooms.get(this.rooms.indexOf(currentRoom) + 1);
        } else {
            this.completed = true;
        }
    }
}

