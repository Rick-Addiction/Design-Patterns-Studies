
# Adapter Pattern - Warrior Special Ability

### Problem

For the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Builder">Builder section</a>, we made a **Warrior Spawner**, which can generate warriors with different hair colors, clothing, weapons, and warrior classes. Now, each warrior possesses a distinct set of special abilities that improves their chances of prevailing in battle.

| Warrior | Special Abilities | Description |
| --- | --- | --- |
| Elf | Possession | Elves temporarily take control of an opponent's mind, forcing them to move or attack as the elf desires. |
| Elf | Concentration | Elves focus and improve precision, which makes it simpler to strike a critical attack on the target. |
| Elf | Agility | Elves start to move faster, which makes it harder for enemies to attack them and helps them avoid being hit. |
| Sorcerer | Telekinesis | Sorcerers can use this ability to control objects and enemies. |
| Sorcerer | Shielding | Sorcerers can resist incoming attacks by casting a magical shield. |
| Sorcerer | Healing | Sorcerers can use this power to restore the health and vitality of themselves or their friends. |
| Knight | Vertical Strike | Knights leap into the air and strike the enemy with a strong downward blow, delivering massive damage. |
| Knight | Berserk | Knights enter a frenzied condition, increasing their attack speed and damage output for a short time. |
| Knight | Cyclone | Knights swirl their swords in a whirlwind manner, striking numerous adversaries at once and delivering minor damage to each of them. |

However, there is a problem in handling these** special abilities**, in particular outlining the abilities and execution of each warrior's unique set of skills. Implementing each special ability becomes **more difficult, time-consuming, and error-prone as the project grows and additional warrior classes are introduced**. Because of this, there's a chance that each skill won't be executed consistently. **Decoupling the implementation** of abilities from the rest of the codebase is therefore essential.

### Solution

An **Adapter Design Pattern** is going to be used to specify how each **warrior's Special Abilities** are carried out, allowing us to **centrally manage and execute them**. The **Factory Design Pattern** will also be used to keep track of which of a **warrior's Special Ability** that each warrior can execute.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Structural Patterns/Adapter/doc/WARRIOR_SPECIAL_ABILITY.png?raw=true" width="100%"></img>

To start, it was defined the **ISpecialAbilityAdapter interface**, which all Special Abilities must implement:

```java
public interface ISpecialAbilityAdapter {
    void useSpecialAbility(Warrior warrior, String...destinations);
}
```

The **ISpecialAbilityAdapter** interface defines the contract that all adapters for Special Abilities must implement. It declares a single method called **useSpecialAbility** that takes a **Warrior** object and an **array of destination strings** as parameters.

The purpose of the useSpecialAbility method is to provide a **common interface** for executing any Special Ability that a warrior may possess. Each Special Ability adapter will **implement this method in its own way**, based on the logic required for that ability.

By having all adapters implement the same interface, it becomes** easy to manage the Special Abilities of different warriors using a common set of methods**. This allows the Warrior class to invoke the **useSpecialAbility** method on any adapter, without knowing which ability it corresponds to or how it's implemented.

Overall, the **ISpecialAbilityAdapter** interface is a key part of the **Adapter** pattern used in this codebase to manage the **Special Abilities of different warriors**.

Then, an **Adapter** was built for each **Special Ability** to serve as the interface's implementation. The following is a sample **Adaptor** for the **Elf's Possession ability**:

```java
public class PossessionAdapter implements ISpecialAbilityAdapter {

    private final Possession possession = new Possession();

    static final Integer FIXED_NUMBER_OF_DESTINATIONS = 1;

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {

        if(destinations.length != FIXED_NUMBER_OF_DESTINATIONS){
            System.out.println(warrior.getName()+" can't execute the Possession special ability because " +
                    "performing this ability must have only one warrior chosen to execute");
            return;
        }

        possession.possesEnemy(warrior.getName(), destinations[0]);
    }
}
```

This code defines the **PossessionAdapter** class that implements the **ISpecialAbilityAdapter** interface. The class provides the implementation for the **useSpecialAbility** method that takes a **Warrior object and a list of destinations as parameters.**

The method first checks if the **number of destinations is exactly one**. If it's not, the method **prints an error message and returns**. Otherwise, it calls the **possesEnemy** method of the **Possession** class, passing the **warrior's name and the destination as parameters**. The **possesEnemy** method takes care of possessing the enemy at the specified destination, which is the opponent to possess for the duration of the ability.

After that, it was created a factory responsible to handle the Special Abilities of each Warrior. Here's an example factory for the Sorcerer's Special Abilities:

```java
public class SorcererSpecialAbilityAdapterFactory implements ISpecialAbilityAdapterFactory<SorcererSpecialAbility> {

    static EnumMap<SorcererSpecialAbility,ISpecialAbilityAdapter> sorcererSpecialAbilities;

    static{
        sorcererSpecialAbilities = new EnumMap<>(SorcererSpecialAbility.class);
        sorcererSpecialAbilities.put(TELEKINESIS,new TelekinesisAdapter());
        sorcererSpecialAbilities.put(SHIELDING,new ShieldingAdapter());
        sorcererSpecialAbilities.put(HEALING,new HealingAdapter());
    }

    @Override
    public ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(SorcererSpecialAbility specialAbilityType) {

        return sorcererSpecialAbilities.get(specialAbilityType);
    }
}
```
The **SorcererSpecialAbility** is an enumeration that defines the types of special abilities that a sorcerer can have: **TELEKINESIS**, **SHIELDING**, and **HEALING**.

The **SorcererSpecialAbilityAdapterFactory** class is responsible for creating adapters for each special ability. It implements the **ISpecialAbilityAdapterFactory** interface, which defines the **getSpecialAbilityAdapterBySpecialAbilityType()** method. This method takes a **SorcererSpecialAbility** parameter, which specifies the **type of special ability to create** an adapter for.

