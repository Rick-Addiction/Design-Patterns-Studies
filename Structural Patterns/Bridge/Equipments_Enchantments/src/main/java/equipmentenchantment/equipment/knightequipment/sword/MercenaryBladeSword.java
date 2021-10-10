package equipmentenchantment.equipment.knightequipment.sword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MercenaryBladeSword extends Sword {

    static final Integer SOCKETS_QUANTITY = 2;
    static final Integer CRITICAL_STRIKE_CHANCE = 15;
    static final Integer ATTACK_DAMAGE = 30;
    private static Logger logger = LoggerFactory.getLogger(MercenaryBladeSword.class);

    public MercenaryBladeSword() {
        super(SOCKETS_QUANTITY, CRITICAL_STRIKE_CHANCE, ATTACK_DAMAGE);
    }

    @Override
    public void executeAttack() {
        logger.info("You attacked the enemy with the Mercenary Blade Sword");
    }

    @Override
    public String toString() {
        return "Mercenary Blade Sword";
    }
}
