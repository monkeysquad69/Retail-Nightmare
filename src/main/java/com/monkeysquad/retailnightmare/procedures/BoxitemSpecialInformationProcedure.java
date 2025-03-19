package com.monkeysquad.retailnightmare.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class BoxitemSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		String result = "";
		result = "contains: ";
		if (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("row1")).equals("empty")) {
			result = result + "" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("row1");
		}
		if (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("row2")).equals("empty")) {
			result = result + "" + (", " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("row2"));
		}
		if (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("row3")).equals("empty")) {
			result = result + "" + (", " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("row3"));
		}
		return result;
	}
}
