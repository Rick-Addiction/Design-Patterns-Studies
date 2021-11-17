package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.Agility;
import specialabilitiestree.warrior.Warrior;

public class AgilityAdapter implements ISpecialAbilityAdapter {

    private final Agility agility = new Agility();


    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        agility.startAgilityMode(warrior.getName());
    }
}
