package specialabilitiestree.warrior;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.common.ISpecialAbilityAdapterFactory;

public class Warrior<A> {
    private String name;

    private WarriorClass warriorClass;

    private HairColor hairColor;

    private IClothing clothing;

    private IWeapon weapon;

    private ISpecialAbilityAdapterFactory<A> specialAbilityAdapterFactory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWarriorClass(WarriorClass warriorClass) {
        this.warriorClass = warriorClass;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public void setClothing(IClothing clothing) {
        this.clothing = clothing;
    }

    public void setWeapon(IWeapon weapon) {
        this.weapon = weapon;
    }

    public ISpecialAbilityAdapterFactory<A> getSpecialAbilityAdapterFactory() {
        return specialAbilityAdapterFactory;
    }

    public void setSpecialAbilityAdapterFactory(ISpecialAbilityAdapterFactory<A> specialAbilityAdapterFactory) {
        this.specialAbilityAdapterFactory = specialAbilityAdapterFactory;
    }

    public void useAbility(A specialAbility, String...destinations){
        ISpecialAbilityAdapter specialAbilityAdapter = specialAbilityAdapterFactory
                .getSpecialAbilityAdapterBySpecialAbilityType(specialAbility);

        specialAbilityAdapter.useSpecialAbility(this, destinations);
    }

    @Override
    public String toString()
    {
        return "\nYou have spawned a [" + hairColor+(warriorClass != null ? " "+ warriorClass : "")+ "] warrior" +
                " called ["+name+ "]"+
                " clothing a ["+ clothing + "] " + clothing.getClass().getSimpleName() +
                " and holding a ["+ weapon + "] "+ weapon.getClass().getSimpleName();
    }
}
