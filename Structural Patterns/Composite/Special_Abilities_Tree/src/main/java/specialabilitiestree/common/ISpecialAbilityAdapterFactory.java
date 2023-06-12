package specialabilitiestree.common;

import specialabilitiestree.specialability.SpecialAbility;
import specialabilitiestree.warrior.knight.specialabilityhandler.KnightSpecialAbility;
import specialabilitiestree.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility;

import java.util.ArrayList;
import java.util.List;

public class ISpecialAbilityAdapterFactory<SpecialAbilityType extends SpecialAbility> {

    List<SpecialAbilityType> acquiredSpecialAbilities = new ArrayList<>();

    public void addAcquiredSpecialAbility(SpecialAbilityType specialAbilityType) {
        acquiredSpecialAbilities.add(specialAbilityType);
    }

    public List<SpecialAbilityType> getAcquiredSpecialAbilities() {
        return acquiredSpecialAbilities;
    }


    public ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(SpecialAbilityType specialAbilityToGetAdapter) {
        for (SpecialAbilityType specialAbility : acquiredSpecialAbilities) {
            if (specialAbility == specialAbilityToGetAdapter) {
                return specialAbility.getAdapter();
            }
        }
        return null;
    }


}
