# Bridge Pattern - Equipments Enchantments

### Problem

We now have a new problem as part of expanding the project developed for the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Builder">Builder Pattern section</a>. We must allow the warriors in the RPG medieval game to **enchant their clothing and weapons**. We must make sure that the **warriors can modify the enchantments tied to their equipment** at any time because these are distinctive to each type of equipment. Here are the types of enchantments available:

| Enchantment Name | Description |
|------------------|----------------|
| Corrupted Mind Enchantment | Corrupts the mind of the target, making it harder to defend against attacks. |
| Fury Enchantment | Induces an uncontrollable rage in the target, making it more likely to attack recklessly. |
| Sigil Enchantment | Empowers the weapon with ancient symbols that grant increased accuracy. |

In order to create this capability, distinct subclasses of each equipment type could be developed to correspond with each enchantment variation. This strategy, on the other hand, would lead to a **complicated inheritance hierarchy** that would be **hard to manage and keep up**.

To accomplish this, we need to** create a system that allows us to attach and detach enchantments from various sorts of equipment**. We must also make sure that we can **turn the enchantments on and off as needed**.

### Solution

By using the **Bridge pattern**, it was possible to solve the problem of having different types of equipment requiring different types of enchantments. As **opposed to using extensive inheritance hierarchies** for each combination of equipment and enchantment, the Bridge pattern recommends **composition** instead.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Structural Patterns/Bridge/doc/EQUIPMENTS_ENCHANTMENTS.png?raw=true" width="100%"></img>

The **central abstraction** in this approach is the **Equipment** class, which serves as the foundation for all other equipment types. So now, both **Clothing** and **Weapon** now extend **Equipment** and **implement its abstract methods** instead of being interfaces as on the Builder project. Besides that, the **Equipment** class includes an instance of the **EnchantmentSet** class, which handles enchantment maintenance. Here you can see the Equipment code:

```java
public abstract class Equipment {

      final EnchantmentSet enchantmentSet;
      Warrior warriorWhoOwnsTheEquipment;
      private static Logger logger = LoggerFactory.getLogger(Equipment.class);

      protected Equipment(Integer socketsQuantity){
            enchantmentSet = new EnchantmentSet(socketsQuantity);
      }

      public void setWarriorWhoOwnsTheEquipment(Warrior warriorWhoOwnsTheEquipment) {
            this.warriorWhoOwnsTheEquipment = warriorWhoOwnsTheEquipment;
      }

      public void activateCurrentEnchantment(){
            // Implementation that tries to get the current enchantment and activate it
      }

      public void deactivateCurrentEnchantment(){
            // Implementation that tries to get the current enchantment and deactivate it
      }

      public void nextEnchantment(){
            // Implementation that tries to change the current enchantment to the next one
      }

      public void previousEnchantment(){
            // Implementation that tries to change the current enchantment to the previous one
      }

      public void removeEnchantment(){
            // Implementation that tries to remove the current enchantment
      }

      public void addEnchantmentToSocket(IEnchantment enchantmentToAdd){
            // Implementation that tries to add the given enchantment to the current socket
      }
}
```

As you can notice, there is a Warrior variable called **warriorWhoOwnsTheEquipment** on the **Equipment** class, and it holds the **Warrior** instance that owns the equipment. By setting this variable, it is possible to identify which **warrior owns a particular piece of equipment**, and when managing the enchantments, it is possible to log messages that **reference the warrior's name** when they interact with the enchantments. You can see an example of **activateCurrentEnchantment()**:

```java
public void activateCurrentEnchantment(){

            Optional<IEnchantment> currentEnchantment = enchantmentSet.getCurrentEnchantment();
            if(currentEnchantment.isPresent()) {
                  String enchantmentActivationResult = enchantmentSet.activateCurrentEnchantment();
                        logger.info("[{}] is activating the current enchantment socket [{}] from the [{}], the [{}]. {}",
                                warriorWhoOwnsTheEquipment.getName(),
                                enchantmentSet.getCurrentEnchantmentSocketPosition(),
                                this,
                                currentEnchantment.get(),
                                enchantmentActivationResult);
            }
            else{
                  logger.error("[{}] tried to activate the current enchantment, but there is no Enchantment in the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
      }
```

