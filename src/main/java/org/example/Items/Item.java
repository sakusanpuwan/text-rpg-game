package org.example.Items;

import org.example.Characters.Player;

public abstract class Item {
    private String name;
    private String effect;

    public Item(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public abstract void use(Player player);

}
