package warriorspawner.warrior.knight;

import warriorspawner.warrior.Warrior;
import warriorspawner.warrior.WarriorAbstractSpawner;
import warriorspawner.warrior.WarriorClass;

public class KnightConcreteSpawner extends WarriorAbstractSpawner<KnightConcreteSpawner> {

    public KnightConcreteSpawner(){
        warrior.setWarriorClass(WarriorClass.KNIGHT);
    }

    public KnightConcreteSpawner withArmor(Armor armor){
        warrior.setClothing(armor);
        return this;
    }

    public KnightConcreteSpawner withSword(Sword sword){
        warrior.setWeapon(sword);
        return this;
    }

    @Override
    public Warrior build() {
        return warrior;
    }
}
