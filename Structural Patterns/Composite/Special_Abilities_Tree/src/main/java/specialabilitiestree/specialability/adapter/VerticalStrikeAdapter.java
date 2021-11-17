package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.VerticalStrike;
import specialabilitiestree.warrior.Warrior;

public class VerticalStrikeAdapter implements ISpecialAbilityAdapter {

    private final VerticalStrike verticalStrike = new VerticalStrike();

    static final Integer MINIMUM_NUMBER_OF_DESTINATIONS=1;

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {

        if(destinations.length < MINIMUM_NUMBER_OF_DESTINATIONS){
            System.out.println(warrior.getName()+" can't execute the Vertical Strike attack because " +
                    "performing this ability must have at least one enemy chosen to execute");
            return;
        }

        verticalStrike.executeVerticalStrike(warrior.getName(), destinations);
    }
}
