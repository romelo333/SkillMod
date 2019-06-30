package romelo333.skills.data.skills;

import romelo333.skills.data.Skill;

import static romelo333.skills.proxy.CommonProxy.RESISTANCE;

public class SkillResistance extends Skill{
    public SkillResistance() {
        super(RESISTANCE, "Resistance");
    }

    @Override
    public int calculateLevel(int xp) {
        return super.calculateLevel(xp, 10);
    }
}
