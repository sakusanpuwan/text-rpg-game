package org.example.Characters.Enemies;

import org.example.Characters.Enemy;
import org.example.Items.HealthPotion;
import org.example.Items.Item;

public class Goblin extends Enemy {

    private static final int attackPower = 3;

    private static final Item lootDrop = new HealthPotion("Elixir", "HEAL",10);

    public Goblin(String name) {
        super(name, attackPower, lootDrop);
    }

    @Override
    public void specialAbility(Character target) {

    }

}
