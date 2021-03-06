package mcjty.microlog.mcmp;

import mcjty.microlog.blocks.BlockBundle;
import mcjty.microlog.blocks.ModBlocks;
import mcmultipart.api.multipart.IMultipart;
import mcmultipart.api.multipart.IMultipartTile;
import mcmultipart.api.slot.IPartSlot;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BundleMultiPart implements IMultipart {

    @Override
    public Block getBlock() {
        return ModBlocks.blockBundle;
    }

    @Override
    public IMultipartTile convertToMultipartTile(TileEntity tileEntity) {
        return IMultipartTile.wrap(tileEntity);
    }

    @Override
    public IPartSlot getSlotForPlacement(World world, BlockPos pos, IBlockState state, EnumFacing facing, float hitX, float hitY, float hitZ, EntityLivingBase placer) {
        return state.getValue(BlockBundle.QUADRANT).getSlot();
    }

    @Override
    public IPartSlot getSlotFromWorld(IBlockAccess world, BlockPos pos, IBlockState state) {
        return state.getValue(BlockBundle.QUADRANT).getSlot();
    }
}
