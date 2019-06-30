package romelo333.skills.data.skills;

import romelo333.skills.data.Skill;

import static romelo333.skills.proxy.CommonProxy.ONEHANDED;

public class SkillOneHanded extends Skill{
    public SkillOneHanded() {
        super(ONEHANDED, "One-handed");
    }

    @Override
    public int calculateLevel(int xp) {
        return super.calculateLevel(xp, 10);
    }
}
