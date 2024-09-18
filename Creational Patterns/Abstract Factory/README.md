
# Abstract Factory Pattern - Blacksmith Forge

### Problem

In a medieval RPG game, players need equip their characters** with different weapons, armor vests, and shields** in order to battle against monsters and other players. To obtain the best equipment, they must locate **qualified Blacksmiths** who can forge them.

There are various types of blacksmiths in the game, each specialised in a specific type of equipment. **Blacksmiths** can forge the following items, according to their type:

- **Corruption Blacksmith:**
	- Corruption Sword;
	- Corruption Armor;
	- Corruption Shield.
- **Emperor Blacksmith:**
	- Emperor Sword;
	- Emperor Armor;
	- Emperor Shield.
- **Mercenary Blacksmith:**
	- Mercenary Sword;
	- Mercenary Armor;
	- Mercenary Shield.

Each type of equipment has specific attributes such as physical protection, fire protection, ice protection, shock protection, attack damage, critical strike chance, chance to block, durability, and weight. Here is a table for the attributes and their values for each type of equipment:

- **Sword Table:**

| Type of Sword | Durability | Weight | Attack Damage | Critical Strike Chance |
| ------------- | ---------- | ------ | ------------- | ---------------------- |
| **Corruption Sword** | 500 | 8 | 90 | 40% |
| **Emperor Sword** | 400 | 7 | 100 | 30% |
| **Mercenary Sword** | 550 | 9 | 80 | 60% |

- **Armor Table:**

| Type of Armor | Durability | Weight | Physical Protection | Fire Protection | Ice Protection | Shock Protection |
| ------------- | ---------- | ------ | ------------------ | --------------- | -------------- | ---------------- |
| **Corruption Armor** | 100 | 43 | 350 | 200 | 100 | 50 |
| **Emperor Armor** | 200 | 33 | 300 | 100 | 5 | 90 |
| **Mercenary Armor** | 100 | 23 | 500 | 50 | 100 | 50 |

- **Shield Table:**

| Type of Shield | Durability | Weight | Chance to Block | Attack Damage | Physical Protection | Fire Protection | Ice Protection | Shock Protection |
| -------------- | ---------- | ------ | --------------- | ------------- | ------------------ | --------------- | -------------- | ---------------- |
| **Corruption Shield** | 100 | 13 | 30% | 150 | 450 | 250 | 150 | 150 |
| **Emperor Shield** | 200 | 10 | 90% | 100 | 400 | 150 | 5 | 190 |
| **Mercenary Shield** | 150 | 17 | 30% | 150 | 550 | 150 | 150 | 150 |

The problem is how to implement the different types of Blacksmiths and equipment in a way that is easy to maintain and extend.  It should be easy to add new types of Blacksmiths and new types of equipment to the game in the future.


### Solution

To tackle the problem, we can use the **Abstract Factory Pattern**. This pattern provides an **interface for creating families of related or dependent objects without specifying their concrete classes**. In this case, we can create an **abstract Blacksmith** interface with methods to forge swords, armors, and shields. We can then create concrete classes such as **CorruptionBlacksmith**, **EmperorBlacksmith**, and **MercenaryBlacksmith** that implement the Blacksmith interface and specialize in forging different types of equipment. 

Each blacksmith has three methods, **forgeSword()**, **forgeArmor()**, and **forgeShield()**, which return a new object representing the respective type of equipment. Each equipment object has a number of attributes specific to its type, such as **physicalProtection** and **fireProtection** for armor, or **attackDamage** and **criticalStrikeChance** for swords.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Abstract Factory/doc/BLACKSMITH_FORGE.png?raw=true" width="100%"></img>

For example, the **CorruptionBlacksmith** class defines **forgeArmor()** to create a new **CorruptionArmor** object with specific values for its attributes, such as **physicalProtection = 350** and **fireProtection = 200**. This ensures that every time the **CorruptionBlacksmith** creates a new piece of armor, the values for those attributes will be the same.

Here is some code that defines different types of forge for the  **CorruptionBlacksmith** :

```java
public class CorruptionBlacksmith implements Blacksmith {

    @Override
    public Sword forgeSword() { 
		return new CorruptionSword();
	}

    @Override
    public Armor forgeArmor() {
        return new CorruptionArmor();
    }

    @Override
    public Shield forgeShield() {
        return new CorruptionShield();
    }
}
```

