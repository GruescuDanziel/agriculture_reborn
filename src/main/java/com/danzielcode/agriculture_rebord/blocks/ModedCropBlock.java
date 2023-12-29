package com.danzielcode.agriculture_rebord.blocks;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModedCropBlock extends CropBlock {
    public static int max_age;
    public static IntegerProperty age;
    public static ItemLike seedItem;

    public ModedCropBlock(Properties pProperties, int max_age, IntegerProperty age, ItemLike seedItem) {
        super(pProperties);
        ModedCropBlock.max_age = max_age;
        ModedCropBlock.age = age;
    }


    @Override
    protected ItemLike getBaseSeedId() {
        return this.seedItem;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return age;
    }

    @Override
    public int getMaxAge() {
        return max_age;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(age);
    }
}
