package mcjty.microlog.blocks;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static BlockBundle blockBundle;

    public static void init() {
        blockBundle = new BlockBundle();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockBundle.initModel();
    }

    @SideOnly(Side.CLIENT)
    public static void initItemModels() {
//        facadeBlock.initItemModel();
//        NetCableSetup.initItemModels();
    }
}
