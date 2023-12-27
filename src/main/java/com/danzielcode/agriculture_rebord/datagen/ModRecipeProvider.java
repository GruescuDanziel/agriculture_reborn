package com.danzielcode.agriculture_rebord.datagen;

import com.danzielcode.agriculture_rebord.AgricultureReborn;
import com.danzielcode.agriculture_rebord.items.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,ModItem.watering_can.get())
                .pattern("I  ")
                .pattern("IWI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.scythe.get())
                .pattern("III")
                .pattern("IS ")
                .pattern(" S ")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);

        SmithingTransformRecipeBuilder
                .smithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(ModItem.diamond_racke.get()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        ModItem.netherite_racke.get())
                .unlocks(getHasName(ModItem.diamond_racke.get()), has(ModItem.diamond_racke.get()))
                        .save(pRecipeOutput, "netherite_racke");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.stone_racke.get())
                .pattern("SSS")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.COBBLESTONE)
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(pRecipeOutput);

         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.iron_racke.get())
                .pattern("SSS")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);

         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.diamond_racke.get())
                .pattern("SSS")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pRecipeOutput);
         ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.golden_racke.get())
                .pattern("SSS")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.wood_racke.get())
                .pattern("SSS")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pRecipeOutput);
    }
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        multipleOreSmelting(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        singularOreSmelting(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        multipleOreSmelting(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreBlasting(RecipeOutput pRecipeOutput,ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        singularOreSmelting(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void multipleOreSmelting(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            singularOreSmelting(pRecipeOutput, pSerializer, itemlike, pCategory, pResult, pExperience, pCookingTime, pGroup, pSuffix);
        }
    }

    private static void singularOreSmelting(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer,ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix){
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(pIngredient), pCategory, pResult, pExperience, pCookingTime, pSerializer)
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient)).save(pRecipeOutput, AgricultureReborn.MODID +":" +  getItemName(pResult) + pSuffix + "_" + getItemName(pIngredient));
    }
}
