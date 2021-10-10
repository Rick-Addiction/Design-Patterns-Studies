package equipmentenchantment.warrior.elf;

import equipmentenchantment.equipment.elfequipment.bow.Bow;
import equipmentenchantment.equipment.elfequipment.garb.Garb;
import equipmentenchantment.warrior.Warrior;
import equipmentenchantment.warrior.WarriorBuilder;
import equipmentenchantment.warrior.WarriorClass;

public class ElfBuilder extends WarriorBuilder<ElfBuilder> {

    public ElfBuilder(){
        warrior.setWarriorClass(WarriorClass.ELF);
    }

    public ElfBuilder withGarb(Garb garb){
        warrior.setClothing(garb);
        garb.setWarriorWhoOwnsTheEquipment(warrior);
        return this;
    }

    public ElfBuilder withBow(Bow bow){
        warrior.setWeapon(bow);
        bow.setWarriorWhoOwnsTheEquipment(warrior);
        return this;
    }

    @Override
    public Warrior build() {
        return warrior;
    }
}
