package dendromica_core;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static dendromica_core.DendromicaCoreItems.*;


public class Erratica implements ModInitializer {
	private void handleBiome(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									EURENITE_ORE.getDefaultState(),
									4 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									8, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									24 //Max y level
							))));
		}
	}
	@Override
	public void onInitialize() {
		registerBlock("eurenite_ore", EURENITE_ORE);
		registerItem("eurenite_ore", EURENITE_ORE_ITEM);
		registerItem("eurenite", EURENITE);
		registerBlock("eurenite_block", EURENITE_BLOCK);
		registerItem("eurenite_block", EURENITE_BLOCk_ITEM);
		registerItem("eurenite_pickaxe", EURENITE_PICKAXE);
		registerItem("eurenite_axe", EURENITE_AXE);
		registerItem("eurenite_sword", EURENITE_SWORD);
		registerItem("eurenite_hoe", EURENITE_HOE);
		registerItem("eurenite_shovel", EURENITE_SHOVEL);

		Registry.BIOME.forEach(this::handleBiome);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
	}

	private void registerItem(String path, Item item) {
		Registry.register(Registry.ITEM, new Identifier("dendromica_core", path), item);
	}

	private void registerBlock(String path, Block block) {
		Registry.register(Registry.BLOCK, new Identifier("dendromica_core", path), block);
	}
}
