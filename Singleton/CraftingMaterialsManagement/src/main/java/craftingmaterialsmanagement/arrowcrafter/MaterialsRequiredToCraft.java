package craftingmaterialsmanagement.arrowcrafter;

import com.google.common.collect.Iterables;
import craftingmaterialsmanagement.arrow.ArrowType;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MaterialsRequiredToCraft {

    private Dictionary<ArrowType, RequiredMaterials> craftableArrows = new Hashtable<>();

    private static final MaterialsRequiredToCraft INSTANCE = new MaterialsRequiredToCraft();

    private MaterialsRequiredToCraft()
    {
        try {
            Path fullPath = Paths.get("src","main","resources","craftablearrows.txt");
            List<String> lines = Files.readAllLines(fullPath);

            Iterables.partition(lines, 2)
                    .forEach(kv -> {
                        List<String> materials = Arrays.asList(kv.get(1).split(" "));
                        craftableArrows.put(
                                ArrowType.getArrowType(kv.get(0).trim()),
                                new RequiredMaterials(
                                        Integer.parseInt(materials.get(0)),
                                        Integer.parseInt(materials.get(1)),
                                        Integer.parseInt(materials.get(2)),
                                        Integer.parseInt(materials.get(3))
                                )
                        );
                    });
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public static MaterialsRequiredToCraft getInstance()
    {
        return INSTANCE;
    }

    public RequiredMaterials getRequiredMaterials(ArrowType arrowType)
    {
        return craftableArrows.get(arrowType);
    }

}
