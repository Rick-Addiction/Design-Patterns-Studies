package warriorspecialability.warrior.elf;

import warriorspecialability.warrior.Warrior;
import warriorspecialability.warrior.WarriorBuilder;
import warriorspecialability.warrior.WarriorClass;
import warriorspecialability.warrior.elf.specialabilityhandler.ElfSpecialAbility;
import warriorspecialability.warrior.elf.specialabilityhandler.ElfSpecialAbilityAdapterFactory;

public class ElfBuilder extends WarriorBuilder<ElfBuilder, ElfSpecialAbility> {

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
    public Warrior<ElfSpecialAbility> build() {
        warrior.setSpecialAbilityAdapterFactory(new ElfSpecialAbilityAdapterFactory());
        return warrior;
    }
}
