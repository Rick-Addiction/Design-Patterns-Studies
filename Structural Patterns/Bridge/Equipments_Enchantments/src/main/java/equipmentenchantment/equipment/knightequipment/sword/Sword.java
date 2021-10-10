package equipmentenchantment.equipment.knightequipment.sword;

import equipmentenchantment.equipment.Weapon;

public abstract class Sword extends Weapon {

    final Integer criticalStrikeChance;
    final Integer attackDamage;

    Sword(Integer socketsQuantity, Integer criticalStrikeChance, Integer attackDamage){
        super(socketsQuantity);
        this.criticalStrikeChance=criticalStrikeChance;
        this.attackDamage=attackDamage;
    }
}
