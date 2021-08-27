package arrowcrafting;

import arrowcrafting.arrow.Arrow;
import arrowcrafting.arrow.ArrowType;
import arrowcrafting.arrowcrafter.ArrowCrafter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Arrow> arrowsCrafted = new ArrayList<>();

        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.FIRE));
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.ICE));
        arrowsCrafted.add(ArrowCrafter.craftArrow(ArrowType.SHOCK));

        arrowsCrafted.forEach(Arrow::shoot);
    }
}
