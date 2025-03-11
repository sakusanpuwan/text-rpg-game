# **Text-Based RPG Adventure – OOP Design & Flow**

## **Game Concept**
The game is a **text-based RPG adventure** where a player explores different locations, battles enemies, and collects items to enhance their abilities. The player’s goal is to defeat the final boss and emerge victorious.

---

# **Class Structure & OOP Design**

The game is structured using **Object-Oriented Programming (OOP) principles**, focusing on **Encapsulation, Inheritance, Abstraction, and Polymorphism**.

## **1. Abstract Base Class: `Character`**
### **Why Abstract?**
- All characters (players and enemies) share common attributes like health and attack power.
- Some behaviors, like `attack()`, will have different implementations for different characters.

### **Fields:**
- `name`: The name of the character.
- `health`: The current health points.
- `attackPower`: The base damage dealt by the character.

### **Methods:**
- `attack(Character target)`: Basic attack method (overridden in subclasses).
- `takeDamage(int damage)`: Reduces health when attacked.
- `isAlive()`: Returns true if health is above zero.
- `specialAbility()`: Abstract method that will be different for each type of character (e.g., a player can use magic, and an enemy can have a unique attack).

---

## **2. `Player` Class (Inherits from `Character`)**
### **Why Inherit?**
- A player is a specialized type of `Character` with additional abilities such as inventory management and leveling up.

### **Fields:**
- `level`: Tracks the player's level.
- `experiencePoints`: Tracks XP for leveling up.
- `inventory`: A list of items the player collects.

### **Methods:**
- `attack(Character target)`: Deals damage based on attack power and level.
- `levelUp()`: Increases player stats when enough XP is gained.
- `useItem(Item item)`: Uses an item from inventory.
- `showStats()`: Displays player stats like health, attack power, and level.
- `specialAbility()`: Could be a strong attack or magic spell.

---

## **3. Abstract `Enemy` Class (Inherits from `Character`)**
### **Why Abstract?**
- Different enemy types (goblins, orcs, dragons) will have unique behaviors and attacks.
- It ensures all enemies must implement a `specialAttack()`.

### **Fields:**
- `type`: The specific type of enemy (Goblin, Orc, etc.).
- `lootDrop`: An item or gold dropped when defeated.

### **Methods:**
- `attack(Character target)`: Each enemy type will implement this differently.
- `specialAttack(Player player)`: A stronger attack unique to each enemy.

---

## **4. Enemy Subclasses (`Goblin`, `Orc`, `Dragon`)**
### **Why Inherit?**
- Each enemy has different health, attack power, and abilities.
- Enemies must define their own `attack()` and `specialAttack()` methods.

### **Goblin (Low-Level Enemy)**
- `attack(Player player)`: Deals a small amount of damage.
- `specialAttack(Player player)`: Throws a rock for bonus damage.

### **Orc (Mid-Level Enemy)**
- `attack(Player player)`: Uses a club to deal moderate damage.
- `specialAttack(Player player)`: Stuns the player for one turn.

### **Dragon (Final Boss)**
- `attack(Player player)`: Breathes fire for high damage.
- `specialAttack(Player player)`: Uses "Inferno Blast" to deal massive damage.

---

## **5. Abstract `Item` Class**
### **Why Abstract?**
- All items share common properties like a name and an effect but have different effects when used.

### **Fields:**
- `name`: The name of the item.
- `effect`: The benefit it provides (healing, stat boost, etc.).

### **Methods:**
- `use(Player player)`: Abstract method to be implemented in subclasses.

---

## **6. Item Subclasses (`HealthPotion`, `WeaponUpgrade`)**
### **Why Inherit?**
- Different items provide different effects.

### **Health Potion (Restores Health)**
- `use(Player player)`: Heals the player when consumed.

### **Weapon Upgrade (Boosts Attack Power)**
- `use(Player player)`: Increases attack power permanently.

---

## **7. `Inventory` Class**
### **Why Separate?**
- The player needs a way to store and manage multiple items.

### **Fields:**
- `items`: A list of collected items.

### **Methods:**
- `addItem(Item item)`: Adds an item to the inventory.
- `removeItem(Item item)`: Removes an item after use.
- `showInventory()`: Displays all stored items.

---

## **8. `Location` Class**
### **Why Separate?**
- The game world consists of multiple locations with different enemies and items.

### **Fields:**
- `name`: Name of the location.
- `enemy`: The enemy that appears in this location (if any).
- `item`: An item that can be found in this location.

### **Methods:**
- `explore(Player player)`:
    - If an enemy exists, the player must fight or flee.
    - If no enemy, the player may find an item.

---

## **9. `Game` Class**
### **Why Separate?**
- It controls the overall game flow and logic.

### **Fields:**
- `player`: The main character controlled by the user.
- `locations`: A list of all available locations.

### **Methods:**
- `startGame()`: Initializes the game and sets up the world.
- `mainLoop()`: Handles user input and game progression.
- `battle(Player player, Enemy enemy)`: Controls combat mechanics.
- `gameOver()`: Ends the game if the player dies.

---

# **Game Flow**

### **1. Game Start**
- The game begins with a story introduction.
- The player chooses a name for their character.

### **2. Exploring Locations**
- The player selects a location to explore.
- They might encounter an enemy, find an item, or face an event.

### **3. Combat**
- If an enemy is encountered, the player can:
    - **Attack** – Uses their basic attack.
    - **Use Special Ability** – A stronger attack (if available).
    - **Use Item** – Heals or boosts stats.
    - **Run Away** – Escape the fight (if possible).
- The enemy will attack back.
- The fight continues until one side is defeated.

### **4. Leveling Up**
- Defeating enemies gives XP.
- When enough XP is gained, the player levels up, increasing health and attack power.

### **5. Final Boss Battle**
- After defeating enough enemies, the player reaches the final boss.
- The boss has a strong `specialAttack()`.
- The player must use strategy (items, abilities) to win.

### **6. Victory or Defeat**
- If the player wins, they complete the adventure.
- If they lose, the game ends with a "Game Over" message.

---

# **Additional Features for Expansion**
- **Shops**: Buy items using gold dropped by enemies.
- **Magic System**: Spells that consume "mana" for special abilities.
- **Quests**: NPCs give missions for extra rewards.
- **Multiple Endings**: Choices impact the final outcome.

---

## **Conclusion**
This **OOP-based RPG** effectively demonstrates **Encapsulation, Inheritance, Abstraction, and Polymorphism**:
- **Encapsulation**: Player stats, enemy stats, and items are well-structured.
- **Inheritance**: Common functionality is shared across different character types.
- **Abstraction**: Abstract base classes enforce essential behavior for all characters.
- **Polymorphism**: Methods like `attack()` and `specialAttack()` behave differently in each class.

This design ensures modularity, making it easy to expand and modify. Would you like further refinements or new gameplay elements? 🚀
