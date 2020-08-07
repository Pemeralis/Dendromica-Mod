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
    public static BlockItem EURENITE_ORE;
    public static BlockItem EURENITE_BLOCK;
    public static BlockItem INFUSER;

    static {
        final ItemGroup DENDROMICA = FabricItemGroupBuilder.create(
                new Identifier("dendromica_core", "main"))
                .icon(() -> new ItemStack(EURENITE))
                .build();

        EURENITE_SWORD = new SwordItem(DendromicaCoreMaterials.EURENITE, 3, -2.6F, new Item.Settings().group(DENDROMICA));
        EURENITE_SHOVEL = new ShovelItem(DendromicaCoreMaterials.EURENITE, 1.5F, -3.0F, new Item.Settings().group(DENDROMICA));
        EURENITE_PICKAXE = new PickaxeItem(DendromicaCoreMaterials.EURENITE, 2, -2.0F, new Item.Settings().group(DENDROMICA)) {};
        EURENITE_HOE = new HoeItem(DendromicaCoreMaterials.EURENITE, -20, -2.0F, new Item.Settings().group(DENDROMICA)) {};
        EURENITE_AXE = new AxeItem(DendromicaCoreMaterials.EURENITE, 5, -3.3F, new Item.Settings().group(DENDROMICA)) {};
        EURENITE_ORE = new BlockItem(
                new Block(FabricBlockSettings
                        .of(Material.METAL)
                        .hardness(5.0f)
                        .breakByTool(FabricToolTags.PICKAXES, 3)
                        .requiresTool()),
                new Item.Settings()
                        .group(DENDROMICA));
        EURENITE_BLOCK = new BlockItem(
                new Block(FabricBlockSettings
                        .of(Material.METAL)
                        .hardness(8.0f)
                        .breakByTool(FabricToolTags.PICKAXES, 3)
                        .requiresTool()),
                new Item.Settings()
                        .group(DENDROMICA));
        EURENITE = new Item(new Item.Settings().group(DENDROMICA));
        INFUSER = new BlockItem(
                new Infuser(FabricBlockSettings
                        .of(Material.STONE)
                        .hardness(10.0f)
                        .breakByTool(FabricToolTags.PICKAXES, 3)
                        .requiresTool()),
                new Item.Settings()
                .group(DENDROMICA));
    }
}