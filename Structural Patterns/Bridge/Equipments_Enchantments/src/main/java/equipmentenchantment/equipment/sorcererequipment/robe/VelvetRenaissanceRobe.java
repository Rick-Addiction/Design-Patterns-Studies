package equipmentenchantment.equipment.sorcererequipment.robe;

public class VelvetRenaissanceRobe extends Robe {

    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer PHYSICAL_PROTECTION = 35;
    static final Integer CAMOUFLAGE_LEVEL = 30;

    public VelvetRenaissanceRobe() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, CAMOUFLAGE_LEVEL);
    }

    @Override
    public String toString() {
        return "Velvet Renaissance Robe";
    }
}
