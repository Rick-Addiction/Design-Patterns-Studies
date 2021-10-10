package equipmentenchantment.equipment.elfequipment.bow;

import equipmentenchantment.equipment.EnchantmentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AggressiveBow extends Bow {

    static final Integer SOCKETS_QUANTITY = 2;
    static final Integer RADIUS_ATTACK = 10;
    static final Integer ATTACK_DAMAGE = 30;
    static final Integer PIERCE_CHANCE = 15;
    private static Logger logger = LoggerFactory.getLogger(AggressiveBow.class);

    public AggressiveBow() {
        super(SOCKETS_QUANTITY, RADIUS_ATTACK, ATTACK_DAMAGE, PIERCE_CHANCE);
    }

    @Override
    public void executeAttack() {
        logger.info("You shot an arrow with the Aggressive Bow");
    }

    @Override
    public String toString() {
        return "Aggressive Bow";
    }
}
