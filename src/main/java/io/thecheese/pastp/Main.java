package io.thecheese.pastp;

import io.thecheese.pastp.init.ModItems;
import io.thecheese.pastp.init.CreativeTabInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("pegs_a_steamy_punk")
public class Main {

    public static final String MODID = "pegs_a_steamy_punk";

    public Main() {
        // Register the deferred registries
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CreativeTabInit.PASTP.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Register event handlers
        MinecraftForge.EVENT_BUS.register(MushroomItemOnHead.class);
        MinecraftForge.EVENT_BUS.register(SteampunkHatOnHead.class);
        MinecraftForge.EVENT_BUS.register(MushiItemOnHead.class);
    }
}
