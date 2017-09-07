package mcjty.microlog;


import mcjty.lib.base.ModBase;
import mcjty.microlog.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = MicroLogistics.MODID, name = MicroLogistics.MODNAME,
        dependencies =
                        "required-after:mcjtylib_ng@[" + MicroLogistics.MIN_MCJTYLIB_VER + ",);" +
                        "after:rftools@[" + MicroLogistics.MIN_RFTOOLS_VER + ",);" +
                        "after:forge@[" + MicroLogistics.MIN_FORGE11_VER + ",)",
        acceptedMinecraftVersions = "[1.12,1.13)",
        version = MicroLogistics.MODVERSION)
public class MicroLogistics implements ModBase {

    public static final String MODID = "micrologistics";
    public static final String MODNAME = "MicroLogistics";
    public static final String MODVERSION = "0.0.1";

    public static final String MIN_FORGE11_VER = "13.19.0.2176";
    public static final String MIN_MCJTYLIB_VER = "2.4.1";
    public static final String MIN_RFTOOLS_VER = "6.10";

    public static final String SHIFT_MESSAGE = "<Press Shift>";

    @SidedProxy(clientSide = "mcjty.microlog.proxy.ClientProxy", serverSide = "mcjty.microlog.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static MicroLogistics instance;
    public static Logger logger;

    public static boolean rftools = false;
    public static boolean redstoneflux = false;

    public static CreativeTabs tabMicroLog = new CreativeTabs("micrologistics") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Blocks.ANVIL));
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        rftools = Loader.isModLoaded("rftools");
        redstoneflux = Loader.isModLoaded("redstoneflux");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent event) {
//        XNetBlobData.clearInstance();
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
//        event.registerServerCommand(new CommandDump());
    }

    public String getModId() {
        return MODID;
    }

    @Override
    public void openManual(EntityPlayer player, int bookIndex, String page) {
//        GuiXNetManual.locatePage = page;
//        player.openGui(XNet.instance, bookIndex, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
    }

//    @Mod.EventHandler
//    public void imcCallback(FMLInterModComms.IMCEvent event) {
//        for (FMLInterModComms.IMCMessage message : event.getMessages()) {
//            if (message.key.equalsIgnoreCase("getXNet")) {
//                Optional<Function<IXNet, Void>> value = message.getFunctionValue(IXNet.class, Void.class);
//                if (value.isPresent()) {
//                    value.get().apply(xNetApi);
//                } else {
//                    logger.warn("Some mod didn't return a valid result with getXNet!");
//                }
//            }
//        }
//    }

}
