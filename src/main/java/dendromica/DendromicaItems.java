package dendromica;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class DendromicaItems{
    public static ToolItem EURENITE_SWORD;
    public static ToolItem EURENITE_SHOVEL;
    public static ToolItem EURENITE_PICKAXE;
    public static ToolItem EURENITE_HOE;
    public static ToolItem EURENITE_AXE;
    public static Item EURENITE;
    public static Block EURENITE_ORE;
    public static Block EURENITE_BLOCK;
    public static ItemGroup DENDROMICA_GROUP;

    static {
        EURENITE_SWORD = new SwordItem(DendromicaMaterials.EURENITE, 3, -2.6F, new Item.Settings().group(ItemGroup.COMBAT).group(DENDROMICA_GROUP));
        EURENITE_SHOVEL = new ShovelItem(DendromicaMaterials.EURENITE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
        EURENITE_PICKAXE = new PickaxeItem(DendromicaMaterials.EURENITE, 2, -2.0F, new Item.Settings().group(ItemGroup.TOOLS)) {};
        EURENITE_HOE = new HoeItem(DendromicaMaterials.EURENITE, -20, -2.0F, new Item.Settings().group(ItemGroup.TOOLS)) {};
        EURENITE_AXE = new AxeItem(DendromicaMaterials.EURENITE, 5, -3.3F, new Item.Settings().group(ItemGroup.TOOLS)) {};
        EURENITE = new Item(new Item.Settings().group(ItemGroup.MISC));
        EURENITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(5.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        EURENITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(8.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        DENDROMICA_GROUP = FabricItemGroupBuilder.create(
                new Identifier("tutorial", "other"))
                .icon(() -> new ItemStack(EURENITE))
                .build();
    }
}
