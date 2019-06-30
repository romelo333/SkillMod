package romelo333.skills.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import romelo333.skills.ForgeEventHandlers;
import romelo333.skills.Skills;
import romelo333.skills.data.skills.*;
import romelo333.skills.items.Book;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static final ResourceLocation ONEHANDED = new ResourceLocation(Skills.MODID, "Onehanded");
    public static final ResourceLocation MARKSMAN = new ResourceLocation(Skills.MODID, "Marksman");
    public static final ResourceLocation RESISTANCE = new ResourceLocation(Skills.MODID, "Resistance");
    public static final ResourceLocation BLOCKING = new ResourceLocation(Skills.MODID, "Blocking");
    public static final ResourceLocation ARMOR = new ResourceLocation(Skills.MODID, "Armor");
    public static final ResourceLocation ATHLETICS = new ResourceLocation(Skills.MODID, "Athletics");

    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ForgeEventHandlers());
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Skills.instance, new GuiProxy());

        Skills.instance.registry.register(new SkillOneHanded());
        Skills.instance.registry.register(new SkillMarksman());
        Skills.instance.registry.register(new SkillResistance());
        Skills.instance.registry.register(new SkillBlocking());
        Skills.instance.registry.register(new SkillArmor());
        Skills.instance.registry.register(new SkillAthletics());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Book());
    }


}