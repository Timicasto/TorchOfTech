package moe.timicasto.torchoftech.utils;

import moe.timicasto.torchoftech.TorchOfTechItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;
import java.util.Map;

public abstract class OreTypes {

	public enum OreType {
		COPPER;

		public static OreType byName(String str) {
			return OreType.valueOf(str);
		}
	}

	public static double getReductionRate(OreType type, double temp) {
		switch (type) {
			case COPPER -> {
				if (Utils.isTempIn(temp, 100, 200)) {
					return temp * 5e-5;
				} else if (Utils.isTempIn(temp, 200, 250)) {
					return temp * 4e-4 - 0.07;
				} else if (Utils.isTempIn(temp, 250, 700)) {
					return temp * 1.55e-4 - 0.0089;
				} else if (Utils.isTempIn(temp, 700, 750)) {
					return temp * 0.001 - 0.6;
				} else if (Utils.isTempIn(temp, 750, 800)) {
					return temp * 6e-4 - 0.3;
				} else if (Utils.isTempIn(temp, 800, 850)) {
					return temp * 0.0014 - 0.94;
				} else if (Utils.isTempIn(temp, 850, 900)) {
					return temp * 5e-4 - 0.175;
				} else if (Utils.isTempIn(temp, 900, 1200)) {
					return temp * 1.5e-4 + 0.14;
				} else if (Utils.isTempIn(temp, 1200, 1400)) {
					return temp * 6.5e-4 - 0.46;
				} else if (Utils.isTempIn(temp, 1400, 1500)) {
					return temp * 2.5e-4 + 0.1;
				} else if (temp > 1500) {
					return 0.475;
				}
			}
		}
		return 0;
	}

	public static Item getSmeltsItem(OreType type) {
		switch (type) {
			case COPPER -> {
				return TorchOfTechItems.COPPER_NUGGET.get();
			}
			default -> {
				return Items.AIR;
			}
		}
	}

	public static final class CharcoalCampfireOres extends OreTypes {
		public static final OreType COPPER = OreType.COPPER;

		public static Map<Item, OreType> typeMap = new HashMap<>();

		static {
			typeMap.put(TorchOfTechItems.AZURITE_FRAGMENT.get(), COPPER);
			typeMap.put(TorchOfTechItems.CHALCOCITE_FRAGMENT.get(), COPPER);
			typeMap.put(TorchOfTechItems.MALACHITE_FRAGMENT.get(), COPPER);
		}

		public static boolean isItemBelongs(Item item) {
			return typeMap.containsKey(item);
		}
	}
}
