package warriorspecialability.warrior.knight.specialabilityhandler;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.common.ISpecialAbilityAdapterFactory;
import warriorspecialability.specialability.adapter.BerserkAdapter;
import warriorspecialability.specialability.adapter.CycloneAdapter;
import warriorspecialability.specialability.adapter.VerticalStrikeAdapter;

import java.util.EnumMap;

import static warriorspecialability.warrior.knight.specialabilityhandler.KnightSpecialAbility.*;


public class KnightSpecialAbilityAdapterFactory implements ISpecialAbilityAdapterFactory<KnightSpecialAbility> {

    static EnumMap<KnightSpecialAbility,ISpecialAbilityAdapter> sorcererSpecialAbilities;

    static{
        sorcererSpecialAbilities = new EnumMap<>(KnightSpecialAbility.class);
        sorcererSpecialAbilities.put(VERTICAL_STRIKE,new VerticalStrikeAdapter());
        sorcererSpecialAbilities.put(BERSERK,new BerserkAdapter());
        sorcererSpecialAbilities.put(CYCLONE,new CycloneAdapter());
    }

    @Override
    public ISpecialAbilityAdapter getSpecialAbilityAdapterBySpecialAbilityType(KnightSpecialAbility specialAbilityType) {

        return sorcererSpecialAbilities.get(specialAbilityType);
    }
}
