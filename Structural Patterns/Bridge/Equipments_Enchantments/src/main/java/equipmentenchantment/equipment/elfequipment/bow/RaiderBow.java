package equipmentenchantment.equipment.elfequipment.bow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RaiderBow extends Bow {

    static final Integer SOCKETS_QUANTITY = 1;
    static final Integer RADIUS_ATTACK = 10;
    static final Integer ATTACK_DAMAGE = 50;
    static final Integer PIERCE_CHANCE = 5;
    private static Logger logger = LoggerFactory.getLogger(RaiderBow.class);

    public RaiderBow() {
        super(SOCKETS_QUANTITY, RADIUS_ATTACK, ATTACK_DAMAGE, PIERCE_CHANCE);
    }

    @Override
    public void executeAttack() {
        logger.info("You shot an arrow with the Raider Bow");
    }

    @Override
    public String toString() {
        return "Raider Bow";
    }
}
