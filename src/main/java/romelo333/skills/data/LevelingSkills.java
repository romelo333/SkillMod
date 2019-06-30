package romelo333.skills.data;

public class LevelingSkills {

    public int experienceLevel;
    public int experienceTotal;
    /**
     * The current amount of experience the player has within their Experience Bar.
     */
    public float experience;

    public void addExperience(int amount) {
        int i = Integer.MAX_VALUE - this.experienceTotal;

        if (amount > i) {
            amount = i;
        }

        this.experience += (float) amount / (float) this.xpBarCap();

        for (this.experienceTotal += amount; this.experience >= 1.0F; this.experience /= (float) this.xpBarCap()) {
            this.experience = (this.experience - 1.0F) * (float) this.xpBarCap();
            this.addExperienceLevel(1);
        }
    }

    /**
     * Add experience levels to this player.
     */
    public void addExperienceLevel(int levels) {
        this.experienceLevel += levels;

        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experience = 0.0F;
            this.experienceTotal = 0;
        }
    }

    /**
     * This method returns the cap amount of experience that the experience bar can hold. With each level, the
     * experience cap on the player's experience bar is raised by 10.
     */
    public int xpBarCap() {
        if (this.experienceLevel >= 30) {
            return 112 + (this.experienceLevel - 30) * 9;
        } else {
            return this.experienceLevel >= 15 ? 37 + (this.experienceLevel - 15) * 5 : 7 + this.experienceLevel * 2;
        }
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints() {
        int i = this.experienceLevel * 7;
        return i > 100 ? 100 : i;

    }
}
