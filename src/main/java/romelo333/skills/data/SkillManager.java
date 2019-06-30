package romelo333.skills.data;

import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillManager {
    private final static Map<UUID, PlayerSkills> playerskills = new HashMap<>();

    public static PlayerSkills get(EntityPlayer player){
        if (!playerskills.containsKey(player.getUniqueID())){
            playerskills.put(player.getUniqueID(), new PlayerSkills());
        }
        return playerskills.get(player.getUniqueID());
    }
}
