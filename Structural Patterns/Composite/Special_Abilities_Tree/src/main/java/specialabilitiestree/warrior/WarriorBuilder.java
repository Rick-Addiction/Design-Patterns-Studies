package specialabilitiestree.warrior;

import specialabilitiestree.specialability.SpecialAbility;

public abstract class WarriorBuilder<S extends WarriorBuilder<S,A>, A extends SpecialAbility>{

    protected Warrior<A> warrior = new Warrior<>();

    public S withName(String name){
        warrior.setName(name);
        return self();
    }

    public S withHairColor(HairColor hairColor){
        warrior.setHairColor(hairColor);
        return self();
    }

    public abstract Warrior<A> build();

    protected S self()
    {
        return (S) this;
    }
}
