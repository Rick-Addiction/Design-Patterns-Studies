package craftingmaterialsmanagement.arrow;

public class IceArrow extends Arrow {

    public IceArrow(){
        this.damage = 10;
        this.pierce = 50;
        this.radius=5;
        this.arrowType=ArrowType.ICE;

        System.out.println("A new Ice Arrow has been crafted!\n");
    }
}
