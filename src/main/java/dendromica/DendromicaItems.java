package dendromica;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class DendromicaItems{
    static {
        ToolItem EURENITE_SWORD = new SwordItem(DendromicaMaterials.EURENITE, 3, -2.6F, new Item.Settings().group(ItemGroup.COMBAT).group(DENDROMICA_GROUP));
        ToolItem EURENITE_SHOVEL = new ShovelItem(DendromicaMaterials.EURENITE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
        ToolItem EURENITE_PICKAXE = new PickaxeItem(DendromicaMaterials.EURENITE, 2, -2.0F, new Item.Settings().group(ItemGroup.TOOLS)) {};
        ToolItem EURENITE_HOE = new HoeItem(DendromicaMaterials.EURENITE, -20, -2.0F, new Item.Settings().group(ItemGroup.TOOLS)) {};
        ToolItem EURENITE_AXE = new AxeItem(DendromicaMaterials.EURENITE, 5, -3.3F, new Item.Settings().group(ItemGroup.TOOLS)) {};
        Item EURENITE = new Item(new Item.Settings().group(ItemGroup.MISC));
        Block EURENITE_ORE = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(5.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        final Block EURENITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
                .hardness(8.0f)
                .breakByTool(FabricToolTags.PICKAXES, 3)
                .requiresTool());
        final ItemGroup DENDROMICA_GROUP = FabricItemGroupBuilder.create(
                new Identifier("tutorial", "other"))
                .icon(() -> new ItemStack(EURENITE))
                .build();
    }
}
