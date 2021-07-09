package blacksmithforge.equipment.shield;

import blacksmithforge.equipment.Equipment;

public abstract class Shield extends Equipment {
    Integer chanceToBlock;
    Integer physicalProtection;
    Integer fireProtection;
    Integer iceProtection;
    Integer shockProtection;
    Integer attackDamage;

    @Override
    public String toString() {
        return "You have forged a new "+this.getClass().getSimpleName()+"\n"+
                "###ATTRIBUTES###\n"+
                "Physical Protection: "+physicalProtection+"\n"+
                "Fire Protection: "+fireProtection+"\n"+
                "Ice Protection: "+iceProtection+"\n"+
                "Shock Protection: "+shockProtection+"\n"+
                "Attack Damage: "+attackDamage+"\n"+
                "Chance to Block: "+chanceToBlock+"%\n"+
                "Durability: "+durability+"\n"+
                "Weight: "+weight+"kg\n";
    }


}
