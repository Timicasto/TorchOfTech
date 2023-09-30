package moe.timicasto.torchoftech.item;

import moe.timicasto.torchoftech.TorchOfTechTabs;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.text.NumberFormat;
import java.util.List;

public class AzuriteFragmentItem extends Item {

	public AzuriteFragmentItem() {
		super(new Properties().tab(TorchOfTechTabs.MISC).stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		if (stack.hasTag()) {
			NumberFormat format = NumberFormat.getInstance();
			tooltipComponents.add(new TextComponent(String.format("%s: %s", I18n.get("tooltip.copper_density"), format.format(stack.getTag().getDouble("mass")))));
		} else {
			tooltipComponents.add(new TextComponent(I18n.get("tooltip.no_copper")));
		}
	}
}
