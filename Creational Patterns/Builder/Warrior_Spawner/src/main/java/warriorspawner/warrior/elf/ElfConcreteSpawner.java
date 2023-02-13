package warriorspawner.warrior.elf;

import warriorspawner.warrior.Warrior;
import warriorspawner.warrior.WarriorAbstractSpawner;
import warriorspawner.warrior.WarriorClass;

public class ElfConcreteSpawner extends WarriorAbstractSpawner<ElfConcreteSpawner> {

    public ElfConcreteSpawner(){
        warrior.setWarriorClass(WarriorClass.ELF);
    }

    public ElfConcreteSpawner withGarb(Garb garb){
        warrior.setClothing(garb);
        return this;
    }

    public ElfConcreteSpawner withBow(Bow bow){
        warrior.setWeapon(bow);
        return this;
    }

    @Override
    public Warrior build() {
        return warrior;
    }
}
