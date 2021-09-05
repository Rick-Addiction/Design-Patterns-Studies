package warriorspecialability;


import warriorspecialability.warrior.HairColor;
import warriorspecialability.warrior.elf.Bow;
import warriorspecialability.warrior.elf.ElfBuilder;
import warriorspecialability.warrior.elf.Garb;
import warriorspecialability.warrior.elf.specialabilityhandler.ElfSpecialAbility;
import warriorspecialability.warrior.knight.Armor;
import warriorspecialability.warrior.knight.KnightBuilder;
import warriorspecialability.warrior.knight.Sword;
import warriorspecialability.warrior.knight.specialabilityhandler.KnightSpecialAbility;
import warriorspecialability.warrior.sorcerer.Robe;
import warriorspecialability.warrior.sorcerer.SorcererBuilder;
import warriorspecialability.warrior.sorcerer.Staff;
import warriorspecialability.warrior.sorcerer.specialabilityhandler.SorcererSpecialAbility;

public class Main {

    public static void main(String[] args)
    {
        var sorcerer = new SorcererBuilder()
                .withName("JONAS")
                .withHairColor(HairColor.BRUNETTE)
                .withRobe(Robe.VELVET_RENAISSANCE)
                .withStaff(Staff.INCINERATION).build();

        System.out.println(sorcerer);

        sorcerer.useAbility(SorcererSpecialAbility.TELEKINESIS,"Container");
        sorcerer.useAbility(SorcererSpecialAbility.SHIELDING,"William");
        sorcerer.useAbility(SorcererSpecialAbility.HEALING,"William", "Jeff", "Camilla");

        var knight = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA).build();

        System.out.println(knight);

        knight.useAbility(KnightSpecialAbility.BERSERK);
        knight.useAbility(KnightSpecialAbility.CYCLONE,"Garry", "Thomas");
        knight.useAbility(KnightSpecialAbility.VERTICAL_STRIKE, "Garry", "Thomas");

        var elf = new ElfBuilder()
                .withName("Stephan")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(Garb.HUNTER)
                .withBow(Bow.RAIDER).build();

        System.out.println(elf);

        elf.useAbility(ElfSpecialAbility.AGILITY);
        elf.useAbility(ElfSpecialAbility.CONCENTRATION,"Garry", "Thomas");
        elf.useAbility(ElfSpecialAbility.POSSESSION, "Rick");

    }

}
