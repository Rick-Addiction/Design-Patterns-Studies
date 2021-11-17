package specialabilitiestree.warrior.knight;

import specialabilitiestree.warrior.Warrior;
import specialabilitiestree.warrior.WarriorBuilder;
import specialabilitiestree.warrior.WarriorClass;
import specialabilitiestree.warrior.knight.specialabilityhandler.KnightSpecialAbility;
import specialabilitiestree.warrior.knight.specialabilityhandler.KnightSpecialAbilityAdapterFactory;

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
