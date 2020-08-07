package dendromica_core;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class DendromicaCoreItems {
    public static ToolItem EURENITE_SWORD;
    public static ToolItem EURENITE_SHOVEL;
    public static ToolItem EURENITE_PICKAXE;
    public static ToolItem EURENITE_HOE;
    public static ToolItem EURENITE_AXE;
    public static Item EURENITE;
    public static Block EURENITE_ORE;
    public static Item EURENITE_ORE_ITEM;
    public static Block EURENITE_BLOCK;
    public static Item EURENITE_BLOCk_ITEM;

    static {
        final ItemGroup DENDROMICA = FabricItemGroupBuilder.create(
                new Identifier("dendromica_core", "main"))
                .icon(() -> new ItemStack(EURENITE))
                .appendItems(stacks -> {
                    stacks.add(new ItemStack(EURENITE_ORE));
                    stacks.add(new ItemStack(EURENITE));
                    stacks.add(new ItemStack(EURENITE_BLOCK));
                    stacks.add(new ItemStack(EURENITE_SHOVEL));
                    stacks.add(new ItemStack(EURENITE_PICKAXE));
                    stacks.add(new ItemStack(EURENITE_AXE));
                    stacks.add(new ItemStack(EURENITE_HOE));
                    stacks.add(new ItemStack(EURENITE_SWORD));
                })
                .build();

        EURENITE_SWORD = new SwordItem(DendromicaCoreMaterials.EURENITE, 3, -2.6F, new Item.Settings().group(ItemGroup.MATERIALS));
        EURENITE_SHOVEL = new ShovelItem(DendromicaCoreMaterials.EURENITE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.MATERIALS));
        EURENITE_PICKAXE = new PickaxeItem(DendromicaCoreMaterials.EURENITE, 2, -2.0F, new Item.Settings().group(ItemGroup.MATERIALS)) {};
        EURENITE_HOE = new HoeItem(DendromicaCoreMaterials.EURENITE, -20, -2.0F, new Item.Settings().group(ItemGroup.MATERIALS)) {};
        EURENITE_AXE = new AxeItem(DendromicaCoreMaterials.EURENITE, 5, -3.3F, new Item.Settings().group(ItemGroup.MATERIALS)) {};

        EURENITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(5.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        EURENITE_ORE_ITEM = new BlockItem(EURENITE_ORE,
                new Item.Settings().group(ItemGroup.MATERIALS));
        EURENITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(8.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        EURENITE_BLOCk_ITEM = new BlockItem(EURENITE_BLOCK,
                new Item.Settings().group(ItemGroup.MATERIALS));
        EURENITE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    }
}