package dendromica_core;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
		Registry.register(Registry.ITEM, new Identifier("dendromica_core","eurenite_pickaxe"), EURENITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("dendromica_core","eurenite_axe"), EURENITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("dendromica_core","eurenite_sword"), EURENITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("dendromica_core","eurenite_hoe"), EURENITE_HOE);
		Registry.register(Registry.ITEM, new Identifier("dendromica_core","eurenite_shovel"), EURENITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("dendromica_core", "eurenite"), EURENITE);
		Registry.register(Registry.ITEM, new Identifier("dendromica_core", "eurenite_block"), new BlockItem(EURENITE_BLOCK, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier("dendromica_core", "eurenite_ore"), new BlockItem(EURENITE_ORE, new Item.Settings()));
		Registry.register(Registry.BLOCK, new Identifier("dendromica_core", "eurenite_block"), EURENITE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("dendromica_core", "eurenite_ore"), EURENITE_ORE);
		Registry.BIOME.forEach(this::handleBiome);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
	}
}
