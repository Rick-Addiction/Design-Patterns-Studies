package blacksmithforge.blacksmith;

import blacksmithforge.equipment.armor.Armor;
import blacksmithforge.equipment.shield.Shield;
import blacksmithforge.equipment.sword.Sword;

public interface Blacksmith {
    Sword forgeSword();
    Armor forgeArmor();
    Shield forgeShield();
}
