
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.monkeysquad.retailnightmare.RetailNightmareMod;

public class RetailNightmareModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RetailNightmareMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RETAIL_NIGHTMARE = REGISTRY.register("retail_nightmare",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.retail_nightmare.retail_nightmare")).icon(() -> new ItemStack(RetailNightmareModItems.BOXITEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RetailNightmareModItems.BOXITEM.get());
				tabData.accept(RetailNightmareModItems.MOP_BUCKET_SPAWN.get());
				tabData.accept(RetailNightmareModBlocks.BOX_PACKAGER.get().asItem());
			}).build());
}
