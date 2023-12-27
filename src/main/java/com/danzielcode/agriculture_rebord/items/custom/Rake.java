package com.danzielcode.agriculture_rebord.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class Rake extends HoeItem {

    public Rake(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Direction facingDirection = pContext.getHorizontalDirection();

        Level pLevel = pContext.getLevel();
        Player player = pContext.getPlayer();
        InteractionHand pHand = pContext.getHand();
        ItemStack itemStack = pContext.getItemInHand();

        assert player != null;
        BlockHitResult pHitRight = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos(),false);
        BlockHitResult pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos(),false);

        for (int i = 1; i <= this.getTier().getLevel(); i++) {

            switch (facingDirection) {
                case WEST, EAST -> {
                    pHitRight = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().north(i), false);
                    pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().south(i), false);
                }
                case NORTH, SOUTH -> {
                    pHitRight = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().west(i), false);
                    pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos().east(i), false);
                }
                default -> {
                }
            }

            try {
                breakGrass(pLevel, pHitRight.getBlockPos());
                breakGrass(pLevel, pHitLeft.getBlockPos());
            }catch (Exception e)
            {
                System.out.println(e);
            }
            try {
                super.useOn(new UseOnContext(pLevel, player, pHand, itemStack, pHitRight));
                super.useOn(new UseOnContext(pLevel, player, pHand, itemStack, pHitLeft));
            }catch (Exception e){
                System.out.println(e);
            }

        }


        return super.useOn(pContext);
    }

    private void breakGrass(Level pLevel, BlockPos grassBlock){
        if (pLevel.getBlockState(grassBlock) == Blocks.GRASS_BLOCK.defaultBlockState() || pLevel.getBlockState(grassBlock) == Blocks.DIRT.defaultBlockState()){
            if (pLevel.getBlockState(grassBlock.above()) == Blocks.GRASS.defaultBlockState() || pLevel.getBlockState(grassBlock.above()) == Blocks.TALL_GRASS.defaultBlockState()){
                pLevel.destroyBlock(grassBlock.above(), true);
            }
        }

    }
}
