package romelo333.skills.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import romelo333.skills.gui.BookGui;

public class GuiProxy implements IGuiHandler {

    public static int GUIBOOK = 1;

    @Override
    public Object getServerGuiElement(int guiid, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int guiid, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (guiid == GUIBOOK) {
            return new BookGui();
        } else {
            return null;
        }
    }
}
