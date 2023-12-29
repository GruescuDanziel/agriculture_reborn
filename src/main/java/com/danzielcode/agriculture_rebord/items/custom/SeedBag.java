package com.danzielcode.agriculture_rebord.items.custom;

import com.danzielcode.agriculture_rebord.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

public class SeedBag extends ItemNameBlockItem {

    Tier tier;
    ItemUtils utils;

    public SeedBag(Block pBlock, Properties pProperties, Tier tier) {
        super(pBlock, pProperties);
        this.tier = tier;
        this.utils = new ItemUtils();
    }

    public Tier getTier() {
        return tier;
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Direction facingDirection = pContext.getHorizontalDirection();

        Level pLevel = pContext.getLevel();
        Player player = pContext.getPlayer();
        InteractionHand pHand = pContext.getHand();
        ItemStack itemStack = pContext.getItemInHand();
        BlockPos clickedPos = pContext.getClickedPos();

        assert player != null;
        BlockHitResult pHitLeft = new BlockHitResult(player.getPosition(0), player.getDirection(), pContext.getClickedPos(), false);

        for (int i = 1; i <= this.getTier().getLevel(); i++) {

            switch (facingDirection) {
                case WEST, EAST -> {
                    super.useOn(new UseOnContext(pLevel, player, pHand, itemStack, pHitLeft.withPosition(clickedPos.north(i)).withDirection(Direction.UP)));
                    super.useOn(new UseOnContext(pLevel, player, pHand, itemStack, pHitLeft.withPosition(clickedPos.south(i)).withDirection(Direction.UP)));
                }
                case NORTH, SOUTH -> {
                    super.useOn(new UseOnContext(pLevel, player, pHand, itemStack, pHitLeft.withPosition(clickedPos.east(i)).withDirection(Direction.UP)));
                    super.useOn(new UseOnContext(pLevel, player, pHand, itemStack, pHitLeft.withPosition(clickedPos.west(i)).withDirection(Direction.UP)));
                }
                default -> {
                }
            }

        }


        return super.useOn(pContext);
    }


}
