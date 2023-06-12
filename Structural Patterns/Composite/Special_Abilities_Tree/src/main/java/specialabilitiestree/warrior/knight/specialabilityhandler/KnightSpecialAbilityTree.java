package specialabilitiestree.warrior.knight.specialabilityhandler;

import specialabilitiestree.specialability.SpecialAbilityTree;

public class KnightSpecialAbilityTree extends SpecialAbilityTree<KnightSpecialAbility> {
    public KnightSpecialAbilityTree() {
        addAbility(KnightSpecialAbility.VERTICAL_STRIKE);
        addAbility(KnightSpecialAbility.CYCLONE, new KnightSpecialAbility[] { KnightSpecialAbility.VERTICAL_STRIKE });
        addAbility(KnightSpecialAbility.BERSERK);
    }

}