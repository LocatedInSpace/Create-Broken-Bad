package com.jetpacker06.CreateBrokenBad.item;

import com.jetpacker06.CreateBrokenBad.block.TrayBlock;
import com.jetpacker06.CreateBrokenBad.register.AllBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MethItem extends Item {
    public MethItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Block clickedBlock = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
        Block newBlock = ((pContext.getItemInHand().getItem() instanceof MethItem.Blue) ? AllBlocks.BLUE_METH_TRAY : AllBlocks.WHITE_METH_TRAY).get();
        if (clickedBlock instanceof TrayBlock.Empty) {
            Direction direction = pContext.getLevel().getBlockState(pContext.getClickedPos()).getValue(TrayBlock.FACING);
            pContext.getLevel().setBlock(
                pContext.getClickedPos(),
                newBlock.defaultBlockState().setValue(TrayBlock.FACING, direction),
                3
            );
            pContext.getLevel().playSound(pContext.getPlayer(),pContext.getClickedPos(), SoundEvents.SAND_HIT, SoundSource.BLOCKS, 2f, 1f);
            pContext.getItemInHand().shrink(1);
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) pEntityLiving.curePotionEffects(pStack); // FORGE - move up so stack.shrink does not turn stack into air
        return super.finishUsingItem(pStack, pLevel, pEntityLiving);
    }

    public static class Blue extends MethItem {
        public Blue(Properties pProperties) {
            super(pProperties);
        }
    }
    public static class White extends MethItem {
        public White(Properties pProperties) {
            super(pProperties);
        }
    }
}
