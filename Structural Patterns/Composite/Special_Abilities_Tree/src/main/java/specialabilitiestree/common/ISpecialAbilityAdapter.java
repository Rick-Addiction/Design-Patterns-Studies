package specialabilitiestree.common;

import specialabilitiestree.warrior.Warrior;

public interface ISpecialAbilityAdapter {
    void useSpecialAbility(Warrior warrior, String...destinations);
}
