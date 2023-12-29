package com.danzielcode.agriculture_rebord.datagen.utils;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class CustomSeedBagRecipes extends RecipeProvider {
    public CustomSeedBagRecipes(PackOutput pOutput) {
        super(pOutput);
    }

    public static void seed_bag(RecipeOutput pRecipeOutput, ItemLike seedBag, ItemLike seedParent) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, seedBag)
                .pattern("   ")
                .pattern("LSL")
                .pattern("LLL")
                .define('L', Items.LEATHER)
                .define('S', seedParent)
                .unlockedBy(getHasName(seedParent), has(seedParent))
                .save(pRecipeOutput);

    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

    }
}
