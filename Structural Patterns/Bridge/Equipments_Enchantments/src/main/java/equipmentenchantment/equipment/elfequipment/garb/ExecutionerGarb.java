package equipmentenchantment.equipment.elfequipment.garb;

public class ExecutionerGarb extends Garb {

    static final Integer SOCKETS_QUANTITY = 1;
    static final Integer PHYSICAL_PROTECTION = 10;
    static final Integer CAMOUFLAGE_LEVEL = 5;

    public ExecutionerGarb() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, CAMOUFLAGE_LEVEL);
    }

    @Override
    public String toString() {
        return "Executioner Garb";
    }
}
