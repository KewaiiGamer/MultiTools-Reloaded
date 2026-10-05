package com.multitools;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;

import com.multitools.integration.CreateIntegration;
import com.multitools.integration.SilentGemsIntegration;
import com.multitools.integration.ThaumcraftIntegration;
import com.multitools.integration.TinkersIntegration;

import java.util.ArrayList;
import java.util.List;

/**
 * MultiTools — Paxel mod entry point.
 */
@Mod(MultiTools.MOD_ID)
public class MultiTools {

    public static final String MOD_ID = "multitools";

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(Registries.ITEM, MOD_ID);

    /** Properties for paxel items (no tab — creative tab is populated via displayItems). */
    public static Item.Properties paxelProps() {
        return new Item.Properties();
    }

    public static final DeferredHolder<Item, Item> COPPER_PAXEL =
        ITEMS.register("copper_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.COPPER, Items.COPPER_INGOT),
            paxelProps()
        ));

    public static final DeferredHolder<Item, Item> IRON_PAXEL =
        ITEMS.register("iron_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.IRON, Items.IRON_INGOT),
            paxelProps()
        ));

    public static final DeferredHolder<Item, Item> GOLD_PAXEL =
        ITEMS.register("gold_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.GOLD, Items.GOLD_INGOT),
            paxelProps()
        ));

    public static final DeferredHolder<Item, Item> DIAMOND_PAXEL =
        ITEMS.register("diamond_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.DIAMOND, Items.DIAMOND),
            paxelProps()
        ));

    public static final DeferredHolder<Item, Item> NETHERITE_PAXEL =
        ITEMS.register("netherite_paxel", () -> new PaxelItem(
            PaxelMaterials.withRepairItem(PaxelMaterials.NETHERITE, Items.NETHERITE_INGOT),
            paxelProps()
        ));

    public static final List<DeferredHolder<Item, Item>> MOD_PAXELS = new ArrayList<>();

    public MultiTools(IEventBus modBus) {
        ITEMS.register(modBus);
        PaxelItemGroup.CREATIVE_TABS.register(modBus);

        CreateIntegration.register(ITEMS, MOD_PAXELS);
        ThaumcraftIntegration.register(ITEMS, MOD_PAXELS);
        TinkersIntegration.register(ITEMS, MOD_PAXELS);
        SilentGemsIntegration.register(ITEMS, MOD_PAXELS);
    }
}
