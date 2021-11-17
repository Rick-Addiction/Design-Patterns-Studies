package specialabilitiestree.warrior.sorcerer.specialabilityhandler;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.common.ISpecialAbilityAdapterFactory;
import specialabilitiestree.specialability.adapter.HealingAdapter;
import specialabilitiestree.specialability.adapter.ShieldingAdapter;
import specialabilitiestree.specialability.adapter.TelekinesisAdapter;

import java.util.EnumMap;

import static specialabilitiestree.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility.*;


public class SorcererSpecialAbilityAdapterFactory implements ISpecialAbilityAdapterFactory<SorcererSpecialAbility> {

    static EnumMap<SorcererSpecialAbility,ISpecialAbilityAdapter> sorcererSpecialAbilities;

    static{
        sorcererSpecialAbilities = new EnumMap<>(SorcererSpecialAbility.class);
        sorcererSpecialAbilities.put(TELEKINESIS,new TelekinesisAdapter());
        sorcererSpecialAbilities.put(SHIELDING,new ShieldingAdapter());
        sorcererSpecialAbilities.put(HEALING,new HealingAdapter());
    }

    @Override
    public ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(SorcererSpecialAbility specialAbilityType) {

        return sorcererSpecialAbilities.get(specialAbilityType);
    }
}
