package moe.timicasto.torchoftech;

import moe.timicasto.torchoftech.levelgen.Generations;

import java.util.Random;

public class TorchOfTech
{
	public static final String MOD_ID = "torchoftech";
	public static Random RANDOM = new Random();

	public static void init() {
		System.out.println("Loading Torch of Light Dev-0.0.1");
		TorchOfTechBlocks.registerBlocks();
		TorchOfTechItems.registerItems();
		TorchOfTechBlockEntities.registerBlockEntities();
		TorchOfTechEntities.registerEntities();
	}
}
