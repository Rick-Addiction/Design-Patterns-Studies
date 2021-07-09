package blacksmithforge.equipment.sword;

import blacksmithforge.equipment.Equipment;

public abstract class Sword extends Equipment {
    Integer criticalStrikeChance;
    Integer attackDamage;

    @Override
    public String toString() {
        return "You have forged a new "+this.getClass().getSimpleName()+"\n"+
                "###ATTRIBUTES###\n"+
                "Attack Damage: "+attackDamage+"\n"+
                "Critical Strike Chance: "+criticalStrikeChance+"%\n"+
                "Durability: "+durability+"\n"+
                "Weight: "+weight+"kg\n";
    }

}
