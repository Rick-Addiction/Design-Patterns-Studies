package equipmentenchantment.equipment.sorcererequipment.robe;

public class MonkRobe extends Robe {

    static final Integer SOCKETS_QUANTITY = 1;
    static final Integer PHYSICAL_PROTECTION = 10;
    static final Integer CAMOUFLAGE_LEVEL = 5;

    public MonkRobe() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, CAMOUFLAGE_LEVEL);
    }

    @Override
    public String toString() {
        return "Monk Robe";
    }
}
