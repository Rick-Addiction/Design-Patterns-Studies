package specialabilitiestree.warrior.elf;

import specialabilitiestree.warrior.Warrior;
import specialabilitiestree.warrior.WarriorBuilder;
import specialabilitiestree.warrior.WarriorClass;
import specialabilitiestree.warrior.elf.specialabilityhandler.ElfSpecialAbility;
import specialabilitiestree.warrior.elf.specialabilityhandler.ElfSpecialAbilityAdapterFactory;

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
