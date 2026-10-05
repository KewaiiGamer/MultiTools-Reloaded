package com.multitools.integration;

import com.multitools.MultiTools;
import com.multitools.PaxelItem;
import com.multitools.PaxelMaterials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.ModList;

import java.util.List;

public final class TinkersIntegration {

    private TinkersIntegration() {}

    public static void register(DeferredRegister<Item> items, List<DeferredHolder<Item, Item>> modPaxels) {
        if (!ModList.get().isLoaded("tconstruct")) {
            return;
        }

        modPaxels.add(items.register("terrasteel_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.TERRASTEEL,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("tconstruct", "terrasteel_ingot"))),
            MultiTools.paxelProps()
        )));

        modPaxels.add(items.register("tic_andesite_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.TIC_ANDESITE,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("tconstruct", "andesite"))),
            MultiTools.paxelProps()
        )));

        modPaxels.add(items.register("tic_cobalt_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.TIC_COBALT,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("tconstruct", "cobalt_ingot"))),
            MultiTools.paxelProps()
        )));

        modPaxels.add(items.register("tic_nickel_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.TIC_NICKEL,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("tconstruct", "nickel_ingot"))),
            MultiTools.paxelProps()
        )));

        modPaxels.add(items.register("tic_manyullyn_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.TIC_MANYULLITE,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("tconstruct", "manyullyn_ingot"))),
            MultiTools.paxelProps()
        )));
    }
}
