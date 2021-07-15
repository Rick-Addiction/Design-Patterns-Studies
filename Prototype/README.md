Based on the same hypothetical situation presented in the [Builder section](https://github.com/Rick-Addiction/Design-Patterns-Studies/tree/master/Builder), at this moment, besides creating spawn warriors, it will be possible to replicate warriors previously established instead of building them from scratch. 

To add this new replication ability, we could use the Prototype Design Pattern on the Builder solution. Therefore, if there is the desire to spawn a warrior with the same settings as a previous one, it is possible with a new method called replicate() on the Warrior class. This method produces a deep copy of the current warrior, avoiding the reflection of the reference with a shallow copy.

![alt text](https://github.com/Rick-Addiction/Design-Patterns-Studies/blob/master/Prototype/doc/WARRIOR_REPLICATION.png?raw=true)
