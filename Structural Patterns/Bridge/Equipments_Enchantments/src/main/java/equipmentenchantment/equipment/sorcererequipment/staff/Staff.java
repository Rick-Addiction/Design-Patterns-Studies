package equipmentenchantment.equipment.sorcererequipment.staff;

import equipmentenchantment.equipment.Weapon;

public abstract class Staff extends Weapon {

    final Integer spellPower;
    final Integer armorPenetration;

    Staff(Integer socketsQuantity, Integer spellPower, Integer armorPenetration){
        super(socketsQuantity);
        this.spellPower=spellPower;
        this.armorPenetration=armorPenetration;
    }
}
