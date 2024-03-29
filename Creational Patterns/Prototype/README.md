
# Prototype Pattern - Warrior Replication

### Problem

In the context of a hypothetical medieval RPG game with** different warrior types**, such as **Knight**, **Elf**, and **Sorcerer**, which expands on the solution developed for the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Builder">**Builder pattern section**</a>, each class has their own builder class in this solution, allowing us to create warriors with **specific attributes**.

Creating warriors in an RPG game can be **tedious and time-consuming**, especially if many of them has the **same attributes**. If we start with each warrior from scratch, we must set all of its attributes one by one, what may be **time-consuming, error-prone, and inefficient**, especially if we need to create a large number of warriors with the same attributes. 

Furthermore, in case we want to **change a warrior's attribute**, we would need to manually **update all of its clones**, what would become difficult, especially if we had a large number of similar warriors.

In order to solve this problem, we will need to find a way to **generate new warriors without having to manually set all of their attributes**, one by one. Besides that, we need a way to update a warrior's attribute and have the **change immediately applied to all of its clones**.

### Solution

To solve this problem, we have used the **Prototype Design Pattern**. This pattern is a creational pattern that allows us to **create an object by cloning an existing one** instead of creating it from scratch. It provides a way to create new objects without using the new keyword explicitly.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Prototype/doc/WARRIOR_REPLICATION.png?raw=true" width="100%"></img>

We implemented this pattern by adding a new method to the **Warrior** class called **replicate()**. This method returns a **new object** with the **same attributes** as the existing one. We used deep copying using the **clone()** method to prevent shallow copying. We assure that the new object has a **totally independent copy** of all its attributes, including its references, by using this method.

```java
public Warrior<C,W> replicate(String newWarriorName){
    return new Warrior<C,W>(this, newWarriorName);
}

```

As you can see, the **replicate()** method takes a **new warrior name** as a parameter and returns a **new Warrior object** with the **same clothing and weapon as the current object**.

###  Why Prototype Pattern??
The Prototype Pattern is an ideal solution for this problem because:

- **Reduce the time and effort needed to create new objects:** We avoid the repetitive and time-consuming process of creating new objects with the same attributes from scratch by using the Prototype Design Pattern. Instead, we may save time and effort by cloning an existing object and modifying it as needed.

- **Avoid the disadvantages of shallow copying, such as shared object references:** The Prototype Design Pattern allows us to avoid the problems associated with shallow copying, which creates a new object with the identical attribute values and object references. We create a new object with totally independent copies of all its attributes, including its references, by using deep copying. We may prevent issues with shared object references by ensuring that the new object has its own independent copy of all attributes.

### How to Use the Code

The Java code consists of the following files:

- **Warrior.java**: This class represents a warrior object, containing its name, warrior class, hair color, clothing, and weapon. It also contains the **replicate()** method, which creates a new warrior object.
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

Here is an example of how to use the **replicate()** method:

```java
var newWarrior = new KnightBuilder()
    .withName("HENRIQUE")
    .withHairColor(HairColor.BLONDE)
    .withArmor(Armor.MERCENARY)
    .withSword(Sword.KATANA).build();

var replicatedWarrior = newWarrior.replicate("LEONARD");
System.out.println(newWarrior);
System.out.println(replicatedWarrior);
```
In this example, a new Knight object called **"HENRIQUE"** is created. It has **blonde hair**, **Mercenary armor**, and a **Katana sword**. We next use this object's **replicate()** method, specifying the name **"LEONARD"** as an argument. So, the method returns a new "LEONARD" Knight object with the **same clothing and weapon as the original object**.

The output of this code is:

    You have spawned a BLONDE KNIGHT warrior called HENRIQUE clothing a MERCENARY Armor and holding a KATANA Sword
    You have spawned a BLONDE KNIGHT warrior called LEONARD clothing a MERCENARY Armor and holding a KATANA Sword
    








