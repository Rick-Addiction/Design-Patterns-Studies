package warriorspecialability.warrior.knight;

import warriorspecialability.warrior.Warrior;
import warriorspecialability.warrior.WarriorBuilder;
import warriorspecialability.warrior.WarriorClass;
import warriorspecialability.warrior.knight.specialabilityhandler.KnightSpecialAbility;
import warriorspecialability.warrior.knight.specialabilityhandler.KnightSpecialAbilityAdapterFactory;

public class KnightBuilder extends WarriorBuilder<KnightBuilder, KnightSpecialAbility> {

    public KnightBuilder(){
        warrior.setWarriorClass(WarriorClass.KNIGHT);
    }

    public KnightBuilder withArmor(Armor armor){
        warrior.setClothing(armor);
        return this;
    }

    public KnightBuilder withSword(Sword sword){
        warrior.setWeapon(sword);
        return this;
    }

    @Override
    public Warrior<KnightSpecialAbility> build() {
        warrior.setSpecialAbilityAdapterFactory(new KnightSpecialAbilityAdapterFactory());
        return warrior;
    }
}
