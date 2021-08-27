package craftingmaterialsmanagement.arrow;

public abstract class Arrow
{
    ArrowType arrowType;
    Integer damage;
    Integer pierce;
    Integer radius;

    public void shoot(){
        System.out.println("You shot your enemy with the "+arrowType+ " arrow,"+
                " making damage of "+damage+" points,"+
                " in a radius of "+radius+" meters,"+
                " and with "+pierce+"% capacity of piercing the opponent aimed ");
    }
}
