package warriorreplication.warrior.elf;

import warriorreplication.warrior.WarriorBuilder;
import warriorreplication.warrior.WarriorClass;

public class ElfBuilder extends WarriorBuilder<ElfBuilder, Garb, Bow> {

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
}