When logging the informational message indicating that the current enchantment is being activated, this message includes the** name of the warrior who owns the equipment**. Besides that, it includes the **current enchantment** and its **socket position**, provided by the **EnchantmentSet**, the class responsible for managing the enchantments. 

Because each **enchantment** is a **different composition class** used for the equipment, and each piece of equipment can have **more than one enchantment attached**, the **EnchantmentSet** is used to hold these **different composition objects** and manage their use. Here you can see the **EnchantmentSet** code:

```java
public class EnchantmentSet {

    private List<IEnchantment> enchantmentSockets;
    private final Integer socketsQuantity;
    private int currentEnchantmentSocketIndex = 0;
    private static Logger logger = LoggerFactory.getLogger(EnchantmentSet.class);

    public EnchantmentSet(Integer socketsQuantity){
        this.socketsQuantity =socketsQuantity;
        enchantmentSockets = new LinkedList<>(Arrays.asList(new IEnchantment[socketsQuantity]));
    }

    public String activateCurrentEnchantment(){
        // Implementation that tries to activate the enchantment in the current socket
    }

    public String deactivateCurrentEnchantment(){
        // Implementation that tries to deactivate the enchantment in the current socket
    }

    public Optional<IEnchantment> nextEnchantmentSocket(){
        // Implementation that tries to change the current socket to the next position
    }

    public Optional<IEnchantment> previousEnchantmentSocket(){
        // Implementation that tries to change the current socket to the previous position
    }

    public Optional<IEnchantment> removeEnchantmentFromCurrentSocket(){
        // Implementation that tries to remove the enchantment in the current socket
    }

    public boolean addEnchantmentToCurrentSocket(IEnchantment enchantment){
        // Implementation that tries to add an enchantment in the current socket
    }

    . . .

}

```
As aforementioned, the **EnchantmentSet** object stores the **enchantments** available to attach to equipment, and it is handled an **ArrayList of IEnchantment objects** called **enchantmentSockets** .

The enchantments are attached to **sockets** in the equipment, and in order to manage the socket position, the **EnchantmentSet** has a **currentEnchantmentIndex** variable, which represents the **index of the currently selected enchantment** in the list of **IEnchantment** objects. The number of sockets available is defined by the constructor of the **Clothing** and **Weapon** abstract classes. For example, you can see the **socketsQuantity** parameter being used while constructing a **Clothing**:

```java
public abstract class Clothing extends Equipment{
    public Clothing(Integer socketsQuantity) {
        super(socketsQuantity);
    }
}
```

And the number of sockets is fixed to the classes that extends these **Clothing** and **Weapon** abstract classes. For example, the clothing used by Knight warriors are named as **Armor**:

```java
public abstract class Armor extends Clothing {

    final Integer physicalProtection;
    final Integer fireProtection;
    final Integer iceProtection;
    final Integer shockProtection;

    Armor(Integer socketsQuantity, Integer physicalProtection, Integer fireProtection, Integer iceProtection, Integer shockProtection){
        super(socketsQuantity);
        this.physicalProtection=physicalProtection;
        this.fireProtection=fireProtection;
        this.iceProtection=iceProtection;
        this.shockProtection=shockProtection;
    }
}
```

Besides having **socketsQuantity** parameter, it has other specific attributes defined for armor. Therefore, the **MercenaryArmor**, which extends the **Armor** abstract class, has a fixed quantity of **3 sockets available** to have enchantments attached to it:

```java
public class MercenaryArmor extends Armor {

    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer PHYSICAL_PROTECTION = 40;
    static final Integer FIRE_PROTECTION = 25;
    static final Integer ICE_PROTECTION = 20;
    static final Integer SHOCK_PROTECTION = 27;

    public MercenaryArmor() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, FIRE_PROTECTION, ICE_PROTECTION, SHOCK_PROTECTION);
    }

    @Override
    public String toString() {
        return "Mercenary Armor";
    }
}

```

