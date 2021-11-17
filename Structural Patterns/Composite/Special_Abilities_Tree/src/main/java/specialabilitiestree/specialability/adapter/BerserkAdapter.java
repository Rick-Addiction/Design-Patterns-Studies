package specialabilitiestree.specialability.adapter;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.Berserk;
import specialabilitiestree.warrior.Warrior;

public class BerserkAdapter implements ISpecialAbilityAdapter {

    private final Berserk berserk = new Berserk();

    @Override
    public void useSpecialAbility(Warrior warrior, String...destinations) {
        berserk.startBerserkMode(warrior.getName());
    }
}
