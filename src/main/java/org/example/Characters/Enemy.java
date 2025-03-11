package org.example.Characters;

import org.example.Items.Item;

public abstract class Enemy extends Character {
    private Item lootDrop;

    public Enemy(String name, int attackPower, Item lootDrop) {
        super(name, attackPower);
        this.lootDrop = lootDrop;
    }

    public Item getLootDrop() {
        return lootDrop;
    }

    public void setLootDrop(Item lootDrop) {
        this.lootDrop = lootDrop;
    }

    @Override
    public void specialAbility(Character target) {

    }

    public abstract void specialAbility(java.lang.Character target);
}
