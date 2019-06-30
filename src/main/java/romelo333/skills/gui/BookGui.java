package romelo333.skills.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import romelo333.skills.Skills;

/**
 * Created by ruben on 8/07/2018.
 */
public class BookGui extends GuiScreen {
    private static final int WIDTH = 256;
    private static final int HEIGHT = 160;

    private int guiLeft;
    private int guiTop;

    @Override
    public void initGui() {
        super.initGui();
        guiLeft = (this.width - WIDTH) / 2;
        guiTop = (this.height - HEIGHT) / 2;
    }

    private static final ResourceLocation background = new ResourceLocation(Skills.MODID, "textures/gui/book.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, WIDTH, HEIGHT);
    }

}
