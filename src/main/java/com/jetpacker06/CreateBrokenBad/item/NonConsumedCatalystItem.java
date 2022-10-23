package com.jetpacker06.CreateBrokenBad.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NonConsumedCatalystItem extends Item {
    public NonConsumedCatalystItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("not_consumed_tooltip"));
    }

    //@Override
    //public boolean hasContainerItem(ItemStack stack) { return true; }
    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    //@Override
    //public ItemStack getContainerItem(ItemStack itemStack) { return itemStack;}
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack;
    }
}
