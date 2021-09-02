package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Telekinesis;

public class TelekinesisAdapter implements ISpecialAbilityAdapter {

    private final Telekinesis telekinesis = new Telekinesis();

    @Override
    public void useSpecialAbility() {
        telekinesis.levitateObject();
    }
}
