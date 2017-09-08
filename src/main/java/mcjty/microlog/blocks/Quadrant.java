package mcjty.microlog.blocks;

import mcmultipart.api.slot.EnumCornerSlot;
import net.minecraft.util.IStringSerializable;

public enum Quadrant implements IStringSerializable {
    NNN("nnn", EnumCornerSlot.CORNER_NNN),
    NNP("nnp", EnumCornerSlot.CORNER_NNP),
    NPN("npn", EnumCornerSlot.CORNER_NPN),
    NPP("npp", EnumCornerSlot.CORNER_NPP),
    PNN("pnn", EnumCornerSlot.CORNER_PNN),
    PNP("pnp", EnumCornerSlot.CORNER_PNP),
    PPN("ppn", EnumCornerSlot.CORNER_PPN),
    PPP("ppp", EnumCornerSlot.CORNER_PPP);

    private final String name;
    private final EnumCornerSlot slot;

    Quadrant(String name, EnumCornerSlot slot) {
        this.name = name;
        this.slot = slot;
    }

    public EnumCornerSlot getSlot() {
        return slot;
    }

    @Override
    public String getName() {
        return name;
    }
}
