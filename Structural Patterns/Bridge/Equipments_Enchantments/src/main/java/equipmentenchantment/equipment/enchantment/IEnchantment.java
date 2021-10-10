package equipmentenchantment.equipment.enchantment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class IEnchantment {

    EnchantmentStatus enchantmentStatus = EnchantmentStatus.DEACTIVATED;
    protected abstract String activateEnchantment();
    protected abstract String deactivateEnchantment();

    private static Logger logger = LoggerFactory.getLogger(IEnchantment.class);

    public String executeActivation(){

        if(enchantmentStatus==EnchantmentStatus.DEACTIVATED){
            String enchantmentActivationResult = activateEnchantment();
            enchantmentStatus=EnchantmentStatus.ACTIVATED;
            return enchantmentActivationResult;
        }
        else{
            return "The Enchantment is already activated";
        }
    }

    public String executeDeactivation(){

        if(enchantmentStatus==EnchantmentStatus.ACTIVATED){
            String enchantmentDeactivationResult = deactivateEnchantment();
            enchantmentStatus=EnchantmentStatus.DEACTIVATED;

            return enchantmentDeactivationResult;
        }
        else{
             return "The Enchantment is already deactivated";
        }
    }

}
