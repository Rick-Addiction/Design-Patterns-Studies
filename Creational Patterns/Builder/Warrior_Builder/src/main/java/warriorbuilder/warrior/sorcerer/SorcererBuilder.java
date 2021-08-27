package warriorbuilder.warrior.sorcerer;

import warriorbuilder.warrior.WarriorBuilder;
import warriorbuilder.warrior.WarriorClass;

public class SorcererBuilder extends WarriorBuilder<SorcererBuilder, Robe, Staff> {

    public SorcererBuilder(){
        warrior.setWarriorClass(WarriorClass.SORCERER);
    }

    public SorcererBuilder withRobe(Robe robe){
        warrior.setClothing(robe);
        return this;
    }

    public SorcererBuilder withStaff(Staff staff){
        warrior.setWeapon(staff);
        return this;
    }
}
