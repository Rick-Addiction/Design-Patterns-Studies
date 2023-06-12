package specialabilitiestree.warrior;

import specialabilitiestree.common.ISpecialAbilityAdapter;
import specialabilitiestree.common.ISpecialAbilityAdapterFactory;
import specialabilitiestree.specialability.SpecialAbility;
import specialabilitiestree.specialability.SpecialAbilityTree;

public class Warrior<SpecialAbilityType extends SpecialAbility> {
    private String name;

    private WarriorClass warriorClass;

    private HairColor hairColor;

    private IClothing clothing;

    private IWeapon weapon;

    private ISpecialAbilityAdapterFactory<SpecialAbilityType> specialAbilityAdapterFactory;

    private SpecialAbilityTree<SpecialAbilityType> specialAbilityTree;



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

    public ISpecialAbilityAdapterFactory<SpecialAbilityType> getSpecialAbilityAdapterFactory() {
        return specialAbilityAdapterFactory;
    }

    public void setSpecialAbilityAdapterFactory(ISpecialAbilityAdapterFactory<SpecialAbilityType> specialAbilityAdapterFactory) {
        this.specialAbilityAdapterFactory = specialAbilityAdapterFactory;
    }

    public void setSpecialAbilityTree(SpecialAbilityTree<SpecialAbilityType> specialAbilityTree) {
        this.specialAbilityTree = specialAbilityTree;
    }

    public void useAbility(SpecialAbilityType specialAbility, String...destinations){
        ISpecialAbilityAdapter specialAbilityAdapter = specialAbilityAdapterFactory
                .getSpecialAbilityAdapterBySpecialAbilityType(specialAbility);

        if(specialAbilityAdapter == null)
            System.out.println(name + " does not have the ability " + specialAbility);
        else
            specialAbilityAdapter.useSpecialAbility(this, destinations);
    }

    public boolean acquireSpecialAbility(SpecialAbilityType specialAbility){
        if (specialAbilityTree.canAcquireAbility(specialAbility)) {
            specialAbilityAdapterFactory.addAcquiredSpecialAbility(specialAbility);
            return true;
        }
        return false;
    }

    public void displaySpecialAbilities() {
        System.out.println("Special abilities for " + getName() + ":");
        specialAbilityTree.displayTree(specialAbilityAdapterFactory.getAcquiredSpecialAbilities());
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
