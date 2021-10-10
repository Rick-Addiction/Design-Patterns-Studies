package equipmentenchantment.equipment.sorcererequipment.robe;

public class DarkMysticRobe extends Robe {

    static final Integer SOCKETS_QUANTITY = 2;
    static final Integer PHYSICAL_PROTECTION = 20;
    static final Integer CAMOUFLAGE_LEVEL = 15;

    public DarkMysticRobe() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, CAMOUFLAGE_LEVEL);
    }

    @Override
    public String toString() {
        return "Dark Mystic Robe";
    }
}
