package romelo333.skills;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import romelo333.skills.data.PlayerSkill;
import romelo333.skills.data.PlayerSkills;
import romelo333.skills.data.Skill;
import romelo333.skills.data.SkillManager;
import romelo333.skills.proxy.CommonProxy;

import java.util.Random;

public class ForgeEventHandlers {

    @SubscribeEvent
    public void handleTraining(LivingAttackEvent event){
        Entity source = event.getSource().getTrueSource();
        EntityLivingBase target = (EntityLivingBase)event.getEntity();
        if (source instanceof EntityPlayer){
            handleTrainingSource(event, source);
        }

        if (target instanceof EntityPlayer){
            handleTrainingTarget(event, target);
        }
    }

    private void addXp(PlayerSkill playerSkill, Skill skill, Entity entity, float amount){
        int xp = playerSkill.getXp();

        int oldLevel = skill.calculateLevel(xp);
        xp = (int) (xp + amount + 1);
        int newLevel = skill.calculateLevel(xp);

        playerSkill.setXp(xp);
        if (oldLevel != newLevel) {
            entity.sendMessage(new TextComponentString("You got " + skill.getName() + " to level " + newLevel));
        }
    }

    private void handleTrainingSource(LivingAttackEvent event, Entity source){
        PlayerSkills skills = SkillManager.get((EntityPlayer) source);
        if (event.getSource().isProjectile()){
            addXp(skills.get(CommonProxy.MARKSMAN), Skills.instance.registry.get(CommonProxy.MARKSMAN), source, event.getAmount());
        } else{
            addXp(skills.get(CommonProxy.ONEHANDED), Skills.instance.registry.get(CommonProxy.ONEHANDED), source, event.getAmount());
        }
    }

    private void handleTrainingTarget(LivingAttackEvent event, Entity target){
        PlayerSkills skills = SkillManager.get((EntityPlayer) target);
        addXp(skills.get(CommonProxy.RESISTANCE), Skills.instance.registry.get(CommonProxy.RESISTANCE), target, event.getAmount());
        if (((EntityPlayer) target).isActiveItemStackBlocking()){
            addXp(skills.get(CommonProxy.BLOCKING), Skills.instance.registry.get(CommonProxy.BLOCKING), target, event.getAmount());
        }
        if (((EntityPlayer) target).getTotalArmorValue() != 0){
            addXp(skills.get(CommonProxy.ARMOR), Skills.instance.registry.get(CommonProxy.ARMOR), target, event.getAmount());
        }
        if (target.isSprinting() || target.isInvisible() || target.isSneaking()){
            addXp(skills.get(CommonProxy.ATHLETICS), Skills.instance.registry.get(CommonProxy.ATHLETICS), target, event.getAmount());
        }
    }
    @SubscribeEvent
    public void handleDamage(LivingDamageEvent event){
        Entity source = event.getSource().getTrueSource();
        EntityLivingBase target = (EntityLivingBase)event.getEntity();
        if (source instanceof EntityPlayer){
            handleSource(event, source);
        }
        if (target instanceof EntityPlayer){
            handleTarget(event, target);
        }
    }
    private void handleSource(LivingDamageEvent event, Entity source){
        PlayerSkills skills = SkillManager.get((EntityPlayer) source);
        if (event.getSource().isProjectile()){
            int xp = skills.get(CommonProxy.MARKSMAN).getXp();
            int level = Skills.instance.registry.get(CommonProxy.MARKSMAN).calculateLevel(xp);
            event.setAmount(event.getAmount()+level/40.0f);
        } else{
            int xp = skills.get(CommonProxy.ONEHANDED).getXp();
            int level = Skills.instance.registry.get(CommonProxy.ONEHANDED).calculateLevel(xp);
            event.setAmount(event.getAmount()+level/50.0f);
        }
    }

    private Random random = new Random();

    private void handleTarget(LivingDamageEvent event, Entity target){
        PlayerSkills skills = SkillManager.get((EntityPlayer) target);

        if (target.isSprinting() || target.isInvisible() || target.isSneaking()){
            int xp = skills.get(CommonProxy.BLOCKING).getXp();
            int level = Skills.instance.registry.get(CommonProxy.BLOCKING).calculateLevel(xp);
            if (random.nextInt(100) < (level/21)+1){
                event.setCanceled(true);
                return;
            }
        }

        int xp = skills.get(CommonProxy.RESISTANCE).getXp();
        int level = Skills.instance.registry.get(CommonProxy.RESISTANCE).calculateLevel(xp);
        event.setAmount(event.getAmount()-level/50.0f);

        if (((EntityPlayer) target).isActiveItemStackBlocking()){
            xp = skills.get(CommonProxy.BLOCKING).getXp();
            level = Skills.instance.registry.get(CommonProxy.BLOCKING).calculateLevel(xp);
            event.setAmount(event.getAmount()-level/40.0f);
        }
    }
}