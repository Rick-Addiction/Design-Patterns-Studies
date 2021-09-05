package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Shielding;
import warriorspecialability.warrior.Warrior;

public class ShieldingAdapter implements ISpecialAbilityAdapter {

    private final Shielding shielding = new Shielding();

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        shielding.createForceField(warrior.getName());
    }


}
