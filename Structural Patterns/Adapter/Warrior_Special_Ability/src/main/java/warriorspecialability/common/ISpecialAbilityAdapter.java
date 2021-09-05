package warriorspecialability.common;

import warriorspecialability.warrior.Warrior;

public interface ISpecialAbilityAdapter {
    void useSpecialAbility(Warrior warrior, String...destinations);
}
