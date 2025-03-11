package org.example.Items;

import org.example.Characters.Player;
import org.example.Inventory;

import java.util.List;

public class Dagger extends Item {

    private int attackPower = 10;

    public Dagger(String name, String effect, int attackPower) {
        super(name, effect);
        this.attackPower = attackPower;
    }

    @Override
    public void use(Player player) {
        player.setAttackPower(player.getAttackPower() + attackPower);
        System.out.println(player.getName() + " used a " + getName() + " and increased their attack power.");
    }

}
