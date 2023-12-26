package com.danzielcode.agriculture_rebord.datagen;

import com.danzielcode.agriculture_rebord.AgricultureReborn;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, AgricultureReborn.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    private void blockWithItem(RegistryObject<Block> block){
       simpleBlockWithItem(block.get(),cubeAll(block.get()));
    }

}
