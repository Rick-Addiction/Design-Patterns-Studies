package blacksmithforge.blacksmith;

import blacksmithforge.equipment.armor.Armor;
import blacksmithforge.equipment.armor.CorruptionArmor;
import blacksmithforge.equipment.shield.CorruptionShield;
import blacksmithforge.equipment.shield.Shield;
import blacksmithforge.equipment.sword.CorruptionSword;
import blacksmithforge.equipment.sword.Sword;

public class CorruptionBlacksmith implements Blacksmith {

    @Override
    public Sword forgeSword() { return new CorruptionSword(); }

    @Override
    public Armor forgeArmor() {
        return new CorruptionArmor();
    }

    @Override
    public Shield forgeShield() {
        return new CorruptionShield();
    }
}
