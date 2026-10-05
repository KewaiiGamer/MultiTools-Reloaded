package com.multitools;

import net.minecraft.world.item.Item;

/**
 * Pre-defined PaxelMaterial constants for all supported materials.
 * Mod-specific materials have a null repairItem here; the integration
 * classes create a copy with the proper runtime item reference.
 */
public final class PaxelMaterials {

    private PaxelMaterials() {}

    // ── Vanilla ──────────────────────────────────────────────

    public static final PaxelMaterial COPPER =
        new PaxelMaterial("copper", 100, 5.0f, 2.0f, 2, 5, null);

    public static final PaxelMaterial IRON =
        new PaxelMaterial("iron", 250, 6.0f, 3.0f, 3, 14, null);

    public static final PaxelMaterial GOLD =
        new PaxelMaterial("gold", 32, 12.0f, 1.0f, 2, 5, null);

    public static final PaxelMaterial DIAMOND =
        new PaxelMaterial("diamond", 1561, 8.0f, 6.0f, 4, 17, null);

    public static final PaxelMaterial NETHERITE =
        new PaxelMaterial("netherite", 2031, 9.0f, 7.0f, 4, 25, null);

    // ── Create ───────────────────────────────────────────────

    public static final PaxelMaterial TIN =
        new PaxelMaterial("tin", 150, 5.0f, 2.5f, 2, 5, null);

    public static final PaxelMaterial STEEL =
        new PaxelMaterial("steel", 300, 7.0f, 4.0f, 3, 14, null);

    public static final PaxelMaterial ALUMITE =
        new PaxelMaterial("alumite", 350, 7.5f, 4.5f, 3, 14, null);

    // ── Thaumcraft ───────────────────────────────────────────

    public static final PaxelMaterial THAUMIUM =
        new PaxelMaterial("thaumium", 300, 7.0f, 4.0f, 3, 14, null);

    // ── Tinkers' Construct ───────────────────────────────────

    public static final PaxelMaterial TERRASTEEL =
        new PaxelMaterial("terrasteel", 400, 8.0f, 5.0f, 4, 17, null);

    // ── TiC (Tinkers' Construct) ─────────────────────────────
    // TiC materials are defined at runtime by TinkersIntegration.
    // These are common ones with known stats:

    public static final PaxelMaterial TIC_ANDESITE =
        new PaxelMaterial("tic_andesite", 200, 6.0f, 3.0f, 2, 8, null);

    public static final PaxelMaterial TIC_COBALT =
        new PaxelMaterial("tic_cobalt", 300, 7.0f, 4.0f, 3, 14, null);

    public static final PaxelMaterial TIC_NICKEL =
        new PaxelMaterial("tic_nickel", 350, 7.5f, 4.5f, 3, 14, null);

    public static final PaxelMaterial TIC_MANYULLITE =
        new PaxelMaterial("tic_manyullyn", 400, 8.0f, 5.0f, 4, 17, null);

    // ── Silent's Gems ────────────────────────────────────────
    // Defined at runtime by SilentGemsIntegration.

    public static final PaxelMaterial SG_AMETHYST =
        new PaxelMaterial("sg_amethyst", 150, 5.0f, 2.5f, 2, 5, null);

    public static final PaxelMaterial SG_BERYL =
        new PaxelMaterial("sg_beryl", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_COPAL =
        new PaxelMaterial("sg_copal", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_DIAMOND =
        new PaxelMaterial("sg_diamond", 300, 7.0f, 4.0f, 3, 14, null);

    public static final PaxelMaterial SG_EMERALD =
        new PaxelMaterial("sg_emerald", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_GARNET =
        new PaxelMaterial("sg_garnet", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_LAPIS =
        new PaxelMaterial("sg_lapis", 150, 5.0f, 2.5f, 2, 5, null);

    public static final PaxelMaterial SG_RUBITE =
        new PaxelMaterial("sg_rubite", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_SAPPHIRE =
        new PaxelMaterial("sg_sapphire", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_TOPAZ =
        new PaxelMaterial("sg_topaz", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_TURQUOISE =
        new PaxelMaterial("sg_turquoise", 150, 5.0f, 2.5f, 2, 5, null);

    public static final PaxelMaterial SG_AMBER =
        new PaxelMaterial("sg_amber", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_MORGANITE =
        new PaxelMaterial("sg_morganite", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_ALEXANDRITE =
        new PaxelMaterial("sg_alexandrite", 300, 7.0f, 4.0f, 3, 14, null);

    public static final PaxelMaterial SG_AZURE =
        new PaxelMaterial("sg_azure", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_AQUAMARINE =
        new PaxelMaterial("sg_aquamarine", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_CITRINE =
        new PaxelMaterial("sg_citrine", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_IOLITE =
        new PaxelMaterial("sg_iolite", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_JASPER =
        new PaxelMaterial("sg_jasper", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_ONYX =
        new PaxelMaterial("sg_onyx", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_RUBY =
        new PaxelMaterial("sg_ruby", 300, 7.0f, 4.0f, 3, 14, null);

    public static final PaxelMaterial SG_SPINEL =
        new PaxelMaterial("sg_spinels", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_TIGER_EYE =
        new PaxelMaterial("sg_tiger_eye", 200, 6.0f, 3.0f, 3, 8, null);

    public static final PaxelMaterial SG_UNDIANE =
        new PaxelMaterial("sg_undiane", 250, 6.5f, 3.5f, 3, 10, null);

    public static final PaxelMaterial SG_ZIRCON =
        new PaxelMaterial("sg_zircon", 200, 6.0f, 3.0f, 3, 8, null);

    /**
     * Returns a copy of this material with a different repair item.
     */
    public static PaxelMaterial withRepairItem(PaxelMaterial base, Item repairItem) {
        return new PaxelMaterial(
            base.name(), base.durability(),
            base.pickaxeSpeed(), base.axeSpeed(), base.shovelSpeed(),
            base.attackDamage(), base.attackSpeed(),
            base.harvestLevel(), base.enchantmentValue(),
            repairItem
        );
    }
}
