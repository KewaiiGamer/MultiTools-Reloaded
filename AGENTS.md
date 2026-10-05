# MultiTools Project Instructions

## Critical Rule: Read the Decompiled Source Before Writing Code

Before writing or modifying ANY Java source file in this project, you MUST read the actual decompiled Minecraft/NeoForge class you're extending or calling from. Do NOT write code from memory of the API.

The decompiled source jar is at:

```
D:\Code\MultiTools\build\moddev\artifacts\neoforge-21.1.77-sources.jar
```

To read a class, extract it with PowerShell:

```powershell
$jar = "D:\Code\MultiTools\build\moddev\artifacts\neoforge-21.1.77-sources.jar"
Add-Type -AssemblyName System.IO.Compression.FileSystem
$zip = [System.IO.Compression.ZipFile]::OpenRead($jar)
$entry = $zip.Entries | Where-Object { $_.FullName -eq "net/minecraft/world/item/Item.java" }
$reader = New-Object System.IO.StreamReader($entry.Open())
$reader.ReadToEnd()
$reader.Close()
$zip.Dispose()
```

### What to check before coding:

1. **Method signatures** — parameter types, return types, `@Override` correctness. In 1.21.1 many methods gained an `ItemStack` first parameter.
2. **Class names and packages** — classes get renamed between versions (e.g. `ItemGroup` → `CreativeModeTab`).
3. **Constructor and builder patterns** — e.g. `CreativeModeTab.Builder(Row, int)` not a simple constructor.
4. **Registry keys** — `Registries.CREATIVE_MODE_TAB` not `Registries.ITEM_GROUP`.
5. **Data components** — 1.21.1 uses `DataComponents.TOOL` and `ItemAttributeModifiers` for tool properties, not the old `Tier` interface directly.

### Key classes to read before touching tool code:

- `net/minecraft/world/item/Item.java` — base class, `getDestroySpeed`, `isCorrectToolForDrops`
- `net/minecraft/world/item/TieredItem.java` — how vanilla tools work in 1.21.1
- `net/minecraft/world/item/DiggerItem.java` — pickaxe/axe/shovel pattern
- `net/minecraft/world/item/Item.java` inner class `Properties` — what's available
- `net/minecraft/world/item/CreativeModeTab.java` — creative tab builder
- `net/minecraft/core/registries/Registries.java` — registry keys

### If the sources jar is missing:

Run `gradle build` first (it regenerates the artifact), then proceed.

### Never guess. If you're unsure of a signature, read the source. A 5-second jar read prevents a 5-minute compile loop.
