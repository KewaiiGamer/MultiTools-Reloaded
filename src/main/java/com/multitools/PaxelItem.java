package com.multitools;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;

import java.util.List;

public class PaxelItem extends Item {

    private final PaxelMaterial material;

    public PaxelItem(PaxelMaterial material, Item.Properties props) {
        super(props.stacksTo(1)
            .durability(material.durability())
            .component(DataComponents.TOOL, createToolComponent(material))
            .component(DataComponents.ATTRIBUTE_MODIFIERS, createAttributes(material)));
        this.material = material;
    }

    public PaxelMaterial getMaterial() {
        return material;
    }

    private static Tool createToolComponent(PaxelMaterial material) {
        return new Tool(
            List.of(
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, material.pickaxeSpeed()),
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, material.axeSpeed()),
                Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_SHOVEL, material.shovelSpeed())
            ),
            1.0F,
            1
        );
    }

    private static ItemAttributeModifiers createAttributes(PaxelMaterial material) {
        return ItemAttributeModifiers.builder()
            .add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                    ResourceLocation.fromNamespaceAndPath("multitools", "paxel_attack_damage"),
                    material.attackDamage(),
                    AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.MAINHAND
            )
            .add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(
                    ResourceLocation.fromNamespaceAndPath("multitools", "paxel_attack_speed"),
                    material.attackSpeed(),
                    AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.MAINHAND
            )
            .build();
    }
}
