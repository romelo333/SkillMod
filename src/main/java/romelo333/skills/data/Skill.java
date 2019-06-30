package romelo333.skills.data;

import net.minecraft.util.ResourceLocation;

public abstract class Skill {
    private final ResourceLocation id;
    private final String name;

    public Skill(ResourceLocation id, String name) {
        this.id = id;
        this.name = name;
    }

    public ResourceLocation getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int calculateLevel(int xp, int difficulty){
        return (int)Math.sqrt(xp)/(2*difficulty);
    }

    public abstract int calculateLevel(int xp);
}
