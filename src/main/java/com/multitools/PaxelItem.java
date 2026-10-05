package com.multitools;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

public class PaxelItem extends Item {

    private final PaxelMaterial material;

    public PaxelItem(PaxelMaterial material, Item.Properties props) {
        super(props.stacksTo(1).durability(material.durability()));
        this.material = material;
    }

    public PaxelMaterial getMaterial() {
        return material;
    }

    public float getDestroySpeed(BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return material.pickaxeSpeed();
        }
        if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
            return material.axeSpeed();
        }
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return material.shovelSpeed();
        }
        return 1.0f;
    }

    public boolean isCorrectToolForDrops(BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE)
            || state.is(BlockTags.MINEABLE_WITH_AXE)
            || state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    public boolean canDestroyBlock(BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE)
            || state.is(BlockTags.MINEABLE_WITH_AXE)
            || state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    public float getAttackDamage() {
        return material.attackDamage();
    }

    public float getAttackSpeed() {
        return material.attackSpeed();
    }
}
