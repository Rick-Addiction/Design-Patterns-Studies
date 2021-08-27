In this fictitious scenario, there is an Elf who holds a Bow with him. And so, he can craft different types of arrows according to the situation he must handle. Therefore, to manage this crafting, I used the Factory Method Design Pattern to suit this requisite because this pattern provides a great possibility of extensibility. 

As demonstrated on the diagram below, the abstract product is the Arrow, and there are three different types of implementation of this product. To manage the construction of these concrete products, the Factory class ArrowCraft can create the correct kind of Arrow according to the enum type received.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Factory/doc/ARROW_CRAFTING.png?raw=true" width="100%"></img>