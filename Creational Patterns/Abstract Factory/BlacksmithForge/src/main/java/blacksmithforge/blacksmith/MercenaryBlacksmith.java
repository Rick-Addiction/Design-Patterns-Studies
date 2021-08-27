package blacksmithforge.blacksmith;

import blacksmithforge.equipment.armor.Armor;
import blacksmithforge.equipment.armor.MercenaryArmor;
import blacksmithforge.equipment.shield.MercenaryShield;
import blacksmithforge.equipment.shield.Shield;
import blacksmithforge.equipment.sword.MercenarySword;
import blacksmithforge.equipment.sword.Sword;

public class MercenaryBlacksmith implements Blacksmith {


    @Override
    public Sword forgeSword() {
        return new MercenarySword();
    }

    @Override
    public Armor forgeArmor() {
        return new MercenaryArmor();
    }

    @Override
    public Shield forgeShield() {
        return new MercenaryShield();
    }
}
