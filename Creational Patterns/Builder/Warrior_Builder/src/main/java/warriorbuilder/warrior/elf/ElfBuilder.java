package warriorbuilder.warrior.elf;

import warriorbuilder.warrior.Warrior;
import warriorbuilder.warrior.WarriorBuilder;
import warriorbuilder.warrior.WarriorClass;

public class ElfBuilder extends WarriorBuilder<ElfBuilder> {

    public ElfBuilder(){
        warrior.setWarriorClass(WarriorClass.ELF);
    }

    public ElfBuilder withGarb(Garb garb){
        warrior.setClothing(garb);
        return this;
    }

    public ElfBuilder withBow(Bow bow){
        warrior.setWeapon(bow);
        return this;
    }

    @Override
    public Warrior build() {
        return warrior;
    }
}
