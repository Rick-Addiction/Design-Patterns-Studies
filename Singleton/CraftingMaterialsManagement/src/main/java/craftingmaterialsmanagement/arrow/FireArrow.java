package craftingmaterialsmanagement.arrow;

public class FireArrow extends Arrow {

    public FireArrow(){
        this.damage = 50;
        this.pierce = 13;
        this.radius=25;
        this.arrowType=ArrowType.FIRE;

        System.out.println("A new Fire Arrow has been crafted!\n");
    }
}