By this way, according to the equipment, the warrior will be able to attach a **specific and limited amount of enchantments** to its equipment.

Besides that, the **EnchantmentSet** class has methods for **adding** and **removing** enchantments, **activating** and **deactivating** the current enchantment, **switching** between enchantments, and **obtaining** the current enchantment. The **Equipment** class calls these methods to handle interactions between **equipment** and **enchantments**.

By **decoupling the implementation of enchantments from equipments**, the Bridge design pattern **enhances the system's flexibility and adaptability**. With this approach, it is possible to create or remove equipment and enchantment classes **without impacting the existing code**.

###  Why Bridge Pattern??

The Bridge Pattern is a solution for this problem because:

- **Greater flexibility and modularity in equipment and enchantment system**: To facilitate composition of various equipment and enchantments at runtime without requiring a complex inheritance hierarchy, the Bridge design allows the Equipment class to be abstracted away from the implementation of enchantments.

- **Add new equipment or enchantments without modifying existing classes**: The complexity of the codebase can be reduced and maintainability increased by employing the Bridge pattern to add new types of equipment or enchantments without modifying current classes.

- **Change enchantments at runtime without affecting other instances**: The Bridge pattern enables at-runtime attachment of enchantments to equipment instances without impacting other equipment instances. This makes the programming more adaptive and flexible to game changes.

- **Scalable solution for equipment and enchantment system**: Using the Bridge design helps make the equipment and enchantment system more modular, which improves scalability and makes the codebase simpler to maintain.

### How to Use the Code

The Java code consists of the following files:

- **Equipment**: An abstract class that represents the equipment that can be enchanted. This class has an instance of **EnchantmentSet** and provides methods to **add**, **remove**, **activate**, and **deactivate enchantments**.
- **Weapon**: A concrete class that extends **Equipment** and represents a weapon. It provides a method to execute an attack and inherits the methods from **Equipment**.
- **Clothing**: A concrete class that extends Equipment and represents clothing. It inherits the methods from Equipment.
- **Enchantment**: An interface that defines the methods that an enchantment must have. This interface is implemented by different concrete enchantment classes, such as **FireEnchantment** and **IceEnchantment**.
- **EnchantmentSet**: A class that represents the set of enchantments associated with an equipment instance. It stores a list of enchantments that can be **added**, **removed**, and** switched between**.

Here is an example of how to use the code:

```java
public static void main(String[] args)
    {
        var knight = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(new MercenaryArmor())
                .withSword(new EmperorBladeSword())
                .build();

        logger.info("{}", knight);

        knight.handleWeapon().executeAttack();
        knight.handleWeapon().addEnchantmentToSocket(new CorruptedMindEnchantment());
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().deactivateCurrentEnchantment();
        knight.handleWeapon().addEnchantmentToSocket(new FuryEnchantment());
        knight.handleWeapon().removeEnchantment();
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().nextEnchantment();
        knight.handleWeapon().addEnchantmentToSocket(new SigilEnchantment());
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().deactivateCurrentEnchantment();
        knight.handleWeapon().nextEnchantment();
        knight.handleWeapon().previousEnchantment();
        knight.handleWeapon().activateCurrentEnchantment();


        var elf = new ElfBuilder()
                .withName("ELLIE")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(new ExecutionerGarb())
                .withBow(new WingedBow())
                .build();

        logger.info("\n\n{}", elf);

        elf.handleClothing().addEnchantmentToSocket(new SigilEnchantment());
        elf.handleClothing().activateCurrentEnchantment();
        elf.handleClothing().deactivateCurrentEnchantment();
        elf.handleClothing().addEnchantmentToSocket(new FuryEnchantment());
        elf.handleClothing().removeEnchantment();
        elf.handleClothing().nextEnchantment();
        elf.handleClothing().activateCurrentEnchantment();
        elf.handleClothing().deactivateCurrentEnchantment();
        elf.handleClothing().previousEnchantment();
        elf.handleClothing().activateCurrentEnchantment();
    }
```
In this example, first it is created a **Knight** named **"Henrique"** who wears a **Mercenary Armor** and wields an **Emperor Blade Sword**. The program then executes a series of method calls on the Knight object to **demonstrate the use of weapon enchantments.** After the Knight object, an **Elf** object named **"Ellie"** is created who wears an **Executioner Garb** and wields a **Winged Bow**. The program then executes a series of method calls on the **Elf** object to demonstrate the use of clothing enchantments.

