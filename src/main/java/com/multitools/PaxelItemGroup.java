package com.multitools;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class PaxelItemGroup {

    private PaxelItemGroup() {}

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "multitools");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PAXEL_TAB =
        CREATIVE_TABS.register("paxels", () ->
            new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 1)
                .title(Component.translatable("itemGroup.multitools.paxels"))
                .icon(() -> new ItemStack(MultiTools.IRON_PAXEL.get()))
                .displayItems((params, output) -> {
                    output.accept(MultiTools.COPPER_PAXEL.get());
                    output.accept(MultiTools.IRON_PAXEL.get());
                    output.accept(MultiTools.GOLD_PAXEL.get());
                    output.accept(MultiTools.DIAMOND_PAXEL.get());
                    output.accept(MultiTools.NETHERITE_PAXEL.get());
                    for (var holder : MultiTools.MOD_PAXELS) {
                        output.accept(holder.get());
                    }
                })
                .build()
        );
}
