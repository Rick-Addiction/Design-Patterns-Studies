package equipmentenchantment.equipment.elfequipment.garb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForeignGarb extends Garb {

    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer PHYSICAL_PROTECTION = 30;
    static final Integer CAMOUFLAGE_LEVEL = 27;

    public ForeignGarb() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, CAMOUFLAGE_LEVEL);
    }

    @Override
    public String toString() {
        return "Foreign Garb";
    }

}
