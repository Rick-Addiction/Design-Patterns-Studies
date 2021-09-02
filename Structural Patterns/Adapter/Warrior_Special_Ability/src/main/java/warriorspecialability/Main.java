package warriorspecialability;


import warriorspecialability.warrior.HairColor;
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
        var s = new SorcererBuilder()
                .withName("JONAS")
                .withHairColor(HairColor.BRUNETTE)
                .withRobe(Robe.VELVET_RENAISSANCE)
                .withStaff(Staff.INCINERATION).build();

        System.out.println(s);

        s.useAbility(SorcererSpecialAbility.TELEKINESIS);
        s.useAbility(SorcererSpecialAbility.SHIELDING);

        var k = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(Armor.MERCENARY)
                .withSword(Sword.KATANA).build();

        System.out.println(k);

        k.useAbility(KnightSpecialAbility.BERSERK);
        k.useAbility(KnightSpecialAbility.VERTICAL_STRIKE);


    }

}
