package io.thecheese.pastp.custom;

import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

public class MushiHatItem extends Item {
    public MushiHatItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);
            player.setItemSlot(net.minecraft.world.entity.EquipmentSlot.HEAD, stack.copy());
            stack.shrink(1); // Decrease the stack size in hand
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
