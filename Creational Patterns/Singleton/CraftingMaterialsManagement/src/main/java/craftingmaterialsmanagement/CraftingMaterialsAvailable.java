package craftingmaterialsmanagement;

public class CraftingMaterialsAvailable {
    private static final CraftingMaterialsAvailable INSTANCE = new CraftingMaterialsAvailable();

    int wood;
    int magicEssence;
    int stone;
    int cloth;

    public CraftingMaterialsAvailable(){
        this.wood=3;
        this.magicEssence=3;
        this.stone=3;
        this.cloth=3;
    }

    public static CraftingMaterialsAvailable getInstance()
    {
        return INSTANCE;
    }

    public void addWood(int acquiredWood){
        this.wood+=acquiredWood;
    }

    public void removeWood(int usedWood){
        this.wood-=usedWood;
        System.out.println("*** "+usedWood +" wood has been used ***");
    }

    public void addMagicEssence(int acquiredMagicEssence){
        this.magicEssence+=acquiredMagicEssence;
    }

    public void removeMagicEssence(int usedMagicEssence){
        this.magicEssence-=usedMagicEssence;
        System.out.println("*** "+usedMagicEssence +" magicEssence has been used ***");
    }

    public void addStone(int acquiredStone){
        this.stone+=acquiredStone;
    }

    public void removeStone(int usedStone){
        this.stone-=usedStone;
        System.out.println("*** "+usedStone +" stone has been used ***");
    }

    public void addCloth(int acquiredCloth){
        this.cloth+=acquiredCloth;
    }

    public void removeCloth(int usedCloth){
        this.cloth-=usedCloth;
        System.out.println("*** "+usedCloth +" cloth has been used ***");
    }

    public int getWood() {
        return wood;
    }

    public int getMagicEssence() {
        return magicEssence;
    }

    public int getStone() {
        return stone;
    }

    public int getCloth() {
        return cloth;
    }

    public void showStatus(){
        System.out.println(
                "###CRAFTING MATERIALS AVAILABLE###"+"\n"+
                "Wood: " + wood+"\n"+
                "Stone: "+ stone+"\n"+
                "Magic Essence: "+ magicEssence+"\n"+
                "Cloth: "+ cloth+"\n"
        );


    }
}
