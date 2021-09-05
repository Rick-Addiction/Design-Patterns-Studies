Based on the necessity presented in the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Builder">Builder section</a>, besides spawning warriors, the solution needs to manage which Special Abilities each of the warriors can perform and how to execute them.

In order to achieve the expected objective, we are going to use the Adapter Pattern to establish how to execute these special abilities. And the Factory Design Pattern has been applied to manage which Special Abilities each of the warriors can perform.

Therefore, warriors Builder defines which kind of SpecialAbilityAdapterFactory for each of the warriors. Based on the type of Special Ability chosen, these factories can specify the Adapter applied to perform each Special Ability.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Structural Patterns/Adapter/doc/WARRIOR_SPECIAL_ABILITY.png?raw=true" width="100%"></img>

