package equipmentenchantment.equipment.knightequipment.sword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmperorBladeSword extends Sword {

    static final Integer SOCKETS_QUANTITY = 3;
    static final Integer CRITICAL_STRIKE_CHANCE = 30;
    static final Integer ATTACK_DAMAGE = 50;
    private static Logger logger = LoggerFactory.getLogger(EmperorBladeSword.class);

    public EmperorBladeSword() {
        super(SOCKETS_QUANTITY, CRITICAL_STRIKE_CHANCE, ATTACK_DAMAGE);
    }

    @Override
    public void executeAttack() {
        logger.info("You attacked the enemy with the Emperor Blade Sword");
    }

    @Override
    public String toString() {
        return "Emperor Blade Sword";
    }
}
