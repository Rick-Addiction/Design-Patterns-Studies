package blacksmithforge.equipment.armor;

import blacksmithforge.equipment.Equipment;

public abstract class Armor extends Equipment {
    protected Integer physicalProtection;
    protected Integer fireProtection;
    protected Integer iceProtection;
    protected Integer shockProtection;

    @Override
    public String toString() {
        return "You have forged a new "+this.getClass().getSimpleName()+"\n"+
                "###ATTRIBUTES###\n"+
                "Physical Protection: "+physicalProtection+"\n"+
                "Fire Protection: "+fireProtection+"\n"+
                "Ice Protection: "+iceProtection+"\n"+
                "Shock Protection: "+shockProtection+"\n"+
                "Durability: "+durability+"\n"+
                "Weight: "+weight+"kg\n";
    }


}
