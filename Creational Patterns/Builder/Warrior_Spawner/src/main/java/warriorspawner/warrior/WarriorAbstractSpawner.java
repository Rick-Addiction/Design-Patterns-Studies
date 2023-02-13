package warriorspawner.warrior;

public abstract class WarriorAbstractSpawner<S extends WarriorAbstractSpawner<S>>{

    protected Warrior warrior = new Warrior();

    public S withName(String name){
        warrior.setName(name);
        return self();
    }

    public S withHairColor(HairColor hairColor){
        warrior.setHairColor(hairColor);
        return self();
    }

    public abstract Warrior build();

    protected S self()
    {
        return (S) this;
    }
}
