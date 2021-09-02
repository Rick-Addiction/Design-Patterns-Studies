package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Concentration;

public class ConcentrationAdapter implements ISpecialAbilityAdapter {

    private final Concentration concentration = new Concentration();

    @Override
    public void useSpecialAbility() {
        concentration.startConcentrationMode();
    }
}
