package com.danzielcode.agriculture_rebord.items.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WateringCan extends Item {

    private Tier tier;
    public WateringCan(Properties pProperties, Tier tier) {
        super(pProperties);
        this.tier = tier;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        waterPlant(pContext.getLevel(),pContext.getClickedPos());
        return InteractionResult.SUCCESS;
    }

    public Tier getTier(){
        return this.tier;
    }

    private void waterPlant(Level pLevel, BlockPos clickedPos){
        BlockState blockState = pLevel.getBlockState(clickedPos);
        Block cropBlock = pLevel.getBlockState(clickedPos).getBlock();
        if(cropBlock instanceof BonemealableBlock){
            if (pLevel instanceof ServerLevel)
                ((BonemealableBlock) cropBlock).performBonemeal((ServerLevel) pLevel, pLevel.random,clickedPos,blockState);
        }
    }

}
