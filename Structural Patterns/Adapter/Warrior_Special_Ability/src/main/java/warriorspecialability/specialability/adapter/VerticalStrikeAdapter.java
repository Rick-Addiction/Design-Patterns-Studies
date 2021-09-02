package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.VerticalStrike;

public class VerticalStrikeAdapter implements ISpecialAbilityAdapter {

    private final VerticalStrike verticalStrike = new VerticalStrike();

    @Override
    public void useSpecialAbility() {
        verticalStrike.executeVerticalStrike();
    }
}
