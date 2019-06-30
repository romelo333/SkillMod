package romelo333.skills.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ruben on 8/07/2018.
 */
public class ModItems {
    @GameRegistry.ObjectHolder("skilled:book")
    public static Book book;

    public static void initModels(){
        book.initModel();
    }
}
