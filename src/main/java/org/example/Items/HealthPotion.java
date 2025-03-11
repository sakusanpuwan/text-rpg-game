package org.example.Items;

import org.example.Characters.Player;

public class HealthPotion extends Item {
    private int healAmount;

    public HealthPotion(String name, String effect, int healAmount) {
        super(name, effect);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth() + getHealAmount());
        System.out.println(player.getName() + " used a " + getName() + " and healed for " + healAmount + " health.");
    }

}
