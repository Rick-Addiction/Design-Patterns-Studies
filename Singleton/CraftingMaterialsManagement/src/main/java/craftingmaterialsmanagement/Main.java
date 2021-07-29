package craftingmaterialsmanagement;

import craftingmaterialsmanagement.arrow.Arrow;
import craftingmaterialsmanagement.arrow.ArrowType;
import craftingmaterialsmanagement.arrowcrafter.ArrowCrafter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Arrow> arrowsCrafted = new ArrayList<>();
        var availableMaterials = CraftingMaterialsAvailable.getInstance();

        availableMaterials.showStatus();
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.FIRE));
        availableMaterials.showStatus();
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.ICE));
        availableMaterials.showStatus();
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.SHOCK));
        availableMaterials.showStatus();

    }
}
