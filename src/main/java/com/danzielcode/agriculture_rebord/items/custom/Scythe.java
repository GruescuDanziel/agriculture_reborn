package com.danzielcode.agriculture_rebord.items.custom;

import com.danzielcode.agriculture_rebord.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class Scythe extends Item {

    private Tier tier;
    private ItemUtils utils;

    public Scythe(Properties pProperties, Tier tier) {
        super(pProperties);

        this.tier = tier;
        this.utils = new ItemUtils();


    }

    public Tier getTier() {
        return this.tier;
    }

    public int getLevel() {
        return this.getTier().getLevel();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        Vec3 playerPosition = pPlayer.getPosition(0);
        Vec3 ceiledPosition = new Vec3(playerPosition.x, Math.ceil(playerPosition.y), playerPosition.z);
        int damageDealt = breakAroundPlayer(pLevel, ceiledPosition);
        pPlayer.getItemInHand(pUsedHand).hurtAndBreak(damageDealt, pPlayer, player -> {
        });

        return InteractionResultHolder.success(pPlayer.getMainHandItem());
    }

    private int breakAroundPlayer(Level pLevel, Vec3 playerPos) {
        int level = this.getLevel();
        for (int x = -level; x <= level; x++) {
            for (int z = -level; z <= level; z++) {
                BlockPos playerPosition = BlockPos.containing(playerPos.add(x, 0, z));
                boolean isCrop = utils.isCrop(pLevel.getBlockState(playerPosition));
                if (isCrop) {
                    pLevel.destroyBlock(playerPosition, true);
                }
            }
        }
        return 1;
    }


}
