package craftingmaterialsmanagement.arrow;

public enum ArrowType {
    FIRE,
    ICE,
    SHOCK;

    public static ArrowType getArrowType(String name) {
        for(var arrowType : ArrowType.values() ){
            if(arrowType.name().equals(name.toUpperCase())){
                return arrowType;
            }
        }
        return null;
    }
}
