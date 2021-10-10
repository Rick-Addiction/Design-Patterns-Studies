package equipmentenchantment.equipment;

public abstract class Weapon extends Equipment {
    public Weapon(Integer socketsQuantity) {
        super(socketsQuantity);
    }

    public abstract void executeAttack();
}
