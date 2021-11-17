package specialabilitiestree.warrior.knight.specialabilityhandler;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.common.ISpecialAbilityAdapterFactory;
import specialabilitiestree.specialability.adapter.BerserkAdapter;
import specialabilitiestree.specialability.adapter.CycloneAdapter;
import specialabilitiestree.specialability.adapter.VerticalStrikeAdapter;

import java.util.EnumMap;

import static specialabilitiestree.warrior.knight.specialabilityhandler.KnightSpecialAbility.*;


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
