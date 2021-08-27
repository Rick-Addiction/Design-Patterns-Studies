package arrowcrafting.arrowcrafter;

import arrowcrafting.arrow.Arrow;
import arrowcrafting.arrow.ArrowType;
import org.reflections.Reflections;


import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class ArrowCrafter {

    private ArrowCrafter(){

    }

    private static final String TOP_CLASS_NAME =  "arrowcrafting.arrow";

    private static final Map<ArrowType, Class<? extends Arrow>> craftableArrows = new EnumMap<>(ArrowType.class);

    static{
        Set<Class<? extends Arrow>> types =
                new Reflections(TOP_CLASS_NAME).getSubTypesOf(Arrow.class);

        for (Class<? extends Arrow> type : types)
        {
            craftableArrows.put(
                    ArrowType.getArrowType(type.getSimpleName().replace("Arrow", "")),
                    type
            );
        }
    }

    public static Arrow craftArrow(ArrowType arrowType) throws Exception {
        return craftableArrows.get(arrowType).getDeclaredConstructor().newInstance();
    }


}
