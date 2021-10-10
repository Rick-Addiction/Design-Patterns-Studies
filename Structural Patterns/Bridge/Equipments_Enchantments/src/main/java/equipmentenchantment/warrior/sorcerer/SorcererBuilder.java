package equipmentenchantment.warrior.sorcerer;

import equipmentenchantment.equipment.sorcererequipment.robe.Robe;
import equipmentenchantment.equipment.sorcererequipment.staff.Staff;
import equipmentenchantment.warrior.Warrior;
import equipmentenchantment.warrior.WarriorBuilder;
import equipmentenchantment.warrior.WarriorClass;

public class SorcererBuilder extends WarriorBuilder<SorcererBuilder> {

    public SorcererBuilder(){
        warrior.setWarriorClass(WarriorClass.SORCERER);
    }

    public SorcererBuilder withRobe(Robe robe){
        warrior.setClothing(robe);
        robe.setWarriorWhoOwnsTheEquipment(warrior);
        return this;
    }

    public SorcererBuilder withStaff(Staff staff){
        warrior.setWeapon(staff);
        staff.setWarriorWhoOwnsTheEquipment(warrior);
        return this;
    }


    @Override
    public Warrior build() {
        return warrior;
    }
}
