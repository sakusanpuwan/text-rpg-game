package org.example.Characters.Enemies;

import org.example.Characters.Enemy;
import org.example.Items.Dagger;
import org.example.Items.HealthPotion;
import org.example.Items.Item;

public class Orc extends Enemy {

    private static final int attackPower = 8;

    private static final Item lootDrop = new Dagger("Orcnife", "ATTACK",10);

    public Orc(String name) {
        super(name, attackPower, lootDrop);
    }

    @Override
    public void specialAbility(Character target) {

    }

}
