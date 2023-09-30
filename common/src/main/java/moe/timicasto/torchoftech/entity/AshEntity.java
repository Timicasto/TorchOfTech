package moe.timicasto.torchoftech.entity;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.injectables.annotations.PlatformOnly;
import dev.architectury.injectables.targets.ArchitecturyTarget;
import moe.timicasto.torchoftech.TorchOfTechEntities;
import moe.timicasto.torchoftech.utils.OreStack;
import moe.timicasto.torchoftech.utils.OreTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AshEntity extends ItemEntity {

	public AshEntity(EntityType<? extends ItemEntity> entityEntityType, Level level) {
		super(entityEntityType, level);
	}

	public AshEntity(Level level, double d, double e, double f, ItemStack itemStack) {
		super(level, d, e, f, itemStack);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.isInWater()) {
			var stack = this.getItem();
			if (stack.hasTag()) {
				for (Tag contents : ((ListTag) (stack.getTag().get("contents")))) {
					OreStack o = OreStack.read((CompoundTag) contents);
					int amount = (int) Math.floor(o.mass / 16);
					if (amount >= 1) {
						Item item = OreTypes.getSmeltsItem(o.type);
						int groups = (int) Math.floor(amount / 64);
						if (groups >= 1) {
							amount %= 64;
						}
						for (int i = 0; i < groups; i++) {
							ItemStack st = new ItemStack(item, 64);
							level.addFreshEntity(new ItemEntity(level, position().x, position().y, position().z, st));
						}
						ItemStack st = new ItemStack(item, amount);
						level.addFreshEntity(new ItemEntity(level, position().x, position().y, position().z, st));
					}
				}
			}
			this.kill();
		}
	}
}
