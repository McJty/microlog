package mcjty.microlog.blocks;

import mcjty.lib.container.GenericBlock;
import mcjty.microlog.MicroLogistics;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBundle extends GenericBlock {

    public BlockBundle() {
        super(MicroLogistics.instance, Material.IRON, TileBundle.class, null, ItemBundle.class, "bundle", false);
        setHardness(1.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(MicroLogistics.tabMicroLog);
    }

    public static final AxisAlignedBB HALF_BLOCK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);


    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return HALF_BLOCK_AABB;
    }

    @Override
    public boolean hasNoRotation() {
        return true;
    }

    @Override
    public int getGuiID() {
        return -1;
    }
}
