package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Possession;
import warriorspecialability.warrior.Warrior;

public class PossessionAdapter implements ISpecialAbilityAdapter {

    private final Possession possession = new Possession();

    static final Integer FIXED_NUMBER_OF_DESTINATIONS = 1;

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {

        if(destinations.length != FIXED_NUMBER_OF_DESTINATIONS){
            System.out.println(warrior.getName()+" can't execute the Possession special ability because " +
                    "performing this ability must have only one warrior chosen to execute");
            return;
        }

        possession.possesEnemy(warrior.getName(), destinations[0]);
    }
}
