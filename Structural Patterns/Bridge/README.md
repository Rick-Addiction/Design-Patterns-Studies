Based on the necessity presented in the <a href="https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Creational Patterns/Builder">Builder section</a>, besides spawning warriors, it is going to be possible to attach different enchantments to weapons and items of clothing used by the warriors.

To develop this new feature can be used Bridge pattern. Being aware that will have different versions of types of equipment. The composition can be used instead of Inheritance, as recommended by the Bridge pattern. 

To have the possibility of changing Enchantments attached to these types of equipment, they can be stored in a list and managed by a separated object, which in this solution is called EnchantmentSet.

Therefore, with Bridge Pattern, there will be different weapons and items of clothing composed of enchantments, which avoid the necessity of an extensive Inheritance among classes.

<img src="https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Structural Patterns/Bridge/doc/EQUIPMENTS_ENCHANTMENTS.png?raw=true" width="100%"></img>

