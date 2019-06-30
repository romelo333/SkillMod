package romelo333.skills.data;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class PlayerSkills {
    private final Map<ResourceLocation, PlayerSkill> skills = new HashMap<>();
    public PlayerSkill get(ResourceLocation id){
        if (!skills.containsKey(id)){
            skills.put(id, new PlayerSkill(id));
        }
        return skills.get(id);
    }
}

