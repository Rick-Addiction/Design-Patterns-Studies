package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.Telekinesis;
import specialabilitiestree.warrior.Warrior;

public class TelekinesisAdapter implements ISpecialAbilityAdapter {

    private final Telekinesis telekinesis = new Telekinesis();

    static final Integer FIXED_NUMBER_OF_DESTINATIONS = 1;

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {

        if(destinations.length != FIXED_NUMBER_OF_DESTINATIONS){
            System.out.println(warrior.getName()+" can't execute the Telekinesis special ability because " +
                    "performing this ability must have only one object chosen to execute");
            return;
        }

        telekinesis.levitateObject(warrior.getName(), destinations[0]);
    }
}
