package equipmentenchantment.equipment.elfequipment.garb;

import equipmentenchantment.equipment.Clothing;

public abstract class Garb extends Clothing {

    final Integer physicalProtection;
    final Integer camouflageLevel;

    Garb(Integer socketsQuantity, Integer physicalProtection, Integer camouflageLevel){
        super(socketsQuantity);
        this.physicalProtection=physicalProtection;
        this.camouflageLevel=camouflageLevel;
    }
}
