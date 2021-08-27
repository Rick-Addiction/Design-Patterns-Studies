package craftingmaterialsmanagement.arrowcrafter;

public class RequiredMaterials {
    public RequiredMaterials(int wood, int magicEssence, int stone, int cloth) {
        this.wood = wood;
        this.magicEssence = magicEssence;
        this.stone = stone;
        this.cloth = cloth;
    }

    private int wood;
    private int magicEssence;
    private int stone;
    private int cloth;

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
}
