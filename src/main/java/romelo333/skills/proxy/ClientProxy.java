package romelo333.skills.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import romelo333.skills.data.PlayerSkills;
import romelo333.skills.data.SkillManager;
import romelo333.skills.items.ModItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModItems.initModels();
    }

    @SubscribeEvent
    public static void renderXp(RenderGameOverlayEvent event){
        if (event.getType() == RenderGameOverlayEvent.ElementType.EXPERIENCE){
            Minecraft minecraft = Minecraft.getMinecraft();
            PlayerSkills skills = SkillManager.get(minecraft.player);
            minecraft.fontRenderer.drawString("OH: "+skills.get(CommonProxy.ONEHANDED).getXp(),10,10,0xffffffff,false);
            minecraft.fontRenderer.drawString("AR: "+skills.get(CommonProxy.ARMOR).getXp(),10,20,0xffffffff,false);
            minecraft.fontRenderer.drawString("AT: "+skills.get(CommonProxy.ATHLETICS).getXp(),10,30,0xffffffff,false);
            minecraft.fontRenderer.drawString("RE: "+skills.get(CommonProxy.RESISTANCE).getXp(),10,40,0xffffffff,false);
            minecraft.fontRenderer.drawString("BL: "+skills.get(CommonProxy.BLOCKING).getXp(),10,50,0xffffffff,false);
            minecraft.fontRenderer.drawString("MA: "+skills.get(CommonProxy.MARKSMAN).getXp(),10,60,0xffffffff,false);

        }
    }
}