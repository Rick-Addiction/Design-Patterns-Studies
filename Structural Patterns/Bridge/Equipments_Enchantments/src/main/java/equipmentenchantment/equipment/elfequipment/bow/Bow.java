package equipmentenchantment.equipment.elfequipment.bow;

import equipmentenchantment.equipment.Weapon;

public abstract class Bow extends Weapon {

    final Integer radiusAttack;
    final Integer attackDamage;
    final Integer pierceChance;

    Bow(Integer socketsQuantity, Integer radiusAttack, Integer attackDamage, Integer pierceChance){
        super(socketsQuantity);
        this.radiusAttack=radiusAttack;
        this.attackDamage=attackDamage;
        this.pierceChance=pierceChance;
    }
}
