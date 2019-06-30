package romelo333.skills.data.skills;

import romelo333.skills.data.Skill;

import static romelo333.skills.proxy.CommonProxy.BLOCKING;

public class SkillBlocking extends Skill{
    public SkillBlocking() {
        super(BLOCKING, "Blocking");
    }

    @Override
    public int calculateLevel(int xp) {
        return super.calculateLevel(xp, 10);
    }
}
