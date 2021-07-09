package blacksmithforge.equipment;

public abstract class Equipment {

    protected Integer weight;
    protected Integer durability;

    public void describeEquipment(){
        System.out.println(this.toString());
    }


}
