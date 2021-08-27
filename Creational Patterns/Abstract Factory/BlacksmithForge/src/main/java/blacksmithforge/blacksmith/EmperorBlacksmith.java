package blacksmithforge.blacksmith;

import blacksmithforge.equipment.armor.Armor;
import blacksmithforge.equipment.armor.EmperorArmor;
import blacksmithforge.equipment.shield.EmperorShield;
import blacksmithforge.equipment.shield.Shield;
import blacksmithforge.equipment.sword.EmperorSword;
import blacksmithforge.equipment.sword.Sword;

public class EmperorBlacksmith implements Blacksmith {

    @Override
    public Sword forgeSword() {
        return new EmperorSword();
    }

    @Override
    public Armor forgeArmor() {
        return new EmperorArmor();
    }

    @Override
    public Shield forgeShield() {
        return new EmperorShield();
    }
}
