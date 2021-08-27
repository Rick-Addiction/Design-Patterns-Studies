package blacksmithforge;

import blacksmithforge.blacksmith.Blacksmith;
import blacksmithforge.blacksmith.CorruptionBlacksmith;
import org.javatuples.Triplet;

public class Main
{
    public static void main(String[] args) {

        Blacksmith corruptionBlacksmith = new CorruptionBlacksmith();

        var knightForgedEquipments = new Triplet<>(
                corruptionBlacksmith.forgeSword(),
                corruptionBlacksmith.forgeArmor(),
                corruptionBlacksmith.forgeShield());

        knightForgedEquipments.getValue0().describeEquipment();
        knightForgedEquipments.getValue1().describeEquipment();
        knightForgedEquipments.getValue2().describeEquipment();



    }
}
