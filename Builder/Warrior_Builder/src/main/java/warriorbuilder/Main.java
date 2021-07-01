package warriorbuilder;

import warriorbuilder.warrior.HairColor;
import warriorbuilder.warrior.elf.Bow;
import warriorbuilder.warrior.elf.ElfBuilder;
import warriorbuilder.warrior.elf.Garb;
import warriorbuilder.warrior.knight.Armor;
import warriorbuilder.warrior.knight.KnightBuilder;
import warriorbuilder.warrior.knight.Sword;
import warriorbuilder.warrior.sorcerer.Robe;
import warriorbuilder.warrior.sorcerer.SorcererBuilder;
import warriorbuilder.warrior.sorcerer.Staff;

public class Main {

    public static void main(String[] args)
    {
        KnightBuilder kb = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA);

        System.out.println(kb.build());

        ElfBuilder eb = new ElfBuilder()
                .withName("ELLIE")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(Garb.EXECUTIONER)
                .withBow(Bow.WINGED);

        System.out.println(eb.build());

        SorcererBuilder sb = new SorcererBuilder()
                .withName("JONAS")
                .withHairColor(HairColor.BRUNETTE)
                .withRobe(Robe.VELVET_RENAISSANCE)
                .withStaff(Staff.INCINERATION);

        System.out.println(sb.build());

    }

}
