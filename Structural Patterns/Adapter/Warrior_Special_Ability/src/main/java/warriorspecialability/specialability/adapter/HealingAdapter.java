package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Healing;

public class HealingAdapter implements ISpecialAbilityAdapter {

    private final Healing healing = new Healing();

    @Override
    public void useSpecialAbility() {
        healing.healWarrior();
    }
}
