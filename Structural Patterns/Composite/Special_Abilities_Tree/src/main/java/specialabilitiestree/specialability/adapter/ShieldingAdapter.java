package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.Shielding;
import specialabilitiestree.warrior.Warrior;

public class ShieldingAdapter implements ISpecialAbilityAdapter {

    private final Shielding shielding = new Shielding();

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        shielding.createForceField(warrior.getName());
    }


}
