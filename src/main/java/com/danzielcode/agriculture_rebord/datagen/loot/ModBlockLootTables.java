package com.danzielcode.agriculture_rebord.datagen.loot;

import com.danzielcode.agriculture_rebord.blocks.ModBlock;
import com.danzielcode.agriculture_rebord.blocks.custom.TommatoCropBlock;
import com.danzielcode.agriculture_rebord.items.ModItem;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        this.add(ModBlock.tomato_crop_block.get(),
                createCropDrops(
                        ModBlock.tomato_crop_block.get(),
                        ModItem.tomato.get(),
                        ModItem.tomato_seeds.get(),
                        makeCondition(
                                ModBlock.tomato_crop_block.get(),
                                StatePropertiesPredicate
                                        .Builder
                                        .properties()
                                        .hasProperty(
                                                TommatoCropBlock.age,
                                                5)
                                )));
    }
    protected LootTable.Builder multipleOreDorp(Block pBlock, Item pItem, int min , int max ) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(Items.LAPIS_LAZULI)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    @Override
    protected void generate() {
    }

    protected LootItemCondition.Builder makeCondition(Block blockState, StatePropertiesPredicate.Builder builder){
        return LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(blockState)
                .setProperties(builder);
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.MOD_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
