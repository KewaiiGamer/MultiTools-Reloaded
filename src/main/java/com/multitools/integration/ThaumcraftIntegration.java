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

public final class ThaumcraftIntegration {

    private ThaumcraftIntegration() {}

    public static void register(DeferredRegister<Item> items, List<DeferredHolder<Item, Item>> modPaxels) {
        if (!ModList.get().isLoaded("thaumcraft")) {
            return;
        }

        modPaxels.add(items.register("thaumium_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.THAUMIUM,
                BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("thaumcraft", "thaumium_ingot"))),
            MultiTools.paxelProps()
        )));
    }
}
