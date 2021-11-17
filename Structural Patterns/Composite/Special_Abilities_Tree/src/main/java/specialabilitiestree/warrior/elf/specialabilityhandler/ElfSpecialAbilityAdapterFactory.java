package specialabilitiestree.warrior.elf.specialabilityhandler;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.common.ISpecialAbilityAdapterFactory;
import specialabilitiestree.specialability.adapter.AgilityAdapter;
import specialabilitiestree.specialability.adapter.BerserkAdapter;
import specialabilitiestree.specialability.adapter.PossessionAdapter;

import java.util.EnumMap;

import static specialabilitiestree.warrior.elf.specialabilityhandler.ElfSpecialAbility.*;


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
