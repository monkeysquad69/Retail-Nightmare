
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.monkeysquad.retailnightmare.RetailNightmareMod;

public class RetailNightmareModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, RetailNightmareMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MOP_BUCKET_STEP = REGISTRY.register("mop_bucket_step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("retail_nightmare", "mop_bucket_step")));
}
