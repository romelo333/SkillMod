package romelo333.skills.data.skills;

import romelo333.skills.data.Skill;

import static romelo333.skills.proxy.CommonProxy.ATHLETICS;

public class SkillAthletics extends Skill{
    public SkillAthletics() {
        super(ATHLETICS, "Athletics");
    }

    @Override
    public int calculateLevel(int xp) {
        return super.calculateLevel(xp, 10);
    }
}
