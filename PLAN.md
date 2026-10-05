# MultiTools — Paxel Mod Plan

## Overview

A NeoForge 1.21.1 mod that adds **Paxels** — universal tools that combine Pickaxe, Axe, Shovel, and Hoe functionality into a single item. Each Paxel is crafted from a material, and the mod supports materials from vanilla, Create, Thaumcraft, Tinkers' Construct, and Silent's Gems.

## Architecture

```
com.multitools
├── MultiTools.java          # @Mod entry point, DeferredRegister for items
├── PaxelMaterial.java       # Record: durability, speeds, damage, harvest level, repair
├── PaxelMaterials.java      # Static constants for all supported materials
├── PaxelItem.java           # Universal tool: pickaxe + axe + shovel + hoe
├── PaxelItemGroup.java      # Creative tab
└── integration/
    ├── CreateIntegration.java      # copper, tin, steel, alumite
    ├── ThaumcraftIntegration.java  # thaumium
    ├── TinkersIntegration.java     # terrasteel, TiC materials
    └── SilentGemsIntegration.java  # gem materials
```

## PaxelMaterial

A record holding all tool properties:

| Field | Type | Description |
|-------|------|-------------|
| `name` | String | Identifier (e.g. `"copper"`) |
| `durability` | int | Max uses |
| `pickaxeSpeed` | float | Mining speed on stone/ore |
| `axeSpeed` | float | Mining speed on wood |
| `shovelSpeed` | float | Mining speed on dirt/sand |
| `attackDamage` | float | Melee damage |
| `attackSpeed` | float | Attack cooldown (1.0 = normal) |
| `harvestLevel` | int | Max harvest level (2=iron, 3=diamond, 4=netherite) |
| `enchantmentValue` | int | Enchantment bonus |
| `repairItem` | Item | Item used for mending/repair (nullable) |

Convenience constructor: if you only have one speed value, it applies to all three tool types.

## PaxelItem — Universal Tool

Extends `Item` and overrides:

- **`getDestroySpeed(ToolContext)`** — checks `BlockTags.MINEABLE_WITH_PICKAXE/AXE/SHOVEL` and returns the appropriate speed from the material.
- **`isCorrectToolForDrops(ToolContext)`** — returns true if the block's harvest level ≤ material's harvest level.
- **`canDestroyBlock(BlockState)`** — same harvest-level check.
- **`use(UseOnContext)`** — hoe behavior (till dirt/grass → farmland) and axe stripping (log → stripped log).
- **`getAttackDamage()` / `getAttackSpeed()`** — from the material.

## Material Table

| Material | Mod | Durability | Speed | Damage | Harvest | Repair |
|----------|-----|-----------|-------|--------|---------|--------|
| Copper | Create | 100 | 5.0 | 2.0 | 2 | copper ingot |
| Tin | Create | 150 | 5.0 | 2.5 | 2 | tin ingot |
| Steel | Create | 300 | 7.0 | 4.0 | 3 | steel ingot |
| Alumite | Create | 350 | 7.5 | 4.5 | 3 | alumite ingot |
| Thaumium | Thaumcraft | 300 | 7.0 | 4.0 | 3 | thaumium ingot |
| Terrasteel | Tinkers | 400 | 8.0 | 5.0 | 4 | terrasteel ingot |
| TiC (various) | Tinkers | 200–500 | 6.0–9.0 | 3.0–5.0 | 3–4 | TiC material |
| Silent Gems (various) | Silent's Gems | 150–400 | 5.0–8.0 | 2.5–5.0 | 2–4 | gem item |

## Integration Strategy

Each integration class:
1. Checks `ModList.get().isLoaded(modId)` — if false, registers nothing.
2. If the mod is present, creates `PaxelMaterial` instances with the mod's ingot/gem as `repairItem`.
3. Registers a `PaxelItem` for each material via the shared `DeferredRegister<Item>`.

This means the mod has **zero hard dependencies** — it works standalone with just vanilla materials, and gains more Paxels as other mods are installed.

## Build

- **Gradle** with `net.neoforged.moddev` plugin
- **Java 21**
- **NeoForge 21.1.77**
- No external dependencies at compile time (all integrations are optional)

## File List

```
build.gradle
settings.gradle
gradle.properties
src/main/java/com/multitools/
    MultiTools.java
    PaxelMaterial.java
    PaxelMaterials.java
    PaxelItem.java
    PaxelItemGroup.java
    integration/
        CreateIntegration.java
        ThaumcraftIntegration.java
        TinkersIntegration.java
        SilentGemsIntegration.java
src/main/resources/
    META-INF/neoforge.mods.json
    assets/multitools/lang/en_us.json
```
