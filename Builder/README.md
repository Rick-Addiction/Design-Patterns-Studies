In a Warrior Spawner presented in a role-playing game, the warrior options choices should be a step-by-step process handled by the player. So, in order to spawn this new warrior, I used the Builder Design Pattern for this proposal, avoiding the use of what is known as telescoping constructor anti-pattern. 

As you can see on the diagram below, I used an AbstractBuilder with two methods used by the three kinds of warriors and two generics classes: C (Clothing) and W (Weapon).

Therefore, there is the extension of this AbstractBuilder to three different ConcreteBuilders: SorcererBuilder, KnightBuilder, and ElfBuilder. Each one of them extends the AbstractBuilder using their respective kind of Clothing and Weapon, represented by Enums. In the end, all of them are possible to build a final object of the type Warrior, with their respective kind of Clothing and Weapon.

![alt text](https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Builder/WARRIOR_BUILDER.png?raw=true)
