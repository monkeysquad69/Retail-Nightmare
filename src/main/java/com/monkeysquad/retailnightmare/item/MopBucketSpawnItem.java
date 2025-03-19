
package com.monkeysquad.retailnightmare.item;

public class MopBucketSpawnItem extends Item {
	public MopBucketSpawnItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		MopBucketSpawnRightclickedProcedure.execute();
		return ar;
	}
}