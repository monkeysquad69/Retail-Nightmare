
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import com.monkeysquad.retailnightmare.block.BoxPackagerBlock;
import com.monkeysquad.retailnightmare.RetailNightmareMod;

public class RetailNightmareModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(RetailNightmareMod.MODID);
	public static final DeferredBlock<Block> BOX_PACKAGER = REGISTRY.register("box_packager", BoxPackagerBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
