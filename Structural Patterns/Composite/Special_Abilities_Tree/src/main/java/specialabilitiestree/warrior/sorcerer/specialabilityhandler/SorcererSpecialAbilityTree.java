package specialabilitiestree.warrior.sorcerer.specialabilityhandler;

import specialabilitiestree.specialability.SpecialAbilityTree;

import java.util.HashMap;
import java.util.Map;

public class SorcererSpecialAbilityTree extends SpecialAbilityTree<SorcererSpecialAbility> {

    public SorcererSpecialAbilityTree() {
        addAbility(SorcererSpecialAbility.SHIELDING, new SorcererSpecialAbility[] { SorcererSpecialAbility.TELEKINESIS });
        addAbility(SorcererSpecialAbility.TELEKINESIS);
        addAbility(SorcererSpecialAbility.HEALING, new SorcererSpecialAbility[] { SorcererSpecialAbility.SHIELDING });
    }
}
