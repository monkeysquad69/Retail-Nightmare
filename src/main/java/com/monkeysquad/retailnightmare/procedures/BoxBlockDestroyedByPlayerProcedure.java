package com.monkeysquad.retailnightmare.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import com.monkeysquad.retailnightmare.init.RetailNightmareModItems;

public class BoxBlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		ItemStack box = ItemStack.EMPTY;
		double i = 0;
		box = new ItemStack(RetailNightmareModItems.BOXITEM.get()).copy();
		i = 0;
		for (int index0 = 0; index0 < 15; index0++) {
			{
				final String _tagName = ("ammount" + i);
				final double _tagValue = (new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).getCount();
						}
						return 0;
					}
				}.getAmount(world, BlockPos.containing(x, y, z), (int) i));
				CustomData.update(DataComponents.CUSTOM_DATA, box, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString(("item" + i)));
				final String _tagValue = (BuiltInRegistries.ITEM.getKey((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						if (world instanceof ILevelExtension _ext) {
							IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
							if (_itemHandler != null)
								return _itemHandler.getStackInSlot(slotid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) i)).getItem()).toString());
				CustomData.update(DataComponents.CUSTOM_DATA, box, tag -> tag.putString(_tagName, _tagValue));
			}
			i = i + 1;
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, box);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
