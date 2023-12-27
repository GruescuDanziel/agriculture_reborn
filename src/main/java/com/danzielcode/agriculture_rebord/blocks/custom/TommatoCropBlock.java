package com.danzielcode.agriculture_rebord.blocks.custom;

import com.danzielcode.agriculture_rebord.items.ModItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class TommatoCropBlock extends CropBlock {

    public static int max_age = 5;
    public static IntegerProperty age = BlockStateProperties.AGE_5;
    public TommatoCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
       return ModItem.tomato_seeds.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
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
