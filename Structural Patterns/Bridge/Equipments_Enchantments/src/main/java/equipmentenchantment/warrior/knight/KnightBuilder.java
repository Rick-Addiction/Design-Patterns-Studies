package equipmentenchantment.warrior.knight;

import equipmentenchantment.equipment.knightequipment.armor.Armor;
import equipmentenchantment.equipment.knightequipment.sword.Sword;
import equipmentenchantment.warrior.Warrior;
import equipmentenchantment.warrior.WarriorBuilder;
import equipmentenchantment.warrior.WarriorClass;

public class KnightBuilder extends WarriorBuilder<KnightBuilder> {

    public KnightBuilder(){
        warrior.setWarriorClass(WarriorClass.KNIGHT);
    }

    public KnightBuilder withArmor(Armor armor){
        warrior.setClothing(armor);
        armor.setWarriorWhoOwnsTheEquipment(warrior);
        return this;
    }

    public KnightBuilder withSword(Sword sword){
        warrior.setWeapon(sword);
        sword.setWarriorWhoOwnsTheEquipment(warrior);
        return this;
    }

    @Override
    public Warrior build() {
        return warrior;
    }
}
