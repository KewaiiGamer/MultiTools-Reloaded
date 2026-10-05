package com.multitools.integration;

import com.multitools.MultiTools;
import com.multitools.PaxelItem;
import com.multitools.PaxelMaterial;
import com.multitools.PaxelMaterials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.ModList;

import java.util.List;

public final class SilentGemsIntegration {

    private SilentGemsIntegration() {}

    public static void register(DeferredRegister<Item> items, List<DeferredHolder<Item, Item>> modPaxels) {
        if (!ModList.get().isLoaded("silents_gems")) {
            return;
        }

        registerGem(items, modPaxels, "amethyst", PaxelMaterials.SG_AMETHYST);
        registerGem(items, modPaxels, "beryl", PaxelMaterials.SG_BERYL);
        registerGem(items, modPaxels, "copal", PaxelMaterials.SG_COPAL);
        registerGem(items, modPaxels, "diamond", PaxelMaterials.SG_DIAMOND);
        registerGem(items, modPaxels, "emerald", PaxelMaterials.SG_EMERALD);
        registerGem(items, modPaxels, "garnet", PaxelMaterials.SG_GARNET);
        registerGem(items, modPaxels, "lapis", PaxelMaterials.SG_LAPIS);
        registerGem(items, modPaxels, "rubite", PaxelMaterials.SG_RUBITE);
        registerGem(items, modPaxels, "sapphire", PaxelMaterials.SG_SAPPHIRE);
        registerGem(items, modPaxels, "topaz", PaxelMaterials.SG_TOPAZ);
        registerGem(items, modPaxels, "turquoise", PaxelMaterials.SG_TURQUOISE);
        registerGem(items, modPaxels, "amber", PaxelMaterials.SG_AMBER);
        registerGem(items, modPaxels, "morganite", PaxelMaterials.SG_MORGANITE);
        registerGem(items, modPaxels, "alexandrite", PaxelMaterials.SG_ALEXANDRITE);
        registerGem(items, modPaxels, "azure", PaxelMaterials.SG_AZURE);
        registerGem(items, modPaxels, "aquamarine", PaxelMaterials.SG_AQUAMARINE);
        registerGem(items, modPaxels, "citrine", PaxelMaterials.SG_CITRINE);
        registerGem(items, modPaxels, "iolite", PaxelMaterials.SG_IOLITE);
        registerGem(items, modPaxels, "jasper", PaxelMaterials.SG_JASPER);
        registerGem(items, modPaxels, "onyx", PaxelMaterials.SG_ONYX);
        registerGem(items, modPaxels, "ruby", PaxelMaterials.SG_RUBY);
        registerGem(items, modPaxels, "spinels", PaxelMaterials.SG_SPINEL);
        registerGem(items, modPaxels, "tiger_eye", PaxelMaterials.SG_TIGER_EYE);
        registerGem(items, modPaxels, "undiane", PaxelMaterials.SG_UNDIANE);
        registerGem(items, modPaxels, "zircon", PaxelMaterials.SG_ZIRCON);
    }

    private static void registerGem(DeferredRegister<Item> items,
                                    List<DeferredHolder<Item, Item>> modPaxels,
                                    String gemName,
                                    PaxelMaterial material) {
        modPaxels.add(items.register("sg_" + gemName + "_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(material,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("silents_gems", "gem_" + gemName))),
            MultiTools.paxelProps()
        )));
    }
}
