package romelo333.skills.data.skills;

import romelo333.skills.data.Skill;

import static romelo333.skills.proxy.CommonProxy.ARMOR;

public class SkillArmor extends Skill{
    public SkillArmor() {
        super(ARMOR, "Armor");
    }

    @Override
    public int calculateLevel(int xp) {
        return super.calculateLevel(xp, 10);
    }
}
