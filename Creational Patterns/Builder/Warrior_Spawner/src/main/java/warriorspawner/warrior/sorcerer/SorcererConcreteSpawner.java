package warriorspawner.warrior.sorcerer;

import warriorspawner.warrior.Warrior;
import warriorspawner.warrior.WarriorAbstractSpawner;
import warriorspawner.warrior.WarriorClass;

public class SorcererConcreteSpawner extends WarriorAbstractSpawner<SorcererConcreteSpawner> {

    public SorcererConcreteSpawner(){
        warrior.setWarriorClass(WarriorClass.SORCERER);
    }

    public SorcererConcreteSpawner withRobe(Robe robe){
        warrior.setClothing(robe);
        return this;
    }

    public SorcererConcreteSpawner withStaff(Staff staff){
        warrior.setWeapon(staff);
        return this;
    }


    @Override
    public Warrior build() {
        return warrior;
    }
}
