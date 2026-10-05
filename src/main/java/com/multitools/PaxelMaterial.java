package com.multitools;

import net.minecraft.world.item.Item;

/**
 * Describes a material that can be used to craft a Paxel.
 * Each field maps to a tool property; a single speed value applies to all
 * three tool types (pickaxe, axe, shovel) when using the convenience constructor.
 */
public record PaxelMaterial(
    String name,
    int durability,
    float pickaxeSpeed,
    float axeSpeed,
    float shovelSpeed,
    float attackDamage,
    float attackSpeed,
    int harvestLevel,
    int enchantmentValue,
    Item repairItem
) {
    /**
     * Convenience constructor: one speed value for all three tool types.
     */
    public PaxelMaterial(String name, int durability, float speed, float attackDamage,
                         int harvestLevel, int enchantmentValue, Item repairItem) {
        this(name, durability, speed, speed, speed, attackDamage, 1.0f,
             harvestLevel, enchantmentValue, repairItem);
    }

    /**
     * Convenience constructor: one speed, no repair item.
     */
    public PaxelMaterial(String name, int durability, float speed, float attackDamage,
                         int harvestLevel, int enchantmentValue) {
        this(name, durability, speed, speed, speed, attackDamage, 1.0f,
             harvestLevel, enchantmentValue, null);
    }
}
