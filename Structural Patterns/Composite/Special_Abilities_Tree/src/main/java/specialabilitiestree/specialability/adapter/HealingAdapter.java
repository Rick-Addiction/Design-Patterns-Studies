package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.Healing;
import specialabilitiestree.warrior.Warrior;

public class HealingAdapter implements ISpecialAbilityAdapter {

    private final Healing healing = new Healing();

    static final Integer MINIMUM_NUMBER_OF_DESTINATIONS=1;

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        if(destinations.length < MINIMUM_NUMBER_OF_DESTINATIONS){
            System.out.println(warrior.getName()+ " can't execute the Healing special ability because " +
                    "performing this ability must have at least one warrior chosen to execute");
            return;
        }

        healing.healWarrior(warrior.getName(), destinations);
    }
}
