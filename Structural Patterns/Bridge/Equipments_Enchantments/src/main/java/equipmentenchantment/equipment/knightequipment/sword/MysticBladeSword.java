package equipmentenchantment.equipment.knightequipment.sword;

import equipmentenchantment.equipment.elfequipment.bow.Bow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysticBladeSword extends Sword {

    static final Integer SOCKETS_QUANTITY = 1;
    static final Integer CRITICAL_STRIKE_CHANCE = 5;
    static final Integer ATTACK_DAMAGE = 20;
    private static Logger logger = LoggerFactory.getLogger(MysticBladeSword.class);

    public MysticBladeSword() {
        super(SOCKETS_QUANTITY, CRITICAL_STRIKE_CHANCE, ATTACK_DAMAGE);
    }

    @Override
    public void executeAttack() {
        logger.info("You attacked the enemy with the Mystic Blade Sword");
    }

    @Override
    public String toString() {
        return "Mystic Blade Sword";
    }
}
