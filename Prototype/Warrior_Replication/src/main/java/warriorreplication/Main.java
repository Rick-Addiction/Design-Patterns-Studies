package warriorreplication;

import warriorreplication.warrior.HairColor;
import warriorreplication.warrior.elf.Bow;
import warriorreplication.warrior.elf.ElfBuilder;
import warriorreplication.warrior.elf.Garb;
import warriorreplication.warrior.knight.Armor;
import warriorreplication.warrior.knight.KnightBuilder;
import warriorreplication.warrior.knight.Sword;
import warriorreplication.warrior.sorcerer.Robe;
import warriorreplication.warrior.sorcerer.SorcererBuilder;
import warriorreplication.warrior.sorcerer.Staff;

public class Main {

    public static void main(String[] args)
    {
        var newWarrior = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA).build();

        System.out.println(newWarrior);

        var replicatedWarrior = newWarrior.replicate("LEONARD");

        System.out.println(replicatedWarrior);


    }

}
