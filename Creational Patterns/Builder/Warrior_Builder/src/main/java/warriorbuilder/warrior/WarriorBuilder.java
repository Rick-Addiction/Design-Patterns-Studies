package warriorbuilder.warrior;

public abstract class WarriorBuilder<S extends WarriorBuilder<S,C, W>
        , C, W> {

    protected Warrior<C, W> warrior = new Warrior<>();

    public S withName(String name){
        warrior.setName(name);
        return self();
    }

    public S withHairColor(HairColor hairColor){
        warrior.setHairColor(hairColor);
        return self();
    }

    public Warrior<C, W> build()
    {
        return warrior;
    }

    protected S self()
    {
        return (S) this;
    }
}
