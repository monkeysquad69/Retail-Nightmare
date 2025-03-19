
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import com.monkeysquad.retailnightmare.block.BoxBlock;
import com.monkeysquad.retailnightmare.RetailNightmareMod;

public class RetailNightmareModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(RetailNightmareMod.MODID);
	public static final DeferredBlock<Block> BOX = REGISTRY.register("box", BoxBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
