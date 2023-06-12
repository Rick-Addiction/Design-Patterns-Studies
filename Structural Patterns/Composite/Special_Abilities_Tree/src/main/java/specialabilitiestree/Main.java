package specialabilitiestree;


import specialabilitiestree.warrior.HairColor;
import specialabilitiestree.warrior.elf.Bow;
import specialabilitiestree.warrior.elf.ElfBuilder;
import specialabilitiestree.warrior.elf.Garb;
import specialabilitiestree.warrior.elf.specialabilityhandler.ElfSpecialAbility;
import specialabilitiestree.warrior.knight.Armor;
import specialabilitiestree.warrior.knight.KnightBuilder;
import specialabilitiestree.warrior.knight.Sword;
import specialabilitiestree.warrior.knight.specialabilityhandler.KnightSpecialAbility;
import specialabilitiestree.warrior.sorcerer.Robe;
import specialabilitiestree.warrior.sorcerer.SorcererBuilder;
import specialabilitiestree.warrior.sorcerer.Staff;
import specialabilitiestree.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility;

public class Main {

    public static void main(String[] args)
    {
        var sorcerer = new SorcererBuilder()
                .withName("JONAS")
                .withHairColor(HairColor.BRUNETTE)
                .withRobe(Robe.VELVET_RENAISSANCE)
                .withStaff(Staff.INCINERATION).build();

        System.out.println(sorcerer);
        sorcerer.acquireSpecialAbility(SorcererSpecialAbility.TELEKINESIS);
        sorcerer.displaySpecialAbilities();



        sorcerer.useAbility(SorcererSpecialAbility.TELEKINESIS,"Container");

        sorcerer.useAbility(SorcererSpecialAbility.SHIELDING,"William");
        sorcerer.useAbility(SorcererSpecialAbility.HEALING,"William", "Jeff", "Camilla");

        var knight = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA).build();

        System.out.println(knight);

        knight.displaySpecialAbilities();

        knight.useAbility(KnightSpecialAbility.BERSERK);
        knight.useAbility(KnightSpecialAbility.CYCLONE,"Garry", "Thomas");
        knight.useAbility(KnightSpecialAbility.VERTICAL_STRIKE, "Garry", "Thomas");

        var elf = new ElfBuilder()
                .withName("Stephan")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(Garb.HUNTER)
                .withBow(Bow.RAIDER).build();

        System.out.println(elf);

        elf.displaySpecialAbilities();

        elf.useAbility(ElfSpecialAbility.AGILITY);
        elf.useAbility(ElfSpecialAbility.CONCENTRATION,"Garry", "Thomas");
        elf.useAbility(ElfSpecialAbility.POSSESSION, "Rick");

    }

}
