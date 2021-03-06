package dendromica_core;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
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

import static dendromica_core.DendromicaCoreBiomes.*;
import static dendromica_core.DendromicaCoreItems.*;


public class Erratica implements ModInitializer {
	private void handleBiome(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									EURENITE_ORE.getBlock().getDefaultState(),
									4 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									3, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									24 //Max y level
							))));
		}
	}

	@Override
	public void onInitialize() {
		registerBlockItem("eurenite_ore", EURENITE_ORE);
		registerItem("eurenite", EURENITE);
		registerBlockItem("eurenite_block", EURENITE_BLOCK);
		registerItem("eurenite_pickaxe", EURENITE_PICKAXE);
		registerItem("eurenite_axe", EURENITE_AXE);
		registerItem("eurenite_sword", EURENITE_SWORD);
		registerItem("eurenite_hoe", EURENITE_HOE);
		registerItem("eurenite_shovel", EURENITE_SHOVEL);
		registerItem("eurenite_helmet", EURENITE_HELMET);
		registerItem("eurenite_chestplate", EURENITE_CHESTPLATE);
		registerItem("eurenite_leggings", EURENITE_LEGGINGS);
		registerItem("eurenite_boots", EURENITE_BOOTS);
		registerBlockItem("infuser", INFUSER);
		INFUSER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "dendromica_core:infuser", BlockEntityType.Builder.create(InfuserEntity::new, INFUSER.getBlock()).build(null));
		EURENITE_PLAINS = registerBiome("eurenite_plains", new EurenitePlains());
		Registry.BIOME.forEach(this::handleBiome);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
	}

	private void registerItem(String path, Item item) {
		Registry.register(Registry.ITEM, new Identifier("dendromica_core", path), item);
	}

	private void registerBlockItem(String path, BlockItem item) {
		registerItem(path, item);
		registerBlock(path, item.getBlock());
	}

	private void registerBlock(String path, Block block) {
		Registry.register(Registry.BLOCK, new Identifier("dendromica_core", path), block);
	}

	private Biome registerBiome(String path, Biome biome){
		return Registry.register(Registry.BIOME, new Identifier("dendromica_core", path), biome);
	}
}
