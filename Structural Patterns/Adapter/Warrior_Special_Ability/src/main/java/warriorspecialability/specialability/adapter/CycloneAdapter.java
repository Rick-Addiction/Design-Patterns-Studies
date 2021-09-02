package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Cyclone;

public class CycloneAdapter implements ISpecialAbilityAdapter {

    private final Cyclone cyclone = new Cyclone();

    @Override
    public void useSpecialAbility() {
        cyclone.executeCycloneAttack();
    }
}