Inside the **SorcererSpecialAbilityAdapterFactory** class, there's a static **EnumMap** named **sorcererSpecialAbilities** that maps each special ability type to its corresponding adapter. The static block initializes this EnumMap by creating new adapters for each special ability type.

The **getSpecialAbilityAdapterBySpecialAbilityType()** method simply retrieves the adapter for the specified special ability type from the **sorcererSpecialAbilities EnumMap** and returns it.

Overall, this implementation allows for **easy creation** of adapters for each type of special ability that a sorcerer can have, **without the need to modify existing code** each time a new special ability is added.


###  Why Adapter Pattern??
The Adapter Pattern is a solution for this problem because:

- **Reusing existing code**: If there is existing code that cannot be changed, but needs to be **integrated with new code with a different interface**, an adapter can bridge the gap. For example, in your code, the **PossessionAdapter** was used to bridge the gap between the Possession class and the **ISpecialAbilityAdapter** interface, and it can be used for other warriors besides Sorcerers.
- **Decoupling**: The Adapter pattern can decouple the client from the implementation details of the adapted class, allowing for **more flexibility in making changes** to either the client or the adapted class without affecting the other. For example, in your code, the **Warrior** class was decoupled from the implementation details of the **SpecialAbility** interface through the use of the **SpecialAbilityAdapter**,.

### How to Use the Code

The Java code consists of the following files:

- **Warrior Class**: A warrior is primarily represented by the **Warrior** class. The name, class, hair color, outfit, weapon, and special ability factory of the warrior are all listed there. Also, the Warrior class provides a method called** useAbility()** that uses the **ISpecialAbilityAdapter** interface and the Special Ability enum as an argument to perform.

- **Warrior Class Builder**: **ElfBuilder**, **SorcererBuilder**, and **KnightBuilder** are the three classes that extend the **WarriorBuilder** abstract class. Each of these classes is in charge of creating a warrior of a specific type and determining their distinctive characteristics, including their hair color, clothing, weapon, and special ability.

- **Special Ability Adapters**: The **ISpecialAbilityAdapter** interface defines the method **useSpecialAbility()** that must be implemented by each of the Special Ability Adapter classes. In the code, there are several adapters, such as **TelekinesisAdapter**, **AgilityAdapter**, and **BerserkAdapter**, which are responsible for executing the **Special Abilities of the warriors**.

- **Special Ability Factories**: The **ISpecialAbilityAdapterFactory** interface defines a method called **getSpecialAbilityAdapterBySpecialAbilityType()**, which returns the **ISpecialAbilityAdapter** corresponding to a given SpecialAbility enum. In the code, there are three factories, **ElfSpecialAbilityAdapterFactory**, **SorcererSpecialAbilityAdapterFactory**, and **KnightSpecialAbilityAdapterFactory**, each responsible for creating the appropriate ISpecialAbilityAdapter for their respective warrior type.

Here is an example of how to use the code:

```java
public static void main(String[] args)
    {
        var sorcerer = new SorcererBuilder()
                .withName("JONAS")
                .withHairColor(HairColor.BRUNETTE)
                .withRobe(Robe.VELVET_RENAISSANCE)
                .withStaff(Staff.INCINERATION).build();

        System.out.println(sorcerer);

        sorcerer.useAbility(SorcererSpecialAbility.TELEKINESIS,"Container");
        sorcerer.useAbility(SorcererSpecialAbility.SHIELDING,"William");
        sorcerer.useAbility(SorcererSpecialAbility.HEALING,"William", "Jeff", "Camilla");

        var knight = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA).build();

        System.out.println(knight);

        knight.useAbility(KnightSpecialAbility.BERSERK);
        knight.useAbility(KnightSpecialAbility.CYCLONE,"Garry", "Thomas");
        knight.useAbility(KnightSpecialAbility.VERTICAL_STRIKE, "Garry", "Thomas");

        var elf = new ElfBuilder()
                .withName("Stephan")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(Garb.HUNTER)
                .withBow(Bow.RAIDER).build();

        System.out.println(elf);

        elf.useAbility(ElfSpecialAbility.AGILITY);
        elf.useAbility(ElfSpecialAbility.CONCENTRATION,"Garry", "Thomas");
        elf.useAbility(ElfSpecialAbility.POSSESSION, "Rick");

    }

```
In this example, it was created instances of the different warrior types (Sorcerer, Knight, and Elf) using their respective builders. Each warrior is given a name, hair color, clothing and weapon.

After each warrior is created, the useAbility() method is called to execute their special abilities. The specific ability to be executed is specified using an enum (SorcererSpecialAbility, KnightSpecialAbility, or ElfSpecialAbility) and the parameters needed by the adapter implementing the ability.

The output of this code is:

    You have spawned a [BRUNETTE SORCERER] warrior called [JONAS] clothing a [VELVET_RENAISSANCE] Robe and holding a [INCINERATION] Staff
    JONAS is levitating the Container
    JONAS has created a force field
    JONAS healed warriors William, Jeff and Camilla
    
    You have spawned a [BLONDE KNIGHT] warrior called [HENRIQUE] clothing a [MERCENARY] Armor and holding a [KATANA] Sword
    HENRIQUE has been activated the Berserk Mode
    HENRIQUE attacked enemies Garry and Thomas with a Cyclone Attack
    HENRIQUE attacked enemies Garry and Thomas with a Vertical Strike Attack
    
    You have spawned a [REDHEAD ELF] warrior called [Stephan] clothing a [HUNTER] Garb and holding a [RAIDER] Bow
    Stephan has been activated the Agility Mode
    Stephan has been activated the Berserk Mode
    Stephan has possessed Rick
    








