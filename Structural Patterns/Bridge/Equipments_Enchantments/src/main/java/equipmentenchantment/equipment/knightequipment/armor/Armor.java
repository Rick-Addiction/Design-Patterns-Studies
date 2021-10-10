package equipmentenchantment.equipment.knightequipment.armor;

import equipmentenchantment.equipment.Clothing;

public abstract class Armor extends Clothing {

    final Integer physicalProtection;
    final Integer fireProtection;
    final Integer iceProtection;
    final Integer shockProtection;

    Armor(Integer socketsQuantity, Integer physicalProtection, Integer fireProtection, Integer iceProtection, Integer shockProtection){
        super(socketsQuantity);
        this.physicalProtection=physicalProtection;
        this.fireProtection=fireProtection;
        this.iceProtection=iceProtection;
        this.shockProtection=shockProtection;
    }
}
