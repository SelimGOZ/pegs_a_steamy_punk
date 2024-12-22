package io.thecheese.pastp.init;

import io.thecheese.pastp.custom.MushiHatItem;
import io.thecheese.pastp.custom.SteampunkHatItem;
import io.thecheese.pastp.custom.MushroomHatItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "pegs_a_steamy_punk");

    public static final RegistryObject<Item> MUSHI_HAT = CreativeTabInit.addToTab(ITEMS.register("mushi_hat",
            () -> new MushiHatItem(new Item.Properties().stacksTo(1))));

    public static final RegistryObject<Item> STEAMPUNK_HAT = CreativeTabInit.addToTab(ITEMS.register("steampunk_hat",
            () -> new SteampunkHatItem(new Item.Properties().stacksTo(1))));

    public static final RegistryObject<Item> MUSHROOM_HAT = CreativeTabInit.addToTab(ITEMS.register("mushroom_hat",
            () -> new MushroomHatItem(new Item.Properties().stacksTo(1))));
}

