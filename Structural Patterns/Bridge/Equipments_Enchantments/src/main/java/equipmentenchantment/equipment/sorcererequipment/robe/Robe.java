package equipmentenchantment.equipment.sorcererequipment.robe;

import equipmentenchantment.equipment.Clothing;

public abstract class Robe extends Clothing {

    final Integer physicalProtection;
    final Integer camouflageLevel;

    Robe(Integer socketsQuantity, Integer physicalProtection, Integer camouflageLevel){
        super(socketsQuantity);
        this.physicalProtection=physicalProtection;
        this.camouflageLevel=camouflageLevel;
    }
}
