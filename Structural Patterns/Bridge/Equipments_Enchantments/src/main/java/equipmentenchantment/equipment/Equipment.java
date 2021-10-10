package equipmentenchantment.equipment;

import equipmentenchantment.equipment.enchantment.IEnchantment;
import equipmentenchantment.warrior.Warrior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public abstract class Equipment {

      final EnchantmentSet enchantmentSet;
            Warrior warriorWhoOwnsTheEquipment;
      private static Logger logger = LoggerFactory.getLogger(Equipment.class);

      protected Equipment(Integer socketsQuantity){
            enchantmentSet = new EnchantmentSet(socketsQuantity);
      }

      public void setWarriorWhoOwnsTheEquipment(Warrior warriorWhoOwnsTheEquipment) {
            this.warriorWhoOwnsTheEquipment = warriorWhoOwnsTheEquipment;
      }

      public void activateCurrentEnchantment(){

            Optional<IEnchantment> currentEnchantment = enchantmentSet.getCurrentEnchantment();
            if(currentEnchantment.isPresent()) {
                  String enchantmentActivationResult = enchantmentSet.activateCurrentEnchantment();
                        logger.info("[{}] is activating the current enchantment socket [{}] from the [{}], the [{}]. {}",
                                warriorWhoOwnsTheEquipment.getName(),
                                enchantmentSet.getCurrentEnchantmentSocketPosition(),
                                this,
                                currentEnchantment.get(),
                                enchantmentActivationResult);
            }
            else{
                  logger.error("[{}] tried to activate the current enchantment, but there is no Enchantment in the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
      }

      public void deactivateCurrentEnchantment(){
            Optional<IEnchantment> currentEnchantment = enchantmentSet.getCurrentEnchantment();
            if(currentEnchantment.isPresent()) {
                  String enchantmentDeactivationResult = enchantmentSet.deactivateCurrentEnchantment();
                  logger.info("[{}] is deactivating the current enchantment socket [{}] from the [{}], the [{}]. {}",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this,
                          currentEnchantment.get(),
                          enchantmentDeactivationResult);
            }
            else{
                  logger.error("[{}] tried to activate the current enchantment, but there is no Enchantment in the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
      }

      public void nextEnchantment(){

            Optional<IEnchantment> currentEnchantment = enchantmentSet.nextEnchantmentSocket();

            if(currentEnchantment.isPresent())
                  logger.info("[{}] have changed to the next enchantment socket [{}] from the [{}], the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this,
                          currentEnchantment.get());
            else
                  logger.warn("[{}] have changed to the next enchantment socket [{}] from the [{}], which is empty",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
      }

      public void previousEnchantment(){

            Optional<IEnchantment> currentEnchantment = enchantmentSet.previousEnchantmentSocket();

            if(currentEnchantment.isPresent())
                  logger.info("[{}] have changed to the previous enchantment socket [{}] from the [{}], the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this,
                          currentEnchantment.get());
            else
                  logger.warn("[{}] have changed to the previous enchantment socket [{}] from the [{}], which is empty",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
      }

      public void removeEnchantment(){

            Optional<IEnchantment> currentEnchantment = enchantmentSet.removeEnchantmentFromCurrentSocket();

            if(currentEnchantment.isPresent()) {
                  logger.info("[{}] removed the [{}] from the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          currentEnchantment.get(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
            else{
                  logger.error("[{}] tried to remove the enchantment, but there is no Enchantment in the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
      }

      public void addEnchantmentToSocket(IEnchantment enchantmentToAdd){

            if(enchantmentSet.addEnchantmentToCurrentSocket(enchantmentToAdd)){
                  logger.info("[{}] added the [{}] in the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentToAdd,
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
            else{
                  logger.error("[{}] tried to add [{}], but there is already an Enchantment in the current socket [{}] on the [{}]",
                          warriorWhoOwnsTheEquipment.getName(),
                          enchantmentToAdd,
                          enchantmentSet.getCurrentEnchantmentSocketPosition(),
                          this);
            }
      }
}
