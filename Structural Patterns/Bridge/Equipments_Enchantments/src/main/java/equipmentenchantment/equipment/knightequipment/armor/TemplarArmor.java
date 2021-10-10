package equipmentenchantment.equipment.knightequipment.armor;

public class TemplarArmor extends Armor {

    static final Integer SOCKETS_QUANTITY = 2;
    static final Integer PHYSICAL_PROTECTION = 27;
    static final Integer FIRE_PROTECTION = 15;
    static final Integer ICE_PROTECTION = 8;
    static final Integer SHOCK_PROTECTION = 10;

    public TemplarArmor() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, FIRE_PROTECTION, ICE_PROTECTION, SHOCK_PROTECTION);
    }

    @Override
    public String toString() {
        return "Templar Armor";
    }

}
