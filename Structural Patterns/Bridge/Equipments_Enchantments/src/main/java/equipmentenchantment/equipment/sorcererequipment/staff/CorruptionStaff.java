package equipmentenchantment.equipment.sorcererequipment.staff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CorruptionStaff extends Staff {

    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer SPELL_POWER = 30;
    static final Integer ARMOR_PENETRATION = 25;
    private static Logger logger = LoggerFactory.getLogger(CorruptionStaff.class);

    public CorruptionStaff() {
        super(SOCKETS_QUANTITY, SPELL_POWER, ARMOR_PENETRATION);
    }

    @Override
    public void executeAttack() {
        logger.info("You magically attacked the enemy with the Corruption Staff");
    }

    @Override
    public String toString() {
        return "Corruption Staff";
    }
}
