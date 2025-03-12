package org.example;

import org.example.Characters.Enemies.Goblin;
import org.example.Characters.Enemies.Orc;
import org.example.Characters.Enemy;
import org.example.Characters.Player;
import org.example.Items.HealthPotion;
import org.example.Items.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Location> locations;
    private static final Scanner scanner = new Scanner(System.in);

    public Game(Player player, List<Location> locations) {
        this.player = player;
        this.locations = locations;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public static void main(String[] args) {


        Game game = initGame();



        game.startGame();
    }

    private static Game initGame() {
        System.out.println("Welcome to the Text RPG Game!");

        System.out.println("Enter your player name...");
        String name = scanner.nextLine();

        Player player = new Player(name);

        Location turtleIsland = new Location("Turtle Island","An island of turtles ready to claim you as their saviour", new HealthPotion("Elixir", "HEAL",10));
        Location yggdrasil = new Location("Yggdrasil", "An enormous ash tree that connects the nine worlds", new Goblin("Yesi"));
        Location shambala = new Location("Shambala", "A spiritual realm or state of consciousness surrounded by mountains", new Orc("Tort"));
        ArrayList<Location> locations = new ArrayList<>(List.of(turtleIsland, yggdrasil, shambala));

        System.out.println("Hello, " + player.getName() + "!");
        System.out.println("Your stats:");
        player.showStats();

        return new Game(player, locations);
    }

    public void startGame() {
        while (player.isAlive()) {
            Location location = searchLocations();
            explore(location);
            // TODO: All location explored check, boss fight, level up check, special ability, , critical strike,
        }
    }

    private Location searchLocations() {
        while (true) {
            System.out.println(player.getName() + " you see the following locations...");
            for (int i = 1; i < locations.size() + 1; i++) {
                System.out.println(i + ". " + locations.get(i-1).getName() + " - " + locations.get(i-1).getDescription());
            }
            System.out.println("Where would you like to go?");
            int locationInput = scanner.nextInt();
            scanner.nextLine();
            if (locationInput >= 1 && locationInput <= locations.size()) {
                Location location = locations.get(locationInput - 1);
                System.out.println("You chose " + location.getName());
                locations.remove(locationInput-1);
                return location;
            }
            System.out.println("Invalid location. Please try again...");
        }
    }

    private void explore(Location location){
        if (location.getItem() != null) {
            System.out.println("Found " + location.getItem().getName());
            System.out.println("Press 1 to pick up the item");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                player.getInventory().addItem(location.getItem());
                System.out.println("Item picked up!");
            }
        }
        if (location.getEnemy() != null) {
            System.out.println("Enemy encountered!");
            System.out.println("Press 1 to fight or 2 to flee");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1){
                battle(location.getEnemy());
            }
        }
    }

    private void battle(Enemy enemy) {
        final int ATTACK = 1;
        final int USE_ITEM = 2;

        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("Press " + ATTACK + " to attack or " + USE_ITEM + " to use an item");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == ATTACK) {
                if (attack(enemy)) break;
            } else if (input == USE_ITEM) {
                useItem();
            }
        }
    }

    private boolean attack(Enemy enemy) {
        player.attack(enemy);
        if (!enemy.isAlive()) {
            System.out.println("You defeated the enemy!");
            return true;
        }
        enemy.attack(player);
        if (!player.isAlive()) {
            System.out.println("You were defeated by the enemy!");
            return true;
        }
        System.out.println("Your health: " + player.getHealth());
        System.out.println(enemy.getName() + "'s health: " + enemy.getHealth());
        return false;
    }

    private void useItem() {
        if (player.getInventory().getItems().isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        player.getInventory().showInventory();
        System.out.println("Which item would you like to use?");
        String itemName = scanner.nextLine();
        for (Item item : player.getInventory().getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.use(player);
                player.getInventory().removeItem(item);
                return;
            }
        }
        System.out.println("Invalid Item");
    }

}
