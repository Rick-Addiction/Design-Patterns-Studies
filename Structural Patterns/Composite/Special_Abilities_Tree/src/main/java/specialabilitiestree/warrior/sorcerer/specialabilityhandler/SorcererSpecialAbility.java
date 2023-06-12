package specialabilitiestree.warrior.sorcerer.specialabilityhandler;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.SpecialAbility;
import specialabilitiestree.specialability.adapter.HealingAdapter;
import specialabilitiestree.specialability.adapter.ShieldingAdapter;
import specialabilitiestree.specialability.adapter.TelekinesisAdapter;

public enum SorcererSpecialAbility implements SpecialAbility {

    TELEKINESIS(new TelekinesisAdapter()),
    SHIELDING(new ShieldingAdapter()),
    HEALING(new HealingAdapter());

    private final ISpecialAbilityAdapter adapter;

    SorcererSpecialAbility(ISpecialAbilityAdapter adapter) {
        this.adapter = adapter;
    }

    public ISpecialAbilityAdapter getAdapter() {
        return adapter;
    }


}
