package org.example.Characters;

import org.example.Inventory;
import org.example.Items.Item;

public class Player extends Character {
    private int level;
    private int experiencePoints;
    private Inventory inventory;
    private static int attackPower = 20;

    public Player(String name) {
        super(name, attackPower);
        this.level = 0;
        this.experiencePoints = 0;
        this.inventory = new Inventory();
    }

    @Override
    public void specialAbility(Character target) {
        if (level > 5) {
            //TODO: Scan in input if input == rand no - critical strike target
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean levelUp() {
        if (getExperiencePoints() >= 10) {
            setLevel(getLevel() + 1);
            setExperiencePoints(getExperiencePoints() - 10);
            setAttackPower(getAttackPower() + 5);
            return true;
        }
        return false;
    }

    public void useItem(Item item) {
        item.use(this);
    }

    public void showStats() {
        System.out.println("Name: " + getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Power: " + getAttackPower());
        System.out.println("Experience Points: " + getExperiencePoints());
        System.out.println("Level: " + getLevel());
    }

}
