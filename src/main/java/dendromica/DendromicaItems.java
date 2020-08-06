package dendromica;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;

public class DendromicaItems{
    public static ToolItem EURENITE_SWORD = new SwordItem(DendromicaMaterials.EURENITE, 3, -2.6F, new Item.Settings().group(ItemGroup.COMBAT));
    public static ToolItem EURENITE_SHOVEL = new ShovelItem(DendromicaMaterials.EURENITE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem EURENITE_PICKAXE = new PickaxeItem(DendromicaMaterials.EURENITE, 2, -2.0F, new Item.Settings().group(ItemGroup.TOOLS)){};
    public static ToolItem EURENITE_HOE = new HoeItem(DendromicaMaterials.EURENITE, -20, -2.0F, new Item.Settings().group(ItemGroup.TOOLS)){};
    public static ToolItem EURENITE_AXE = new AxeItem(DendromicaMaterials.EURENITE, 5, -3.3F, new Item.Settings().group(ItemGroup.TOOLS)){};
    public static final Item EURENITE = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Block EURENITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
            .hardness(5.0f)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool());
    public static final Block EURENITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
            .hardness(8.0f)
            .breakByTool(FabricToolTags.PICKAXES, 3)
            .requiresTool());
}
