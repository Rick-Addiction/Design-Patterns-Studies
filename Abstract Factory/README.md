Based on the imaginary scenario of a fantasy world which have different Blacksmiths available. And each one of them can forge a particular style of types of equipment for the knights who live in this fantasy world. To handle this situation, I used the Abstract Factory Design Pattern to aggregate the different kinds of Blacksmith with the products they can forge. This approach makes more flexible the implementation of the construction of new types of equipment if it is necessary.

As you can see on the diagram, the abstract Blacksmith defines the equipment this kind of place can forge, and different concretes Blacksmiths extend it based on their forge pattern. Therefore, these concrete factories can build all the types of equipment following their specific construction pattern, which in the presented situation are Emperor, Corruption, and Mercenary.

![alt text](https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Abstract Factory/doc/BLACKSMITH_FORGE.png?raw=true)
