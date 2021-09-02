package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Possession;

public class PossessionAdapter implements ISpecialAbilityAdapter {

    private final Possession possession = new Possession();

    @Override
    public void useSpecialAbility() {
        possession.possesEnemy();
    }
}
