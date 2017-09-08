package mcjty.microlog.blocks;

import mcjty.lib.container.GenericBlock;
import mcjty.microlog.MicroLogistics;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBundle extends GenericBlock {

    public static final PropertyEnum<Quadrant> QUADRANT = PropertyEnum.create("quadrant", Quadrant.class);


    public BlockBundle() {
        super(MicroLogistics.instance, Material.IRON, TileBundle.class, null, ItemBundle.class, "bundle", false);
        setHardness(1.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 0);
        setCreativeTab(MicroLogistics.tabMicroLog);

    }

    public static final AxisAlignedBB HALF_BLOCK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        Quadrant quadrant = Quadrant.NNN;
        if (facing == EnumFacing.DOWN) {
            if (hitX < .5f) {
                if (hitZ < .5f) {
                    quadrant = Quadrant.NNN;
                } else {
                    quadrant = Quadrant.NNP;
                }
            } else {
                if (hitZ < .5f) {
                    quadrant = Quadrant.PNN;
                } else {
                    quadrant = Quadrant.PNP;
                }
            }
        }
        return getDefaultState().withProperty(QUADRANT, quadrant);
    }

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

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(QUADRANT).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(QUADRANT, Quadrant.values()[meta]);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, QUADRANT);
    }

}
