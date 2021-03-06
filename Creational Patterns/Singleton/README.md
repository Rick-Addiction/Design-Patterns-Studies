The scenario presented at the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Factory">Factory Design section</a> could have a Materials Management System because each Arrow needs specific materials to craft. Thus we should register how many materials we have and record how affordable each material is.

Therefore, to develop this new Materials Management System, we could use the Singleton Pattern in these specific needs aforementioned because we should have a global access point and guarantee a single instance for these two new objects.

The class used to register how many materials are necessary to craft each Arrow has this register filled by a text file. And the one which records how many materials we have has methods that manipulate how many materials we have available. As the Singleton pattern dictates, each one of these new classes has a Private Constant Instance that can be obtained by a specific static method.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Creational Patterns/Singleton/doc/CRAFTING_MATERIALS.png?raw=true" width="100%"></img>

