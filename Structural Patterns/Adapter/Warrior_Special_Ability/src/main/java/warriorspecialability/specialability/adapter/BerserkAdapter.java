package warriorspecialability.specialability.adapter;

import warriorspecialability.common.ISpecialAbilityAdapter;
import warriorspecialability.specialability.Berserk;
import warriorspecialability.warrior.Warrior;

public class BerserkAdapter implements ISpecialAbilityAdapter {

    private final Berserk berserk = new Berserk();

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        berserk.startBerserkMode(warrior.getName());
    }
}
