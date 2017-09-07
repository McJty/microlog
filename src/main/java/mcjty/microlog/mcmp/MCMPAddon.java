package mcjty.microlog.mcmp;

import mcjty.microlog.blocks.ModBlocks;
import mcmultipart.api.addon.IMCMPAddon;
import mcmultipart.api.multipart.IMultipartRegistry;
import net.minecraft.item.Item;

@mcmultipart.api.addon.MCMPAddon
public class MCMPAddon implements IMCMPAddon {

    @Override
    public void registerParts(IMultipartRegistry registry) {
        registry.registerPartWrapper(ModBlocks.blockBundle, new BundleMultiPart());
        registry.registerStackWrapper(Item.getItemFromBlock(ModBlocks.blockBundle), (s) -> true, ModBlocks.blockBundle);
    }
}
