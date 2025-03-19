
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import com.monkeysquad.retailnightmare.world.inventory.BoxGUIMenu;
import com.monkeysquad.retailnightmare.RetailNightmareMod;

public class RetailNightmareModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, RetailNightmareMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<BoxGUIMenu>> BOX_GUI = REGISTRY.register("box_gui", () -> IMenuTypeExtension.create(BoxGUIMenu::new));
}
