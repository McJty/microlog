package mcjty.microlog.blocks;

import mcjty.lib.container.GenericBlock;
import mcjty.lib.container.GenericItemBlock;
import mcjty.microlog.MicroLogistics;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBundle extends GenericBlock {

    public BlockBundle() {
        super(MicroLogistics.instance, Material.IRON, TileBundle.class, null, GenericItemBlock.class, "bundle", false);
        setHardness(1.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(MicroLogistics.tabMicroLog);
    }

    @Override
    public int getGuiID() {
        return -1;
    }
}
