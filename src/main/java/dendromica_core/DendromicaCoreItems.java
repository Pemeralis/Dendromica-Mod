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
    public static Block EURENITE_BLOCK;

    static {
        EURENITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(5.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        EURENITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(8.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
    }
}