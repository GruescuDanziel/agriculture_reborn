package com.danzielcode.agriculture_rebord.items;

import com.danzielcode.agriculture_rebord.AgricultureReborn;
import com.danzielcode.agriculture_rebord.items.custom.Rake;
import com.danzielcode.agriculture_rebord.items.custom.Scythe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AgricultureReborn.MODID);

    public static RegistryObject<Item> scythe = MOD_ITEMS.register("scythe", () -> new Scythe(new Item.Properties().durability(100)));

    public static RegistryObject<Item> wood_racke = MOD_ITEMS.register("wood_racke", () -> new Rake(Tiers.WOOD, 10, 1, new Item.Properties().durability(100)));
    public static RegistryObject<Item> stone_racke = MOD_ITEMS.register("stone_racke", () -> new Rake(Tiers.STONE, 10, 1, new Item.Properties().durability(100)));
    public static RegistryObject<Item> iron_racke = MOD_ITEMS.register("iron_racke", () -> new Rake(Tiers.IRON, 10, 1, new Item.Properties().durability(100)));
    public static RegistryObject<Item> golden_racke = MOD_ITEMS.register("golden_racke", () -> new Rake(Tiers.GOLD, 10, 1, new Item.Properties().durability(100)));

    public static RegistryObject<Item> diamond_racke = MOD_ITEMS.register("diamond_racke", () -> new Rake(Tiers.DIAMOND, 10, 1, new Item.Properties().durability(100)));
    public static RegistryObject<Item> netherite_racke = MOD_ITEMS.register("netherite_racke", () -> new Rake(Tiers.NETHERITE, 10, 1, new Item.Properties().durability(100)));
    public static void register(IEventBus eventBus){
        MOD_ITEMS.register(eventBus);
    }
}
