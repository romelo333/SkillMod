package romelo333.skills.data;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class SkillRegistry {
    private final Map<ResourceLocation, Skill> skills = new HashMap<>();

    public void register(Skill skill){
        skills.put(skill.getId(),skill);
    }

    public Skill get(ResourceLocation id){
        return skills.get(id);
    }
}
