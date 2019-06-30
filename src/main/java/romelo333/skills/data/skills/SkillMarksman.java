package romelo333.skills.data.skills;

import romelo333.skills.data.Skill;

import static romelo333.skills.proxy.CommonProxy.MARKSMAN;

public class SkillMarksman extends Skill{
    public SkillMarksman() {
        super(MARKSMAN, "Marksman");
    }

    @Override
    public int calculateLevel(int xp) {
        return super.calculateLevel(xp, 10);
    }
}
