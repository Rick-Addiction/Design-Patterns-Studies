package warriorspecialability.warrior.sorcerer;

import warriorspecialability.warrior.Warrior;
import warriorspecialability.warrior.WarriorBuilder;
import warriorspecialability.warrior.WarriorClass;
import warriorspecialability.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility;
import warriorspecialability.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbilityAdapterFactory;

public class SorcererBuilder extends WarriorBuilder<SorcererBuilder, SorcererSpecialAbility> {

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


    @Override
    public Warrior<SorcererSpecialAbility> build() {
        warrior.setSpecialAbilityAdapterFactory(new SorcererSpecialAbilityAdapterFactory());
        return warrior;
    }
}
