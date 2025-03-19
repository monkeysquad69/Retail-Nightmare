
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import com.monkeysquad.retailnightmare.item.MopBucketSpawnItem;
import com.monkeysquad.retailnightmare.item.BoxitemItem;
import com.monkeysquad.retailnightmare.RetailNightmareMod;

public class RetailNightmareModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(RetailNightmareMod.MODID);
	public static final DeferredItem<Item> BOXITEM = REGISTRY.register("boxitem", BoxitemItem::new);
	public static final DeferredItem<Item> MOP_BUCKET_SPAWN = REGISTRY.register("mop_bucket_spawn", MopBucketSpawnItem::new);
	public static final DeferredItem<Item> BOX_PACKAGER = block(RetailNightmareModBlocks.BOX_PACKAGER);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
