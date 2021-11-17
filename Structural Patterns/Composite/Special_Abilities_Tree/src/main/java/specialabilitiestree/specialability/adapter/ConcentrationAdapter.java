package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.Concentration;
import specialabilitiestree.warrior.Warrior;

public class ConcentrationAdapter implements ISpecialAbilityAdapter {

    private final Concentration concentration = new Concentration();

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        concentration.startConcentrationMode(warrior.getName());
    }
}
