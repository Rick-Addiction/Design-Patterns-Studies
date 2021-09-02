package warriorspecialability.warrior.elf.specialabilityhandler;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.common.ISpecialAbilityAdapterFactory;
import warriorspecialability.specialability.adapter.AgilityAdapter;
import warriorspecialability.specialability.adapter.BerserkAdapter;
import warriorspecialability.specialability.adapter.PossessionAdapter;

import java.util.EnumMap;

import static warriorspecialability.warrior.elf.specialabilityhandler.ElfSpecialAbility.*;


public class ElfSpecialAbilityAdapterFactory implements ISpecialAbilityAdapterFactory<ElfSpecialAbility> {

    static EnumMap<ElfSpecialAbility,ISpecialAbilityAdapter> sorcererSpecialAbilities;

    static{
        sorcererSpecialAbilities = new EnumMap<>(ElfSpecialAbility.class);
        sorcererSpecialAbilities.put(POSSESSION,new PossessionAdapter());
        sorcererSpecialAbilities.put(CONCENTRATION,new BerserkAdapter());
        sorcererSpecialAbilities.put(AGILITY,new AgilityAdapter());
    }

    @Override
    public ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(ElfSpecialAbility specialAbilityType) {

        return sorcererSpecialAbilities.get(specialAbilityType);
    }
}
