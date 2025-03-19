package com.monkeysquad.retailnightmare.procedures;

import net.minecraft.world.entity.Entity;

import com.monkeysquad.retailnightmare.entity.MopBucketEntity;

public class MopBucketRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.isShiftKeyDown()) {
			if (entity instanceof MopBucketEntity _datEntSetS)
				_datEntSetS.getEntityData().set(MopBucketEntity.DATA_follows, "no one");
		} else if (!((sourceentity.getStringUUID()).equals(entity instanceof MopBucketEntity _datEntS ? _datEntS.getEntityData().get(MopBucketEntity.DATA_follows) : ""))) {
			if (entity instanceof MopBucketEntity _datEntSetS)
				_datEntSetS.getEntityData().set(MopBucketEntity.DATA_follows, (sourceentity.getStringUUID()));
		}
	}
}