The **CorruptionBlacksmith** class is a Blacksmith interface implementation. It defines a set of methods for producing new swords, armor, and shield instances. For instance, the **forgeSword()** method produces a new **CorruptionSword** object, a type of **Sword**.

Threfore, this class is part of the Abstract Factory Design pattern, regarding that the **Blacksmith** interface acts as the **Abstract Factory** and each of its implementations, such as **CorruptionBlacksmith**, are **Concrete Factories** used to make objects of a certain type.

### Why Builder Pattern?
The Abstract Factory pattern was chosen for this problem due to the following reasons:

- **Provides a common interface for creating related objects:** The Abstract Factory pattern is ideal when we **need to create families of related objects**. In our problem, the blacksmith **needs to create a sword, armor, and shield,** each of which is related to the others in terms of their purpose and attributes.

- **Encapsulates object creation:** By encapsulating object creation in a separate factory object, we can ensure that the **creation of objects is centralized and consistent**. In our problem, **each Blacksmith has its own factory object** that creates swords, armor, and shields with the same attributes.

- **Enables easy substitution of object families:** By using the Abstract Factory pattern, we can **easily substitute different families of objects** without affecting the rest of the code. In our problem, we can easily swap out the **Emperor**, **Corruption**, or **Mercenary** families of swords, armor, and shields by changing the blacksmith that is used.

- **Promotes consistency:** Because the Abstract Factory pattern centralizes the creation of related objects, it helps ensure that those objects are consistent in terms of their attributes and behavior. In our problem, each blacksmith factory creates objects with a consistent set of attributes, which makes it easier to reason about and use those objects in the rest of the code.

### How to Use the Code

The code consists of three different packages and several classes. The following is an overview of each package and its classes:

- **blacksmithforge.blacksmith**: This package contains the **Blacksmith interface**, which defines the methods for creating swords, armor, and shields. The other classes in this package are the **concrete implementations of the Blacksmith** interface: **CorruptionBlacksmith**, **EmperorBlacksmith**, and **MercenaryBlacksmith**.

- **blacksmithforge.equipment.sword**: This package contains the **Sword** abstract class, which defines the attributes of a sword, such as attack damage and critical strike chance. The other classes in this package are the **concrete implementations of the Sword** class: **CorruptionSword**, **EmperorSword**, and **MercenarySword**.

- **blacksmithforge.equipment.armor**: This package contains the **Armor** abstract class, which defines the attributes of a piece of armor, such as physical protection and fire protection. The other classes in this package are the **concrete implementations of the Armor** class: **CorruptionArmor**, **EmperorArmor**, and **MercenaryArmor**.

- **blacksmithforge.equipment.shield**: This package contains the **Shield** abstract class, which defines the attributes of a shield, such as **chance to block** and **attack damage**. The other classes in this package are the **concrete implementations of the Shield** class: **CorruptionShield**, **EmperorShield**, and **MercenaryShield**.

To use the code, you can create an instance of any of the Blacksmith classes  and call the **forgeSword()**, **forgeArmor()**, and f**orgeShield()** methods on it to create a sword, a piece of armor, and a shield, respectively. Here is an example of how to do that:

```java
Blacksmith corruptionBlacksmith = new CorruptionBlacksmith();
Sword sword = corruptionBlacksmith.forgeSword();
Armor armor = corruptionBlacksmith.forgeArmor();
Shield shield = corruptionBlacksmith.forgeShield();

sword.describeEquipment();
armor.describeEquipment();
shield.describeEquipment();
```
So, we can create an instance of the **CorruptionBlacksmith** class and use it to forge a sword, an armor, and a shield. When calling  the **describeEquipment()** method on each object, it print out their attributes.

When you run the code, you should see an output that looks something like this:

    You have forged a new CorruptionSword
    ###ATTRIBUTES###
    Attack Damage: 90
    Critical Strike Chance: 40%
    Durability: 500
    Weight: 8kg
    
    You have forged a new CorruptionArmor
    ###ATTRIBUTES###
    Physical Protection: 350
    Fire Protection: 200
    Ice Protection: 100
    Shock Protection: 50
    Durability: 100
    Weight: 43kg
    
    You have forged a new CorruptionShield
    ###ATTRIBUTES###
    Physical Protection: 450
    Fire Protection: 250
    Ice Protection: 150
    Shock Protection: 150
    Attack Damage: 150
    Chance to Block: 30%
    Durability: 100
    Weight: 13kg
    
