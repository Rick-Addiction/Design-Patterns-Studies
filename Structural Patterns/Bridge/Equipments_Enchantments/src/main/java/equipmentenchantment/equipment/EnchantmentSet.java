package equipmentenchantment.equipment;

import equipmentenchantment.equipment.enchantment.IEnchantment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class EnchantmentSet {

    private List<IEnchantment> enchantmentSockets;
    private final Integer socketsQuantity;
    private int currentEnchantmentSocketIndex = 0;
    private static Logger logger = LoggerFactory.getLogger(EnchantmentSet.class);

    public EnchantmentSet(Integer socketsQuantity){
        this.socketsQuantity =socketsQuantity;
        enchantmentSockets = new LinkedList<>(Arrays.asList(new IEnchantment[socketsQuantity]));
    }
    public String activateCurrentEnchantment(){
        if(containsEnchantmentInTheSocket(currentEnchantmentSocketIndex)) {
            return enchantmentSockets.get(currentEnchantmentSocketIndex).executeActivation();
        }
        else{
            return null;
        }
    }

    public String deactivateCurrentEnchantment(){
        if(currentEnchantmentSocketIndex < enchantmentSockets.size()) {
            return enchantmentSockets.get(currentEnchantmentSocketIndex).executeDeactivation();
        }
        else{
            return null;
        }
    }

    public Optional<IEnchantment> nextEnchantmentSocket(){
        getCurrentEnchantment().ifPresent(IEnchantment::executeDeactivation);

        if(currentEnchantmentSocketIndex == socketsQuantity - 1){
            currentEnchantmentSocketIndex = 0;
        }
        else{
            currentEnchantmentSocketIndex++;
        }

        return getCurrentEnchantment();
    }

    public Optional<IEnchantment> previousEnchantmentSocket(){
        getCurrentEnchantment().ifPresent(IEnchantment::executeDeactivation);

        if(currentEnchantmentSocketIndex == 0){
            currentEnchantmentSocketIndex = socketsQuantity - 1;
        }
        else{
            currentEnchantmentSocketIndex--;
        }

        return getCurrentEnchantment();
    }

    public Optional<IEnchantment> removeEnchantmentFromCurrentSocket(){

        if(containsEnchantmentInTheSocket(currentEnchantmentSocketIndex)) {
            Optional<IEnchantment> currentEnchantment =
                    Optional.ofNullable(enchantmentSockets.get(currentEnchantmentSocketIndex));
            enchantmentSockets.remove(currentEnchantmentSocketIndex);
            return currentEnchantment;
        }
        else{
            return Optional.empty();
        }
    }

    public boolean addEnchantmentToCurrentSocket(IEnchantment enchantment){
        if(!containsEnchantmentInTheSocket(currentEnchantmentSocketIndex)) {
            enchantmentSockets.add(currentEnchantmentSocketIndex, enchantment);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean containsEnchantmentInTheSocket(Integer enchantmentSocketIndex){
        return enchantmentSockets.get(enchantmentSocketIndex) != null;
    }

    public boolean containsEnchantmentInTheCurrentSocket(){
        return enchantmentSockets.get(currentEnchantmentSocketIndex) != null;
    }

    public Optional<IEnchantment> getCurrentEnchantment(){
        return Optional.ofNullable(enchantmentSockets.get(currentEnchantmentSocketIndex));
    }

    public int getCurrentEnchantmentSocketPosition() {
        return currentEnchantmentSocketIndex+1;
    }
}
