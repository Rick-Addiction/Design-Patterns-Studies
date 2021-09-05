package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Agility;
import warriorspecialability.warrior.Warrior;

public class AgilityAdapter implements ISpecialAbilityAdapter {

    private final Agility agility = new Agility();


    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        agility.startAgilityMode(warrior.getName());
    }
}
