
# Builder Pattern - Warrior Spawner

### Problem

As part of the development of a medieval-themed game, you are responsible with developing a **Warrior Spawner** that can generate warriors with **various classes, clothes, weapons, hair colours, and names**. Depending on their class, the warrior will be able to wear and equip distinctive kinds of clothing and weapons. The Warrior Spawner must be **adaptable and adjustable**, enabling the player to **generate warriors with varying attributes based on their choices**.

The Warrior Spawner needs to support the following warrior classes:

- #### Elf:
	- **Clothing**: Elves wear GARBS such as EXECUTIONER, HUNTER, or FOREIGNER.
	- **Weapon**: Elves use BOWS such as AGGRESSIVE, WINGED, or RAIDER.

- #### Sorcerer:
	- **Clothing**: Sorcerers wear ROBES such as MONK, DARK MYSTIC, or VELVET RENAISSANCE.
	- **Weapon**: Sorcerers use STAFFS such as INCINERATION, MAGNUS, or CORRUPTION.

- #### Knight:
	- **Clothing**: Knights wear ARMOR such as HUNTER, TEMPLAR, or MERCENARY.
	- **Weapon**: Knights use SWORDS such as MYSTIC BLADE, MERCENARY BLADE, or KATANA.

To spawn warriors, the Warrior Spawner must have the following attributes enabled:

- **Name**: The warrior's name.
- **Hair color**: The warrior's hair colour, which might be brown, blonde, or redhead.
- **Clothing**: The warrior's clothing, which may be class-specific (e.g., garb for elves, armour for knights, and robes for sorcerers).
- **Weapon**: The warrior's weapon, which may be class-specific (e.g., bow for elves, sword for knights, and staff for sorcerers).

The initialization procedure must be adaptable and natural, enabling the attributes to be set in any sequence without the possibility of missing a required initialization step or property.

Furthermore, the system must be expandable, allowing the addition or adjustment of warrior object characteristics without modifying the client code.

Also, the spawned warriors may have various class-specific characteristics, making it difficult to develop a common initialization method. The system must provide a flexible and general method for the construction of warriors with class-specific attributes.

To accomplish these requirements, you'll need a design pattern that can simplify the initialization process, make it more flexible and extensible, and limit the possibility of errors or inconsistencies in the generated warriors.

### Solution

We can use the **Builder Pattern** to solve this problem. The Builder Pattern **separates the construction of a complex object from its representation**, allowing us to create an object step-by-step and return it as a final product. In our case, we can use a concrete builder for each warrior class, such as **ElfConcreteSpawner**, **SorcererConcreteSpawner**, and **KnightConcreteSpawner**, to define the class-specific properties and behaviors. Each concrete builder implements a **WarriorAbstractSpawner** interface, which defines the common properties and methods for all warriors. For example, the **withName()** method is implemented in **WarriorAbstractSpawner**, so the concrete builders don't need to implement it themselves.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Builder/doc/WARRIOR_SPAWNER.png?raw=true" width="100%"></img>

Each concrete builder class needs to **implement the class-specific methods** to set the properties that are unique to that warrior class. For example, the **ElfConcreteSpawner** class needs to implement the **withGarb()** and **withBow()** methods to set the Garb and Bow properties of the elf warriors.

By extending the abstract **WarriorAbstractSpawner** class and implementing their specific **withXXX()** methods to set their class-specific properties, the concrete builders can ensure that the warriors they create have all the required properties set.

Here's an example implementation of the **ElfConcreteSpawner** class:

```java
public class ElfConcreteSpawner extends WarriorAbstractSpawner<ElfConcreteSpawner> {

    public ElfConcreteSpawner() {
        warrior.setWarriorClass(WarriorClass.ELF);
    }

    public ElfConcreteSpawner withGarb(Garb garb) {
        warrior.setClothing(garb);
        return this;
    }

    public ElfConcreteSpawner withBow(Bow bow) {
        warrior.setWeapon(bow);
        return this;
    }

    @Override
    public Warrior build() {
        return warrior;
    }
}

```

