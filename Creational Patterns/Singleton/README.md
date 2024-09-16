
# Singleton Pattern - Crafting Materials Management

### Problem

In the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Factory">Factory Pattern section</a>, we created an ArrowCrafter class responsible for crafting different types of arrows. And now, as an extesion of the previous project, we will have a Materials Managements System. So, the ArrowCrafter class will require specific crafting materials, such as wood, stone, cloth, and magic essence, to craft each arrow.

| Arrow Type | Wood | Stone | Cloth | Magic Essence |
|------------|------|-------|-------|---------------|
| **Fire Arrow** | 2    | 1     | 1     | 2             |
| **Ice Arrow**  | 1    | 2     | 2     | 1             |
| **Shock Arrow**| 3    | 1     | 0     | 3             |


The Materials Management System needs to keep track of how many materials are available to the player and how many materials are required to craft each type of arrow. One of the most difficult tasks in our Materials Management System is keeping the available crafting materials synced across the entire game. We need to make sure that the available materials are consistent no matter where they are accessed because the crafting materials are used in different game areas.

To address these challenges, we need a solution that can manage the available crafting materials and the materials needed to craft arrow, and ensure that they are always synchronized.

### Solution

The solution for the **Materials Management System** is to use the **Singleton Pattern** to ensure a single instance of the **RequiredMaterials** and **CraftingMaterialsAvailable** classes that manage the materials necessary to craft the arrows.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Singleton/doc/CRAFTING_MATERIALS.png?raw=true" width="100%"></img>

Here is the example code that implements the **Singleton Pattern** for the **RequiredMaterials** class:

```java
public class MaterialsRequiredToCraft {
    private Dictionary<ArrowType, RequiredMaterials> craftableArrows = new Hashtable<>();

    private static final MaterialsRequiredToCraft INSTANCE = new MaterialsRequiredToCraft();

    private MaterialsRequiredToCraft() {
        // Code to read the required materials from a file and populate the craftableArrows dictionary
    }

    public static MaterialsRequiredToCraft getInstance() {
        return INSTANCE;
    }

    public RequiredMaterials getRequiredMaterials(ArrowType arrowType) {
        return craftableArrows.get(arrowType);
    }
}

```
As you can notice, there is a **private static constant variable** called **INSTANCE** that holds the **single instance of the MaterialsRequiredToCraft class**. The constructor of this class is **private**, which means that it is not allowed to call it from outside the class. A class instance can only be obtained by invoking the **getInstance()** method, which returns the **INSTANCE** variable.

Here is the example code that implements the **Singleton Pattern** for the **CraftingMaterialsAvailable** class:

```java
public class CraftingMaterialsAvailable {
    private static final CraftingMaterialsAvailable INSTANCE = new CraftingMaterialsAvailable();

    int wood;
    int magicEssence;
    int stone;
    int cloth;

    private CraftingMaterialsAvailable() {
        // Code to initialize the materials with default values
    }

    public static CraftingMaterialsAvailable getInstance() {
        return INSTANCE;
    }

    // Methods to add and remove materials from the inventory
}

```
Again, the **INSTANCE** variable is a **private static constant** that holds the **single instance of the CraftingMaterialsAvailable** class. The constructor of the class is **private**, and the only way to get an instance of the class is by calling the **getInstance()** method.

When an **arrow** is created, the **ArrowCrafter** class is responsible for** managing the materials required to craft the arrow**. Here is an example code that shows how this works:

```java
public class ArrowCrafter {
    // ...

    public static Arrow craftArrow(ArrowType arrowType) throws Exception {
        var requiredMaterials = MaterialsRequiredToCraft.getInstance().getRequiredMaterials(arrowType);
        var availableMaterials = CraftingMaterialsAvailable.getInstance();

        if(isMaterialsEnough(requiredMaterials, availableMaterials)) {
            System.out.println("A new "+ arrowType.name() + " arrow started to be crafted!");
            useMaterials(requiredMaterials, availableMaterials);
            return craftableArrows.get(arrowType).getDeclaredConstructor().newInstance();
        } else {
            System.out.println("You don't have materials enough to craft a "+ arrowType.name() + " arrow\n");
            return null;
        }
    }

    private static boolean isMaterialsEnough(RequiredMaterials requiredMaterials, CraftingMaterialsAvailable availableMaterials) {
        return availableMaterials.getWood() > requiredMaterials.getWood() &&
                availableMaterials.getCloth() > requiredMaterials.getCloth() &&
                availableMaterials.getMagicEssence() > requiredMaterials.getMagicEssence() &&
                availableMaterials.getStone() > requiredMaterials.getStone();
    }

    private static void useMaterials(RequiredMaterials requiredMaterials, CraftingMaterialsAvailable availableMaterials) {
        if(requiredMaterials.getCloth()> 0) availableMaterials.removeCloth(requiredMaterials.getCloth());
        if(requiredMaterials.getMagicEssence()> 0)availableMaterials.removeMagicEssence(requiredMaterials.getMagicEssence());
        if(requiredMaterials.getStone()> 0)availableMaterials.removeStone(requiredMaterials.getStone());
        if(requiredMaterials.getWood()> 0)availableMaterials.removeWood(requiredMaterials.getWood());
    }
}

```
The **craftArrow()** method receives an **ArrowType**, which determines the type of arrow the player wants to craft. Secondly, the method obtains an **instance of the MaterialsRequiredToCraft**, filtering only the **required materials** for the chosen arrow type, as well as an instance of the **CraftingMaterialsAvailable** class, which stores how many materials of each type the player has. The **isMaterialsEnough()** method is then called to see if the player has enough materials to craft the arrow, and with a positive answer, the **useMaterials()** method is called to **remove the materials** from the **CraftingMaterialsAvailable**.

