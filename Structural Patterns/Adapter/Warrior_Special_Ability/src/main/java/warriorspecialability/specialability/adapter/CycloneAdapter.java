package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Cyclone;
import warriorspecialability.warrior.Warrior;

public class CycloneAdapter implements ISpecialAbilityAdapter {

    private final Cyclone cyclone = new Cyclone();

    static final Integer MINIMUM_NUMBER_OF_DESTINATIONS = 1;

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {

        if(destinations.length < MINIMUM_NUMBER_OF_DESTINATIONS){
            System.out.println(warrior.getName()+" can't execute the Cyclone special ability because " +
                    "performing this ability must have at least one enemy chosen to execute");
            return;
        }

        cyclone.executeCycloneAttack(warrior.getName(), destinations);
    }
}
