package equipmentenchantment.equipment.sorcererequipment.staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagnusStaff extends Staff {

    static final Integer SOCKETS_QUANTITY = 2;
    static final Integer SPELL_POWER = 20;
    static final Integer ARMOR_PENETRATION = 15;
    private static Logger logger = LoggerFactory.getLogger(MagnusStaff.class);

    public MagnusStaff() {
        super(SOCKETS_QUANTITY, SPELL_POWER, ARMOR_PENETRATION);
    }

    @Override
    public void executeAttack() {
        logger.info("You magically attacked the enemy with the Magnus Staff");
    }

    @Override
    public String toString() {
        return "Magnus Staff";
    }
}
