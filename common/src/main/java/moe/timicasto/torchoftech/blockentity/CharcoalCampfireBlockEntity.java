package moe.timicasto.torchoftech.blockentity;

import moe.timicasto.torchoftech.TorchOfTech;
import moe.timicasto.torchoftech.TorchOfTechBlockEntities;
import moe.timicasto.torchoftech.TorchOfTechBlocks;
import moe.timicasto.torchoftech.TorchOfTechItems;
import moe.timicasto.torchoftech.block.CharcoalCampfireBlock;
import moe.timicasto.torchoftech.utils.OreStack;
import moe.timicasto.torchoftech.utils.OreTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharcoalCampfireBlockEntity extends BlockEntity {
	private int charcoal = 0;
	private boolean isLit = false;
	private final List<OreStack> oresIn = new ArrayList<>();
	private final List<ItemStack> drops = new ArrayList<>();
	private double temp = 30;


	public CharcoalCampfireBlockEntity(BlockPos pos, BlockState state) {
		super(TorchOfTechBlockEntities.CHARCOAL_CAMPFIRE_TE.get(), pos, state);
	}

	public void insertCharcoal() {
		charcoal += 1000;
		LogManager.getLogger().info("Inserted Fuel: " + charcoal);
	}

	public void insertOre(ItemStack stack) {
		if (OreTypes.CharcoalCampfireOres.isItemBelongs(stack.getItem()) && stack.hasTag()) {
			double mass = stack.getTag().getDouble("mass");
			for (OreStack oreStack : oresIn) {
				oreStack.insert(new OreStack(OreTypes.CharcoalCampfireOres.typeMap.get(stack.getItem()), mass));
				LogManager.getLogger().info("Inserted Ore: " + Arrays.toString(oresIn.toArray()));
				return;
			}
			oresIn.add(new OreStack(OreTypes.CharcoalCampfireOres.typeMap.get(stack.getItem()), mass));
			LogManager.getLogger().info("Inserted Ore: " + Arrays.toString(oresIn.toArray()));
		}
	}

	public void lit() {
		this.isLit = true;
	}

	public void unlit() {
		this.isLit = false;
	}

	public static void tick(Level level, BlockPos pos, BlockState state, CharcoalCampfireBlockEntity entity) {
		if (entity.temp > 900) {
			if (level.getBlockState(pos.above()).getBlock() != TorchOfTechBlocks.SOD.get() &&
					level.getBlockState(pos.north()).canOcclude() &&
					level.getBlockState(pos.east()).canOcclude() &&
					level.getBlockState(pos.west()).canOcclude() &&
					level.getBlockState(pos.south()).canOcclude() &&
					level.getBlockState(pos.below()).canOcclude()) {
				entity.temp -= 5;
			} else {
				if (entity.isLit) {
					if (entity.temp <= 1500) {
						entity.temp += TorchOfTech.RANDOM.nextDouble(0.5) + 0.2;
					}
				} else {
					if (entity.temp > 30) {
						entity.temp -= 2;
					}
				}
			}
		} else {
			if (entity.isLit) {
				entity.temp += 5;
			}
		}

		if (entity.isLit) {
			state.setValue(CharcoalCampfireBlock.LIT, true);
			if (entity.charcoal < 1) {
				entity.unlit();
				state.setValue(CharcoalCampfireBlock.LIT, false);
			} else {
				entity.charcoal -= 2;
			}
		} else {
			if (entity.temp > 30) {
				entity.temp -= 2;
			} else {
				entity.temp = 30;
			}
		}

		LogManager.getLogger().info("Temp now : " + entity.temp + ", Charcoal: " + entity.charcoal);
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		this.isLit = tag.getBoolean("lit");
		this.charcoal = tag.getInt("charcoal");
		this.temp = tag.getDouble("temp");
		for (Tag oreStacks : ((ListTag) (tag.get("oreStacks")))) {
			oresIn.add(OreStack.read((CompoundTag) oreStacks));
		}
		for (Tag drop : ((ListTag) (tag.get("drops")))) {
			drops.add(ItemStack.of((CompoundTag) drop));
		}
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.putBoolean("lit", isLit);
		tag.putDouble("temp", temp);
		tag.putInt("charcoal", charcoal);
		ListTag stacks = new ListTag();
		for (OreStack oreStack : oresIn) {
			stacks.add(oreStack.save());
		}
		tag.put("oreStacks", stacks);
		ListTag items = new ListTag();
		for (ItemStack drop : drops) {
			CompoundTag it = new CompoundTag();
			it = drop.save(it);
			items.add(it);
		}
		tag.put("drops", items);
	}

	public boolean isLit() {
		return isLit;
	}

	public ItemStack getDrop() {
		List<OreStack> outs = new ArrayList<>();
		for (OreStack oreStack : oresIn) {
			double rate = OreTypes.getReductionRate(oreStack.type, temp);
			double outMass = oreStack.mass * rate;
			outs.add(new OreStack(oreStack.type, outMass));
		}
		ItemStack ret = new ItemStack(TorchOfTechItems.ASH.get(), 1);
		ListTag list = new ListTag();
		for (OreStack out : outs) {
			list.add(out.save());
		}
		ret.addTagElement("contents", list);
		return ret;
	}
}