The output of this code is:

    You have spawned a [BLONDE KNIGHT] warrior called [HENRIQUE] clothing a [Mercenary Armor] and holding a [Emperor Blade Sword]
    You attacked the enemy with the Emperor Blade Sword
    [HENRIQUE] added the [Corrupted Mind Enchantment] in the current socket [1] on the [Emperor Blade Sword]
    [HENRIQUE] is activating the current enchantment socket [1] from the [Emperor Blade Sword], the [Corrupted Mind Enchantment]. The enchantment Corrupted Mind Enchantment has been activated.
    [HENRIQUE] is deactivating the current enchantment socket [1] from the [Emperor Blade Sword], the [Corrupted Mind Enchantment]. The enchantment Corrupted Mind Enchantment has been deactivated.
    [HENRIQUE] tried to add [Fury Enchantment], but there is already an Enchantment in the current socket [1] on the [Emperor Blade Sword]
    [HENRIQUE] removed the [Corrupted Mind Enchantment] from the current socket [1] on the [Emperor Blade Sword]
    [HENRIQUE] tried to activate the current enchantment, but there is no Enchantment in the current socket [1] on the [Emperor Blade Sword]
    [HENRIQUE] have changed to the next enchantment socket [2] from the [Emperor Blade Sword], which is empty
    [HENRIQUE] added the [Sigil Enchantment] in the current socket [2] on the [Emperor Blade Sword]
    [HENRIQUE] is activating the current enchantment socket [2] from the [Emperor Blade Sword], the [Sigil Enchantment]. The enchantment Sigil Enchantment has been activated.
    [HENRIQUE] is activating the current enchantment socket [2] from the [Emperor Blade Sword], the [Sigil Enchantment]. The Enchantment is already activated
    [HENRIQUE] is deactivating the current enchantment socket [2] from the [Emperor Blade Sword], the [Sigil Enchantment]. The enchantment Sigil Enchantment has been deactivated.
    [HENRIQUE] have changed to the next enchantment socket [3] from the [Emperor Blade Sword], which is empty
    [HENRIQUE] have changed to the previous enchantment socket [2] from the [Emperor Blade Sword], the [Sigil Enchantment]
    [HENRIQUE] is activating the current enchantment socket [2] from the [Emperor Blade Sword], the [Sigil Enchantment]. The enchantment Sigil Enchantment has been activated.
    
    
    You have spawned a [REDHEAD ELF] warrior called [ELLIE] clothing a [Executioner Garb] and holding a [Winged Bow]
    [ELLIE] added the [Sigil Enchantment] in the current socket [1] on the [Executioner Garb]
    [ELLIE] is activating the current enchantment socket [1] from the [Executioner Garb], the [Sigil Enchantment]. The enchantment Sigil Enchantment has been activated.
    [ELLIE] is deactivating the current enchantment socket [1] from the [Executioner Garb], the [Sigil Enchantment]. The enchantment Sigil Enchantment has been deactivated.
    [ELLIE] tried to add [Fury Enchantment], but there is already an Enchantment in the current socket [1] on the [Executioner Garb]
    [ELLIE] removed the [Sigil Enchantment] from the current socket [1] on the [Executioner Garb]
    [ELLIE] have changed to the next enchantment socket [1] from the [Executioner Garb], which is empty
    [ELLIE] tried to activate the current enchantment, but there is no Enchantment in the current socket [1] on the [Executioner Garb]
    [ELLIE] tried to activate the current enchantment, but there is no Enchantment in the current socket [1] on the [Executioner Garb]
    [ELLIE] have changed to the previous enchantment socket [1] from the [Executioner Garb], which is empty
    [ELLIE] tried to activate the current enchantment, but there is no Enchantment in the current socket [1] on the [Executioner Garb]
    