The **useMaterials()** method simply **subtracts the required materials from the inventory of available materials** by calling the appropriate **remove methods of the CraftingMaterialsAvailable** class.

By managing the materials in this way, we ensure that the player can only craft arrows if they have the necessary materials in their inventory.

###  Why Singleton Pattern??

The **Singleton Pattern** is used to **ensure that a class has only one instance** and to provide a global point of access to that instance. The main purpose of the Singleton Pattern is to manage shared resources across a system, making sure that there is a **single, consistent source of truth**.

In the case of **Crafting Materials Management**, the **Singleton Pattern** is the ideal solution because:

- **Ensures consistency and synchronization**: By using a single instance of the **CraftingMaterialsAvailable** and **MaterialsRequiredToCraft** classes, we guarantee that the **materials data is always up-to-date and consistent** across the entire game, no matter where or when it is accessed.
  
- **Simplifies access to shared resources**: With the **Singleton Pattern**, any part of the game can easily access the same instance of the materials system via the `getInstance()` method. This provides a **global access point** for managing crafting materials without needing to pass references around the game.

- **Prevents duplication**: The Singleton Pattern ensures that **only one instance** of the materials management system exists. This prevents errors that could arise from having multiple instances of the same resource, ensuring that all parts of the game are working with the same data.

- **Saves memory and improves efficiency**: By maintaining a **single instance** of the materials classes, we **save memory** and reduce the overhead of creating multiple objects. This also improves performance, as we avoid unnecessary object creation.

In summary, the **Singleton Pattern** is an excellent choice for **Crafting Materials Management** because it ensures **consistency, global access, and efficient resource management**, making it easier to maintain the integrity of crafting materials across the entire game.


### How to Use the Code

The Java code consists of the following files:

- **Arrow.java:** An abstract class that defines the base attributes of an Arrow. It contains the Arrow Type, Damage, Pierce, and Radius. This class has a shoot method that prints the arrow's attributes when it is shot.
- **ArrowType.java:** An enum class that represents the types of Arrows available in the game. It contains three types: Fire, Ice, and Shock. This class also contains a method to obtain an ArrowType from a String.
- **FireArrow.java, IceArrow.java, ShockArrow.java:** Classes that inherit from the Arrow class and represent each specific Arrow Type. They set the base attributes according to their Arrow Type.
- **ArrowCrafter.java:** This class is responsible for crafting the Arrows. It uses the Singleton Pattern to access the Material Management System, which contains the required materials for each Arrow Type. It also checks if the player has enough materials to craft a specific Arrow Type. If the player has enough materials, it uses the Reflections library to obtain the correct class to instantiate the Arrow Type. Finally, it returns the instantiated Arrow.
- **MaterialsRequiredToCraft.java: **A class that contains a dictionary of ArrowType and RequiredMaterials. This class is responsible for reading the required materials to craft each Arrow Type from a text file.
- **RequiredMaterials.java:** A class that represents the required materials to craft an Arrow Type. It contains the necessary amount of Wood, Magic Essence, Stone, and Cloth.
- **CraftingMaterialsAvailable.java:** A class that contains the available crafting materials. It uses the Singleton Pattern to ensure that there is only one instance of the class, and it has methods to add and remove the crafting materials.

Here is an example of how to use the code:

```java
public class Main {

    public static void main(String[] args) throws Exception {
        List<Arrow> arrowsCrafted = new ArrayList<>();
        var availableMaterials = CraftingMaterialsAvailable.getInstance();

        availableMaterials.showStatus();
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.FIRE));
        availableMaterials.showStatus();
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.ICE));
        availableMaterials.showStatus();
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.SHOCK));
        availableMaterials.showStatus();

    }
}

```
In this example, three arrows are created using the **ArrowCrafter** class by calling the **craftArrow method** with the desired **ArrowType**. If the necessary materials are available, the craftArrow method creates a new instance of the corresponding **Arrow** class and adds it to the **arrowsCrafted list**. Otherwise, if you don't have the necessary material to craft the desired arrow, the message "You don't have materials enough to craft a SHOCK arrow" will appear for example.

Besides that, through the singleton instance of the **CraftingMaterialsAvailable** class, it is displayed the **current status** of the available materials using the **showStatus method**.

The output of this code is:

    ###CRAFTING MATERIALS AVAILABLE###
    Wood: 3
    Stone: 3
    Magic Essence: 3
    Cloth: 3
    
    A new FIRE arrow started to be crafted!
    *** 3 wood has been used ***
    *** 2 cloth has been used ***
    *** 1 magicEssence has been used ***
    A new Fire Arrow has been crafted!
    
    ###CRAFTING MATERIALS AVAILABLE###
    Wood: 0
    Stone: 3
    Magic Essence: 2
    Cloth: 1
    
    A new ICE arrow started to be crafted!
    You don't have materials enough to craft a ICE arrow
    
    ###CRAFTING MATERIALS AVAILABLE###
    Wood: 0
    Stone: 3
    Magic Essence: 2
    Cloth: 1
    
    A new SHOCK arrow started to be crafted!
    You don't have materials enough to craft a SHOCK arrow
    
    ###CRAFTING MATERIALS AVAILABLE###
    Wood: 0
    Stone: 3
    Magic Essence: 2
    Cloth: 1
    
