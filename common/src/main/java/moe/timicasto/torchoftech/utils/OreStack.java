package moe.timicasto.torchoftech.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public class OreStack {
	public OreTypes.OreType type;
	public double mass;

	public OreStack(OreTypes.OreType type, double mass) {
		this.type = type;
		this.mass = mass;
	}

	public void insert(OreTypes.OreType type, double mass) {
		if (type.equals(this.type)) {
			this.mass += mass;
		}
	}

	public void insert(OreStack stack) {
		insert(stack.type, stack.mass);
	}

	public void shrink(double mass) {
		this.mass -= mass;
	}

	@Override
	public String toString() {
		return "{" + type.toString() + ", " + mass + "}";
	}

	public CompoundTag save() {
		CompoundTag tag = new CompoundTag();
		tag.putString("type", this.type.toString());
		tag.putDouble("mass", this.mass);
		return tag;
	}

	public static OreStack read(CompoundTag tag) {
		OreTypes.OreType type = OreTypes.OreType.byName(tag.getString("type"));
		double mass = tag.getDouble("mass");
		return new OreStack(type, mass);
	}
}
