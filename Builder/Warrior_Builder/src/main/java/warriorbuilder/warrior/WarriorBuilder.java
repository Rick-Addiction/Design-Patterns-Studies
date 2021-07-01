package warriorbuilder.warrior;

public abstract class WarriorBuilder<S extends WarriorBuilder<S,C, W>
        , C, W> {

    protected Warrior<C, W> warrior = new Warrior();

    public S withName(String name){
        warrior.name = name;
        return self();
    }

    public S withHairColor(HairColor hairColor){
        warrior.hairColor = hairColor;
        return self();
    }

    public Warrior build()
    {
        return warrior;
    }

    protected S self()
    {
        return (S) this;
    }
}
