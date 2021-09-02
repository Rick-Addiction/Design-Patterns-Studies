package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Agility;

public class AgilityAdapter implements ISpecialAbilityAdapter {

    private final Agility agility = new Agility();

    @Override
    public void useSpecialAbility() {
        agility.startAgilityMode();
    }
}
