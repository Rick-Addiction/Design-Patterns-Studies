package equipmentenchantment.equipment.enchantment;

public class FuryEnchantment extends IEnchantment {

    @Override
    protected String activateEnchantment() {
        return String.format("The enchantment %s has been activated.",this);
    }

    @Override
    protected String deactivateEnchantment() {
        return String.format("The enchantment %s has been deactivated.",this);
    }

    @Override
    public String toString() {
        return "Fury Enchantment";
    }
}
