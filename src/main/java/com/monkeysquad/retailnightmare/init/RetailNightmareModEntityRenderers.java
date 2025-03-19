
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.monkeysquad.retailnightmare.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.monkeysquad.retailnightmare.client.renderer.MopBucketRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RetailNightmareModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(RetailNightmareModEntities.MOP_BUCKET.get(), MopBucketRenderer::new);
	}
}
