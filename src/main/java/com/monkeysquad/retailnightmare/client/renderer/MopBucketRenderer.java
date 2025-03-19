
package com.monkeysquad.retailnightmare.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.monkeysquad.retailnightmare.entity.MopBucketEntity;
import com.monkeysquad.retailnightmare.client.model.Modelmop_bucket;

public class MopBucketRenderer extends MobRenderer<MopBucketEntity, Modelmop_bucket<MopBucketEntity>> {
	public MopBucketRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmop_bucket<MopBucketEntity>(context.bakeLayer(Modelmop_bucket.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(MopBucketEntity entity) {
		return ResourceLocation.parse("retail_nightmare:textures/entities/mop_bucket.png");
	}
}
