
package com.monkeysquad.retailnightmare.client.renderer;

public class MopBucketRenderer extends MobRenderer<MopBucketEntity, Modelmop_bucket<MopBucketEntity>> {
	public MopBucketRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmop_bucket<MopBucketEntity>(context.bakeLayer(Modelmop_bucket.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(MopBucketEntity entity) {
		return ResourceLocation.parse("retail_nightmare:textures/entities/mop_bucket.png");
	}
}