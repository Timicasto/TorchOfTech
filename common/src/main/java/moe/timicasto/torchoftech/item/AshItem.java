package moe.timicasto.torchoftech.item;

import moe.timicasto.torchoftech.TorchOfTechTabs;
import moe.timicasto.torchoftech.entity.AshEntity;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AshItem extends Item {
	public AshItem() {
		super(new Properties().tab(TorchOfTechTabs.MISC));
	}

/*	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
		if (stack.hasTag()) {
			tooltipComponents.add(new TextComponent(I18n.get()))
		} else {
			tooltipComponents.add(new TextComponent(I18n.get("tooltip.no_content")));
		}
	}*/
}
