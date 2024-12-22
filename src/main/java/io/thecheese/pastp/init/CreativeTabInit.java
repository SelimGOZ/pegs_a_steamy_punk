package io.thecheese.pastp.init;

import io.thecheese.pastp.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> PASTP = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final List<Supplier<? extends ItemLike>> PASTP_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> PASTP_TAB = PASTP.register("pastp",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pastp"))
                    .icon(ModItems.STEAMPUNK_HAT.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            PASTP_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        PASTP_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}