package warriorspecialability.warrior.sorcerer.specialabilityhandler;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.common.ISpecialAbilityAdapterFactory;
import warriorspecialability.specialability.adapter.HealingAdapter;
import warriorspecialability.specialability.adapter.ShieldingAdapter;
import warriorspecialability.specialability.adapter.TelekinesisAdapter;

import java.util.EnumMap;

import static warriorspecialability.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility.*;


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
