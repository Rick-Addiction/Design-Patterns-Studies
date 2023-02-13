package warriorspawner;


import warriorspawner.warrior.HairColor;
import warriorspawner.warrior.elf.Bow;
import warriorspawner.warrior.elf.ElfConcreteSpawner;
import warriorspawner.warrior.elf.Garb;
import warriorspawner.warrior.knight.Armor;
import warriorspawner.warrior.knight.KnightConcreteSpawner;
import warriorspawner.warrior.knight.Sword;
import warriorspawner.warrior.sorcerer.Robe;
import warriorspawner.warrior.sorcerer.SorcererConcreteSpawner;
import warriorspawner.warrior.sorcerer.Staff;

public class Main {

    public static void main(String[] args)
    {
        // Creating a Knight warrior
        KnightConcreteSpawner kb = new KnightConcreteSpawner()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA);

        System.out.println(kb.build());

        // Creating an Elf warrior
        ElfConcreteSpawner eb = new ElfConcreteSpawner()
                .withName("ELLIE")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(Garb.EXECUTIONER)
                .withBow(Bow.WINGED);

        System.out.println(eb.build());

        // Creating a Sorcerer warrior
        SorcererConcreteSpawner sb = new SorcererConcreteSpawner()
                .withName("JONAS")
                .withHairColor(HairColor.BRUNETTE)
                .withRobe(Robe.VELVET_RENAISSANCE)
                .withStaff(Staff.INCINERATION);

        System.out.println(sb.build());


    }

}
