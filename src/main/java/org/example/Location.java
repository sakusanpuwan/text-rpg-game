package org.example;

import jdk.jfr.Description;
import org.example.Characters.Enemy;
import org.example.Items.Item;

public class Location {
    private String name;
    private Enemy enemy;
    private Item item;
    private String description;

    public Location(String name,String description, Enemy enemy, Item item) {
        this.name = name;
        this.description = description;
        this.enemy = enemy;
        this.item = item;
    }

    public Location(String name, String description, Enemy enemy) {
        this.name = name;
        this.description = description;
        this.enemy = enemy;
    }

    public Location(String name, String description, Item item) {
        this.name = name;
        this.description = description;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
