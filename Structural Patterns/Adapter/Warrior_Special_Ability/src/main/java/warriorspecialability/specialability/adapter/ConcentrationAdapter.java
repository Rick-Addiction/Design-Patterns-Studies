package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Concentration;
import warriorspecialability.warrior.Warrior;

public class ConcentrationAdapter implements ISpecialAbilityAdapter {

    private final Concentration concentration = new Concentration();

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        concentration.startConcentrationMode(warrior.getName());
    }
}
