package warriorbuilder.warrior.knight;

import warriorbuilder.warrior.WarriorBuilder;
import warriorbuilder.warrior.WarriorClass;

public class KnightBuilder extends WarriorBuilder<KnightBuilder, Armor, Sword> {

    public KnightBuilder(){
        warrior.setWarriorClass(WarriorClass.KNIGHT);
    }

    public KnightBuilder withArmor(Armor armor){
        warrior.setClothing(armor);
        return this;
    }

    public KnightBuilder withSword(Sword sword){
        warrior.setWeapon(sword);
        return this;
    }


}
