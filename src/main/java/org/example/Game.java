package org.example;

import org.example.Characters.Enemies.Goblin;
import org.example.Characters.Enemies.Orc;
import org.example.Characters.Enemy;
import org.example.Characters.Player;
import org.example.Items.HealthPotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private Location[] locations;

    public Game(Player player, Location[] locations) {
        this.player = player;
        this.locations = locations;
    }

    public Player getPlayer() {
        return player;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Text RPG Game!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your player name...");
        String name = scanner.nextLine();

        Player player = new Player(name);

        Game game = initGame(player);

        System.out.println("Hello, " + player.getName() + "!");
        System.out.println("Your stats:");
        player.showStats();

        game.startGame();
    }

    private static Game initGame(Player player) {
        Location turtleIsland = new Location("Turtle Island","An island of turtles ready to claim you as their saviour", new HealthPotion("Elixir", "HEAL",10));
        Location yggdrasil = new Location("Yggdrasil", "An enormous ash tree that connects the nine worlds", new Goblin("Yesi"));
        Location shambala = new Location("Shambala", "A spiritual realm or state of consciousness surrounded by mountains", new Orc("Tort"));
        Location[] locations = {turtleIsland, yggdrasil, shambala};

        return new Game(player, locations);
    }

    public void startGame() {


    }

    private Location searchLocations() {
        while (true) {
            System.out.println(player.getName() + " you see the following locations...");
            for (Location location : getLocations()) {
                System.out.println(location.getName() + " - " + location.getDescription());
            }
            System.out.println("Where would you like to go? ");
            Scanner scanner = new Scanner(System.in);
            String locationInput = scanner.nextLine();
            for (Location location : getLocations()) {
                if (location.getName().equalsIgnoreCase(locationInput)) {
                    return location;
                }
            }
            System.out.println("Invalid location. Please try again...");
        }
    }

    private void explore(Location location){
        if (location.getEnemy() != null) {
            System.out.println("Enemy encountered!");
            System.out.println("Are you going to fight or flee?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //TODO: Integrate battle or flee
        }
    }

    private void battle(Enemy enemy) {
        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("Press 1 to attack or 2 to use an item");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("1")) {
                player.attack(enemy);
                //TODO: Finish battle logic
            }
        }
    }

}
