package malicedev.gateworks.recipes.workbench;
import gungun974.stargate.StargateItems;
import malicedev.gateworks.ModBlocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;

import static malicedev.gateworks.Main.MOD_ID;

public class WorkbenchRecipes {
	private WorkbenchRecipes() {}

	public static void init() {
		RecipeBuilder.Shaped(MOD_ID,"SQS","SNS","SDS")
			.addInput('S', Items.INGOT_STEEL)
			.addInput('Q', Items.QUARTZ)
			.addInput('N', StargateItems.NAQUADAH_CRUDE_ALLOY)
			.addInput('D',Items.DIAMOND)
			.create("headless_dhd", new ItemStack(ModBlocks.HeadlessDHD));
	}
}
