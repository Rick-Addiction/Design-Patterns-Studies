package warriorbuilder.warrior;

public class Warrior<C,W> {
    private String name;

    private WarriorClass warriorClass;

    private HairColor hairColor;

    private C clothing;

    private W weapon;

    public void setName(String name) {
        this.name = name;
    }

    public void setWarriorClass(WarriorClass warriorClass) {
        this.warriorClass = warriorClass;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public void setClothing(C clothing) {
        this.clothing = clothing;
    }

    public void setWeapon(W weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString()
    {
        return "You have spawned a [" + hairColor+(warriorClass != null ? " "+ warriorClass : "")+ "] warrior" +
                " called ["+name+ "]"+
                " clothing a ["+ clothing + "] " + clothing.getClass().getSimpleName() +
                " and holding a ["+weapon + "] "+ weapon.getClass().getSimpleName();
    }
}
