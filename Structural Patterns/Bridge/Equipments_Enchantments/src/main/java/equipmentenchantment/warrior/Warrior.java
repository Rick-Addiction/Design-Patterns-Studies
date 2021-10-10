package equipmentenchantment.warrior;


import equipmentenchantment.equipment.Clothing;
import equipmentenchantment.equipment.Weapon;

public class Warrior {
    private String name;

    private WarriorClass warriorClass;

    private HairColor hairColor;

    private Clothing clothing;

    private Weapon weapon;

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

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon handleWeapon(){
        return weapon;
    }

    public Clothing handleClothing(){
        return clothing;
    }

    @Override
    public String toString()
    {
        return "You have spawned a [" + hairColor+(warriorClass != null ? " "+ warriorClass : "")+ "] warrior" +
                " called ["+name+ "]"+
                " clothing a [" + clothing + "]"+
                " and holding a ["+ weapon + "]";
    }
}
