package io.thecheese.pastp;

import io.thecheese.pastp.init.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerEquipsItemInOffHand {
    @SubscribeEvent
    public static void LivingEquipmentChangeEvent(LivingEquipmentChangeEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity(), event.getSlot(), event.getTo(), event.getFrom());
        }
    }

    public static void execute(Entity entity, EquipmentSlot slot, ItemStack itemTo, ItemStack itemFrom) {
        execute(null, entity, slot, itemTo, itemFrom);
    }

    private static void execute(@Nullable Event event, Entity entity, EquipmentSlot slot, ItemStack itemTo, ItemStack itemFrom) {
        if (entity == null)
            return;
        if (entity instanceof Player player) {



            if (slot.isArmor() && itemTo == ModItems.MUSHROOM_HAT && itemFrom != ItemStacks.AIR) {
                boolean added = player.getInventory().add(itemFrom);

                if (!added && !player.level().isClientSide) {
                    player.drop(itemFrom, false);
                }
            }
        }
    }
}