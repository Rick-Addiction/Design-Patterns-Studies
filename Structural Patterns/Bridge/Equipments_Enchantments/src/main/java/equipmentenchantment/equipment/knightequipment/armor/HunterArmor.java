package equipmentenchantment.equipment.knightequipment.armor;

public class HunterArmor extends Armor {

    static final Integer SOCKETS_QUANTITY = 1;
    static final Integer PHYSICAL_PROTECTION = 10;
    static final Integer FIRE_PROTECTION = 5;
    static final Integer ICE_PROTECTION = 5;
    static final Integer SHOCK_PROTECTION = 5;

    public HunterArmor() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, FIRE_PROTECTION, ICE_PROTECTION, SHOCK_PROTECTION);
    }

    @Override
    public String toString() {
        return "Hunter Armor";
    }
}
