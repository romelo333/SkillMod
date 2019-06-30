package romelo333.skills;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import romelo333.skills.data.SkillRegistry;
import romelo333.skills.items.ModItems;
import romelo333.skills.proxy.CommonProxy;

@Mod(modid = Skills.MODID, name = Skills.NAME, version = Skills.VERSION)
public class Skills {
    public static final String MODID = "skilled";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    public static Logger logger;
    public SkillRegistry registry = new SkillRegistry();

    public static CreativeTabs creativeTabs = new CreativeTabs("skills") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.book);
        }
    };

    @Mod.Instance
    public static Skills instance;

    @SidedProxy(clientSide = "romelo333.skills.proxy.ClientProxy", serverSide = "romelo333.skills.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
