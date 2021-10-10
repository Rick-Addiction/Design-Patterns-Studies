package equipmentenchantment;


import equipmentenchantment.equipment.elfequipment.bow.WingedBow;
import equipmentenchantment.equipment.elfequipment.garb.ExecutionerGarb;
import equipmentenchantment.equipment.enchantment.CorruptedMindEnchantment;
import equipmentenchantment.equipment.enchantment.FuryEnchantment;
import equipmentenchantment.equipment.enchantment.SigilEnchantment;
import equipmentenchantment.equipment.knightequipment.armor.MercenaryArmor;
import equipmentenchantment.equipment.knightequipment.sword.EmperorBladeSword;
import equipmentenchantment.warrior.HairColor;
import equipmentenchantment.warrior.elf.ElfBuilder;
import equipmentenchantment.warrior.knight.KnightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        var knight = new KnightBuilder()
                .withName("HENRIQUE")
                .withHairColor(HairColor.BLONDE)
                .withArmor(new MercenaryArmor())
                .withSword(new EmperorBladeSword())
                .build();

        logger.info("{}", knight);

        knight.handleWeapon().executeAttack();
        knight.handleWeapon().addEnchantmentToSocket(new CorruptedMindEnchantment());
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().deactivateCurrentEnchantment();
        knight.handleWeapon().addEnchantmentToSocket(new FuryEnchantment());
        knight.handleWeapon().removeEnchantment();
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().nextEnchantment();
        knight.handleWeapon().addEnchantmentToSocket(new SigilEnchantment());
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().activateCurrentEnchantment();
        knight.handleWeapon().deactivateCurrentEnchantment();
        knight.handleWeapon().nextEnchantment();
        knight.handleWeapon().previousEnchantment();
        knight.handleWeapon().activateCurrentEnchantment();


        var elf = new ElfBuilder()
                .withName("ELLIE")
                .withHairColor(HairColor.REDHEAD)
                .withGarb(new ExecutionerGarb())
                .withBow(new WingedBow())
                .build();

        logger.info("\n\n{}", elf);

        elf.handleClothing().addEnchantmentToSocket(new SigilEnchantment());
        elf.handleClothing().activateCurrentEnchantment();
        elf.handleClothing().deactivateCurrentEnchantment();
        elf.handleClothing().addEnchantmentToSocket(new FuryEnchantment());
        elf.handleClothing().removeEnchantment();
        elf.handleClothing().nextEnchantment();
        elf.handleClothing().activateCurrentEnchantment();
        elf.handleClothing().deactivateCurrentEnchantment();
        elf.handleClothing().previousEnchantment();
        elf.handleClothing().activateCurrentEnchantment();
    }
}
