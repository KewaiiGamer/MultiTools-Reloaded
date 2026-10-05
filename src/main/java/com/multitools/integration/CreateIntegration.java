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

public final class CreateIntegration {

    private CreateIntegration() {}

    public static void register(DeferredRegister<Item> items, List<DeferredHolder<Item, Item>> modPaxels) {
        if (!ModList.get().isLoaded("create")) {
            return;
        }

        modPaxels.add(items.register("tin_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.TIN,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("create", "tin_ingot"))),
            MultiTools.paxelProps()
        )));

        modPaxels.add(items.register("steel_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.STEEL,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("create", "steel_ingot"))),
            MultiTools.paxelProps()
        )));

        modPaxels.add(items.register("alumite_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.ALUMITE,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("create", "alumite_ingot"))),
            MultiTools.paxelProps()
        )));
    }
}
