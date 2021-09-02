package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Shielding;

public class ShieldingAdapter implements ISpecialAbilityAdapter {

    private final Shielding shielding = new Shielding();

    @Override
    public void useSpecialAbility() {
        shielding.createForceField();
    }


}
