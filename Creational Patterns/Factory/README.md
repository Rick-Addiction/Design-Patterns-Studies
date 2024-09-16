
# Factory Pattern - Arrow Crafting

### Problem

In a medieval RPG game, **Elfs** are talented archers and their  favourite weapon is a **Bow**, which is great for striking enemies from a distance. Even so, simply possessing a bow is insufficient to vanquish the enemy. The Elf must also have the **appropriate arrows for various fighting circumstances**.

The Elf's arsenal of arrows all have specific attributes and abilities that make them appropriate for a range of combat situations. Specific arrows, for example, can cause **fire or ice damage**, while others have a **high pierce capability** and can penetrate the enemy's protection. Additionally, there are arrows have with a **large radius**, allowing them to be effective against multiple enemies, but others are **best suited for single-target damage**. The different types of arrows available to the Elf are as follows:

| Arrow Type | Damage | Pierce | Radius |
| ------------- | ---------- | ------ | ------------- |
| **Fire Arrow** | 50 | 13% | 25 meters |
| **Ice Arrow** | 10 | 50% | 5 meters |
| **Shock Arrow** | 60 | 1% | 50 meters |

The issue is how to **manage the creation of different sorts of arrows** for the Elves while also **allowing for the addition of new types of arrows without altering the present coding**. Additionally, the system should be modular and extensible in order to allow for changes in gameplay or RPG scenario requirements.

### Solution

We used the **Factory Method Design Pattern** to manage the creation of multiple sorts of arrows and allow the capability to **add new types of arrows without modifying the existing coding**.

Instead of directly creating objects, the Factory Method Design Pattern **delegated the job of object generation to a specific class**. This ensures that the code is extensible enough to support new types of arrows while **remaining compatible with the current codebase**.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Factory/doc/ARROW_CRAFTING.png?raw=true" width="100%"></img>

To start implementing the Factory Pattern, we constructed an** abstract Arrow class** which might serve as the **base class for all arrow types**. Damage, pierce, and radius are **all qualities common** by all arrow kinds in the Arrow class.

```java
public abstract class Arrow {
    ArrowType arrowType;
    Integer damage;
    Integer pierce;
    Integer radius;

    public void shoot() {
        // Code for shooting the arrow
    }
}
```

After that, we constructed concrete classes for each arrow type, such as **FireArrow**, **IceArrow**, and **ShockArrow**. These classes **enhance the Arrow** class by implementing the properties particular to each arrow type. For example, you can see the **FireArrow** implementation:

```java
public class FireArrow extends Arrow {
    public FireArrow() {
        this.damage = 50;
        this.pierce = 13;
        this.radius = 25;
        this.arrowType = ArrowType.FIRE;
    }
}
```
We then constructed an **ArrowCrafter** class, which works as a factory for building the appropriate arrow objects using the method  **craftArrow()**. The **ArrowCrafter** class has a static map **craftableArrows** that **maps each ArrowType** to its corresponding **Arrow** type. This map is populated with all of the Arrow subclasses available in the **arrowcrafting.arrow package** using reflection.

```java
public class ArrowCrafter {
    private static final String TOP_CLASS_NAME =  "arrowcrafting.arrow";

    private static final Map<ArrowType, Class<? extends Arrow>> craftableArrows = new EnumMap<>(ArrowType.class);

    static {
        Set<Class<? extends Arrow>> types = new Reflections(TOP_CLASS_NAME).getSubTypesOf(Arrow.class);

        for (Class<? extends Arrow> type : types) {
            craftableArrows.put(
                    ArrowType.getArrowType(type.getSimpleName().replace("Arrow", "")),
                    type
            );
        }
    }

    public static Arrow craftArrow(ArrowType arrowType) throws Exception {
        return craftableArrows.get(arrowType).getDeclaredConstructor().newInstance();
    }
}

```

###  Why Factory Pattern??
The **Factory Pattern** is used to **encapsulate object creation** and delegate it to specific classes, allowing for flexibility and scalability. The main purpose is to provide a way to create objects without exposing the instantiation logic, enabling the code to remain flexible as new types of objects are added.

In this case, the **Factory Pattern** is ideal for the **Arrow Crafting** problem because:

- **Delegated object creation**: The creation of different arrow types is handled by the **ArrowCrafter** class, which serves as the factory. This centralizes the creation process and ensures that arrow objects are instantiated with consistent properties, reducing complexity and improving code modularity.
  
- **Extensibility**: The pattern allows you to easily add new types of arrows (such as a new **Poison Arrow**) without altering the existing code. By using reflection, the **ArrowCrafter** class dynamically loads new arrow types, making the system highly extensible.

- **Encapsulation of creation logic**: The Factory Pattern hides the details of how specific arrows are created and provides a simple interface for requesting arrows. This means the rest of the code doesn’t need to worry about how to instantiate specific arrow types—just pass the type to the factory and get the correct arrow object.

- **Flexibility and maintainability**: As the gameplay evolves, adding new types of arrows or changing existing ones becomes straightforward. The centralized nature of the **ArrowCrafter** makes it easy to maintain and modify the arrow creation process, ensuring flexibility as the game expands.

In summary, the **Factory Pattern** provides a flexible, modular, and extensible solution for managing the creation of different arrow types in the game. By delegating object creation and encapsulating the logic, it makes the system easy to extend and maintain as new arrow types or properties are introduced.

### How to Use the Code

The Java code consists of the following files:

- **Arrow.java:** An abstract class that serves as the base class for all arrow types. Contains common attributes such as damage, pierce, and radius.
- **ArrowType.java:** An enum that defines the different types of arrows available in the game.
- **FireArrow.java:** A concrete class that extends Arrow and defines the attributes for a fire arrow.
- **IceArrow.java:** A concrete class that extends Arrow and defines the attributes for an ice arrow.
- **ShockArrow.java:** A concrete class that extends Arrow and defines the attributes for a shock arrow.
- **ArrowCrafter.java:** A class that serves as the factory that creates the specific arrow objects. Uses reflection to find all the Arrow subclasses available in the **arrowcrafting.arrow package**.

You should use the **craftArrow** method on the **ArrowCrafter** class to generate new **Arrow** objects. For instance, when calling **craftArrow** method it returns an instance of the **FireArrow** class through the **ArrowType.FIRE argument**, which is responsivle to define the sort of arrow that should be built:

```java
public class Main {
    public static void main(String[] args) throws Exception {
        List<Arrow> arrowsCrafted = new ArrayList<>();

        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.FIRE));
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.ICE));
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.SHOCK));

        arrowsCrafted.forEach(Arrow::shoot);
    }
}
```
When this code is executed, the arrow object becomes an instance of the FireArrow class and may be used to call any of the Arrow class's methods, such as the shoot method.

The program's output shows that each Arrow object was created with the proper characteristics and that the shoot method was called on each object. The end result is as follows:

    You shot your enemy with the FIRE arrow, making damage of 50 points, in a radius of 25 meters, and with 13% capacity of piercing the opponent aimed 
    You shot your enemy with the ICE arrow, making damage of 10 points, in a radius of 5 meters, and with 50% capacity of piercing the opponent aimed 
    You shot your enemy with the SHOCK arrow, making damage of 60 points, in a radius of 50 meters, and with 1% capacity of piercing the opponent aimed 
    








