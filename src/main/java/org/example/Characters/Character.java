package org.example.Characters;

public abstract class Character {
    private String name;
    private int health;
    private int attackPower;

    public Character(String name, int attackPower) {
        this.name = name;
        this.health = 100;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void attack(Character target){
        double multiplier = Math.random();
        target.takeDamage(getAttackPower(), multiplier);
    }

    public void takeDamage(int damage, double multiplier) {
        int damageTaken = (int) (damage * multiplier);
        int currentHealth = getHealth();
        setHealth(currentHealth - damageTaken);
        System.out.println(damageTaken + " damage taken by " + getName() + ".");
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public abstract void specialAbility(Character target);
}
