package com.danzielcode.agriculture_rebord.blocks;

import com.danzielcode.agriculture_rebord.AgricultureReborn;
import com.danzielcode.agriculture_rebord.blocks.custom.TommatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlock{

    public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AgricultureReborn.MODID);

    public static final RegistryObject<Block> tomato_crop_block = MOD_BLOCKS.register("tomato_crop_block", () ->
            new TommatoCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().noOcclusion()));

    public static void register(IEventBus eventBus){
        MOD_BLOCKS.register(eventBus);
    }

}
