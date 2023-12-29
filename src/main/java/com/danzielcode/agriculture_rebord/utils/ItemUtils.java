package com.danzielcode.agriculture_rebord.utils;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {
    private static final List<BlockState> crops = new ArrayList<>();


    public ItemUtils() {
        crops.add(Blocks.WHEAT.defaultBlockState());
        crops.add(Blocks.PUMPKIN.defaultBlockState());
        crops.add(Blocks.MELON.defaultBlockState());
        crops.add(Blocks.CARROTS.defaultBlockState());
        crops.add(Blocks.POTATOES.defaultBlockState());
        crops.add(Blocks.BEETROOTS.defaultBlockState());
    }

    private BlockState getDefaultState(BlockState blockState) {
        return blockState.getBlock().defaultBlockState();
    }

    public boolean isCrop(BlockState blockState) {

        return crops.contains(getDefaultState(blockState));
    }
}
