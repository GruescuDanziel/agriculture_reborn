package com.danzielcode.agriculture_rebord.datagen.utils;

import com.danzielcode.agriculture_rebord.items.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class CustomTierRecipes extends RecipeProvider {
    public CustomTierRecipes(PackOutput pOutput) {
        super(pOutput);
    }

    public static void racke_recipe(RecipeOutput pRecipeOutput, Item rake, Item material){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, rake)
                .pattern("M M")
                .pattern(" M ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('M', material)
                .unlockedBy(getHasName(material), has(material))
                .save(pRecipeOutput);

    }

    public static void netherite_upgrade(RecipeOutput pRecipeOutput, ItemLike baseItem, Item upgradedItem){
        SmithingTransformRecipeBuilder
                .smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(baseItem),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        upgradedItem)
                .unlocks(getHasName(baseItem), has(baseItem))
                .save(pRecipeOutput, upgradedItem.toString());

    }

    public static void scythe_recepie(RecipeOutput pRecipeOutput, Item scythe, Item material){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, scythe)
                .pattern("MMM")
                .pattern("MS ")
                .pattern(" S ")
                .define('M', material)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(material), has(material))
                .save(pRecipeOutput);

    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

    }
}
