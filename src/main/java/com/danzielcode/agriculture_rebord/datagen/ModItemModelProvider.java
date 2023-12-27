package com.danzielcode.agriculture_rebord.datagen;

import com.danzielcode.agriculture_rebord.AgricultureReborn;
import com.danzielcode.agriculture_rebord.items.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, AgricultureReborn.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItem.scythe);
        simpleItem(ModItem.wood_racke);
        simpleItem(ModItem.stone_racke);
        simpleItem(ModItem.iron_racke);
        simpleItem(ModItem.golden_racke);
        simpleItem(ModItem.diamond_racke);
        simpleItem(ModItem.netherite_racke);
        simpleItem(ModItem.watering_can);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AgricultureReborn.MODID, "item/" + item.getId().getPath()));
    }
}
