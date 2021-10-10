package equipmentenchantment.equipment.sorcererequipment.staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncinerationStaff extends Staff {

    static final Integer SOCKETS_QUANTITY = 1;
    static final Integer SPELL_POWER = 10;
    static final Integer ARMOR_PENETRATION = 5;
    private static Logger logger = LoggerFactory.getLogger(IncinerationStaff.class);

    public IncinerationStaff() {
        super(SOCKETS_QUANTITY, SPELL_POWER, ARMOR_PENETRATION);
    }

    @Override
    public void executeAttack() {
        logger.info("You magically attacked the enemy with the Incineration Staff");
    }

    @Override
    public String toString() {
        return "Incineration Staff";
    }
}
