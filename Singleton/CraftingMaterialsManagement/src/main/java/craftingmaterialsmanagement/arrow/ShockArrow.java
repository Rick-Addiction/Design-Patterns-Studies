package craftingmaterialsmanagement.arrow;

public class ShockArrow extends Arrow {

    public ShockArrow(){
        this.damage = 60;
        this.pierce = 1;
        this.radius=50;
        this.arrowType=ArrowType.SHOCK;

        System.out.println("A new Shock Arrow has been crafted!\n");
    }
}
