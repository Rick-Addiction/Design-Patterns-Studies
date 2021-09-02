package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Berserk;

public class BerserkAdapter implements ISpecialAbilityAdapter {

    private final Berserk berserk = new Berserk();

    @Override
    public void useSpecialAbility() {
        berserk.startBerserkMode();
    }
}
