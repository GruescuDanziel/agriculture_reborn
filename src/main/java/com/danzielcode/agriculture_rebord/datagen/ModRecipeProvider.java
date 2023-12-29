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

import static com.danzielcode.agriculture_rebord.datagen.utils.CustomSeedBagRecipes.seed_bag;
import static com.danzielcode.agriculture_rebord.datagen.utils.CustomTierRecipes.*;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
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

    protected static void oreBlasting(RecipeOutput pRecipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        singularOreSmelting(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void multipleOreSmelting(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for (ItemLike itemlike : pIngredients) {
            singularOreSmelting(pRecipeOutput, pSerializer, itemlike, pCategory, pResult, pExperience, pCookingTime, pGroup, pSuffix);
        }
    }

    private static void singularOreSmelting(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(pIngredient), pCategory, pResult, pExperience, pCookingTime, pSerializer)
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient)).save(pRecipeOutput, AgricultureReborn.MODID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(pIngredient));
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.watering_can.get())
                .pattern("I  ")
                .pattern("IWI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);

        scythe_recepie(pRecipeOutput, ModItem.wood_scythe.get(), Items.OAK_LOG);
        scythe_recepie(pRecipeOutput, ModItem.stone_scythe.get(), Items.COBBLESTONE);
        scythe_recepie(pRecipeOutput, ModItem.iron_scythe.get(), Items.IRON_INGOT);
        scythe_recepie(pRecipeOutput, ModItem.gold_scythe.get(), Items.GOLD_INGOT);
        scythe_recepie(pRecipeOutput, ModItem.diamond_scythe.get(), Items.DIAMOND);

        racke_recipe(pRecipeOutput, ModItem.wood_racke.get(), Items.OAK_LOG);
        racke_recipe(pRecipeOutput, ModItem.stone_racke.get(), Items.COBBLESTONE);
        racke_recipe(pRecipeOutput, ModItem.iron_racke.get(), Items.IRON_INGOT);
        racke_recipe(pRecipeOutput, ModItem.golden_racke.get(), Items.GOLD_INGOT);
        racke_recipe(pRecipeOutput, ModItem.diamond_racke.get(), Items.DIAMOND);

        netherite_upgrade(pRecipeOutput, ModItem.diamond_scythe.get(), ModItem.nethrite_scythe.get());
        netherite_upgrade(pRecipeOutput, ModItem.diamond_racke.get(), ModItem.netherite_racke.get());


        seed_bag(pRecipeOutput, ModItem.tomato_seed_bag.get(), ModItem.tomato.get());

    }
}
