package equipmentenchantment.equipment.elfequipment.garb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HunterGarb extends Garb {

    static final Integer SOCKETS_QUANTITY = 2;
    static final Integer PHYSICAL_PROTECTION = 25;
    static final Integer CAMOUFLAGE_LEVEL = 17;

    public HunterGarb() {
        super(SOCKETS_QUANTITY, PHYSICAL_PROTECTION, CAMOUFLAGE_LEVEL);
    }

    @Override
    public String toString() {
        return "Hunter Garb";
    }

}
