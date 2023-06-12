package specialabilitiestree.warrior.elf.specialabilityhandler;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.specialability.SpecialAbility;
import specialabilitiestree.specialability.adapter.AgilityAdapter;
import specialabilitiestree.specialability.adapter.ConcentrationAdapter;
import specialabilitiestree.specialability.adapter.PossessionAdapter;

public enum ElfSpecialAbility implements SpecialAbility {

    POSSESSION(new PossessionAdapter()),
    CONCENTRATION(new ConcentrationAdapter()),
    AGILITY(new AgilityAdapter());

    private final ISpecialAbilityAdapter adapter;

    ElfSpecialAbility(ISpecialAbilityAdapter adapter) {
        this.adapter = adapter;
    }

    public ISpecialAbilityAdapter getAdapter() {
        return adapter;
    }


}
