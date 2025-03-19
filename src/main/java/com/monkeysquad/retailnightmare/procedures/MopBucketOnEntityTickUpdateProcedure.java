package com.monkeysquad.retailnightmare.procedures;

import net.neoforged.bus.api.Event;

public class MopBucketOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean indistance = false;
		indistance = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator.getStringUUID()).equals(entity instanceof MopBucketEntity _datEntS ? _datEntS.getEntityData().get(MopBucketEntity.DATA_follows) : "")) {
					indistance = true;
				}
			}
		}
		if (indistance == false) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.getStringUUID()).equals(entity instanceof MopBucketEntity _datEntS ? _datEntS.getEntityData().get(MopBucketEntity.DATA_follows) : "")) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1);
				}
			}
		}
	}
}
