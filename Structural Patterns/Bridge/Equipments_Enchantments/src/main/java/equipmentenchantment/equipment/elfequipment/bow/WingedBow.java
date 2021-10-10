package equipmentenchantment.equipment.elfequipment.bow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingedBow extends Bow {
    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer RADIUS_ATTACK = 5;
    static final Integer ATTACK_DAMAGE = 40;
    static final Integer PIERCE_CHANCE = 25;
    private static Logger logger = LoggerFactory.getLogger(WingedBow.class);

    public WingedBow() {
        super(SOCKETS_QUANTITY, RADIUS_ATTACK, ATTACK_DAMAGE, PIERCE_CHANCE);
    }

    @Override
    public void executeAttack() {
        logger.info("You shot an arrow with the Winged Bow");
    }

    @Override
    public String toString() {
        return "Winged Bow";
    }
}
