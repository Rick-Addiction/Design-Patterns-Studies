package craftingmaterialsmanagement.arrowcrafter;

import craftingmaterialsmanagement.CraftingMaterialsAvailable;
import craftingmaterialsmanagement.arrow.Arrow;
import craftingmaterialsmanagement.arrow.ArrowType;
import org.reflections.Reflections;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class ArrowCrafter {

    private ArrowCrafter(){

    }

    private static final String TOP_CLASS_NAME =  "craftingmaterialsmanagement.arrow";

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
        var requiredMaterials = MaterialsRequiredToCraft.getInstance().getRequiredMaterials(arrowType);
        var availableMaterials = CraftingMaterialsAvailable.getInstance();

        if(isMaterialsEnough(requiredMaterials, availableMaterials)){
            System.out.println("A new "+ arrowType.name() + " arrow started to be crafted!");
            useMaterials(requiredMaterials, availableMaterials);
            return craftableArrows.get(arrowType).getDeclaredConstructor().newInstance();
        }
        else{
            System.out.println("You don't have materials enough to craft a "+ arrowType.name() + " arrow\n");
            return null;
        }
    }

    private static boolean isMaterialsEnough(
            RequiredMaterials requiredMaterials,
            CraftingMaterialsAvailable availableMaterials){

        return availableMaterials.getWood() > requiredMaterials.getWood() &&
                availableMaterials.getCloth() > requiredMaterials.getCloth() &&
                availableMaterials.getMagicEssence() > requiredMaterials.getMagicEssence() &&
                availableMaterials.getStone() > requiredMaterials.getStone();
    }

    private static void useMaterials(
            RequiredMaterials requiredMaterials,
            CraftingMaterialsAvailable availableMaterials){
        if(requiredMaterials.getCloth()> 0) availableMaterials.removeCloth(requiredMaterials.getCloth());
        if(requiredMaterials.getMagicEssence()> 0)availableMaterials.removeMagicEssence(requiredMaterials.getMagicEssence());
        if(requiredMaterials.getStone()> 0)availableMaterials.removeStone(requiredMaterials.getStone());
        if(requiredMaterials.getWood()> 0)availableMaterials.removeWood(requiredMaterials.getWood());
    }


}
