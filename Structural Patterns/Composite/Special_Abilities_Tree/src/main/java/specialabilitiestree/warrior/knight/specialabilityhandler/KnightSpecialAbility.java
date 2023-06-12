package specialabilitiestree.warrior.knight.specialabilityhandler;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.SpecialAbility;
import specialabilitiestree.specialability.adapter.BerserkAdapter;
import specialabilitiestree.specialability.adapter.CycloneAdapter;
import specialabilitiestree.specialability.adapter.VerticalStrikeAdapter;

public enum KnightSpecialAbility implements SpecialAbility {

    VERTICAL_STRIKE(new VerticalStrikeAdapter()),
    BERSERK(new BerserkAdapter()),
    CYCLONE(new CycloneAdapter());

    private final ISpecialAbilityAdapter adapter;

    KnightSpecialAbility(ISpecialAbilityAdapter adapter) {
        this.adapter = adapter;
    }

    public ISpecialAbilityAdapter getAdapter() {
        return adapter;
    }
}


