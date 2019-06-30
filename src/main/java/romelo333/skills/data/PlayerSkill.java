package romelo333.skills.data;

import net.minecraft.util.ResourceLocation;

public class PlayerSkill {
    private final ResourceLocation id;
    private int xp;

    public PlayerSkill(ResourceLocation id) {
        this.id = id;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
