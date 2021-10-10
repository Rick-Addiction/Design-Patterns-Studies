package equipmentenchantment.equipment.knightequipment.armor;

public class MercenaryArmor extends Armor {

    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer PHYSICAL_PROTECTION = 40;
    static final Integer FIRE_PROTECTION = 25;
    static final Integer ICE_PROTECTION = 20;
    static final Integer SHOCK_PROTECTION = 27;

    public MercenaryArmor() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, FIRE_PROTECTION, ICE_PROTECTION, SHOCK_PROTECTION);
    }

    @Override
    public String toString() {
        return "Mercenary Armor";
    }
}
