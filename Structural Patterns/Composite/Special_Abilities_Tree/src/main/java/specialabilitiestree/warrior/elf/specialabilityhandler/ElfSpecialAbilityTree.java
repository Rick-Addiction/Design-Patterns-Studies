package specialabilitiestree.warrior.elf.specialabilityhandler;

import specialabilitiestree.specialability.SpecialAbilityTree;

public class ElfSpecialAbilityTree extends SpecialAbilityTree<ElfSpecialAbility> {

    public ElfSpecialAbilityTree() {
        addAbility(ElfSpecialAbility.POSSESSION);
        addAbility(ElfSpecialAbility.CONCENTRATION, new ElfSpecialAbility[] { ElfSpecialAbility.POSSESSION });
        addAbility(ElfSpecialAbility.AGILITY);
    }

}