In this example, we create a concrete builder class called **ElfConcreteSpawner**, which extends **WarriorAbstractSpawner**. We set the warriorClass property of the warrior to **ELF** in the constructor of the concrete builder class.

We then implement the **withGarb()** and **withBow()** methods to set the **Garb and Bow properties of the elf warriors**, respectively. These methods return **"this"**, which allows us to chain them together when we're creating the elf warriors.

Finally, we implement the **build()** method to return the warrior object, which contains all the properties that we've set in the concrete builder class.

### Why Builder Pattern?
We are using the Builder pattern for the following reasons:

- To provide a flexible and step-by-step approach to create complex objects.
- To separate the construction of an object from its representation and allow creating different representations of an object using the same construction process.
- To create warriors with different classes, clothing, weapons, hair colors, and names in a less error-prone and more natural way.
- To enable adding or modifying properties easily without modifying the client code.

### How to Use the Code

The Java code consists of the following files:

- **Warrior.java**: The product class that represents the warrior object.
- **WarriorAbstractSpawner.java**: The abstract builder class that defines the common initialization methods.
- **ElfConcreteSpawner.java**: The concrete builder class that constructs the **Elf** warrior.
- **KnightConcreteSpawner.java**: The concrete builder class that constructs the **Knight** warrior.
- **SorcererConcreteSpawner.java**: The concrete builder class that constructs the **Sorcerer** warrior.
- **Armor.java**: The enum class that represents the **Knight** clothing options.
- **Sword.java**: The enum class that represents the **Knight** weapon options.
- **Bow.java**: The enum class that represents the **Elf** weapon options.
- **Garb.java**: The enum class that represents the **Elf** clothing options.
- **Robe.java**: The enum class that represents the **Sorcerer** clothing options.
- **Staff.java**: The enum class that represents the **Sorcerer** weapon options.
- **HairColor.java**: The enum class that represents the hair color options.
- **IWeapon.java**: The interface that represents the weapon type.
- **IClothing.java**: The interface that represents the clothing type.

To create a warrior using the Builder pattern, **create a builder object** (ElfBuilder, KnightBuilder, or SorcererBuilder), **set the warrior properties** using the available methods (withName, withHairColor, withClothing, and withWeapon), and finally **call the build method** to get the constructed Warrior object.

```java
// Creating a Knight warrior
KnightBuilder kb = new KnightBuilder()
        .withName("HENRIQUE")
        .withHairColor(HairColor.BLONDE)
        .withArmor(Armor.MERCENARY)
        .withSword(Sword.KATANA);

Warrior knight = kb.build();
System.out.println(knight);

// Creating an Elf warrior
ElfBuilder eb = new ElfBuilder()
        .withName("ELLIE")
.withHairColor(HairColor.REDHEAD)
.withGarb(Garb.EXECUTIONER)
.withBow(Bow.WINGED);

Warrior elf = eb.build();
System.out.println(elf);

// Creating a Sorcerer warrior
SorcererBuilder sb = new SorcererBuilder()
.withName("JONAS")
.withHairColor(HairColor.BRUNETTE)
.withRobe(Robe.VELVET_RENAISSANCE)
.withStaff(Staff.INCINERATION);

Warrior sorcerer = sb.build();
System.out.println(sorcerer);

```

The output of the program will be:

```java
You have spawned a [BLONDE KNIGHT] warrior called [HENRIQUE] clothing a [MERCENARY] Armor and holding a [KATANA] Sword
You have spawned a [REDHEAD ELF] warrior called [ELLIE] clothing a [EXECUTIONER] Garb and holding a [WINGED] Bow
You have spawned a [BRUNETTE SORCERER] warrior called [JONAS] clothing a [VELVET_RENAISSANCE] Robe and holding a [INCINERATION] Staff
```
