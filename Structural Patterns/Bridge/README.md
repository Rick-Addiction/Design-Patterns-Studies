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
