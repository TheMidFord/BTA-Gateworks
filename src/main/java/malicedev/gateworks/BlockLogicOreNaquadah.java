package malicedev.gateworks;

import gungun974.stargate.StargateItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicOreNaquadah extends BlockLogic {

	public BlockLogicOreNaquadah(@NotNull Block<?> block, @NotNull Material material) {
		super(block, material);
	}

	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		ItemStack[] droppedItem;
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				droppedItem = new ItemStack[]{new ItemStack(this)};
				break;
			case EXPLOSION:
			case PROPER_TOOL:
			case PISTON_CRUSH:
				droppedItem = new ItemStack[]{new ItemStack(StargateItems.NAQUADAH)};
				break;
			default:
				droppedItem = null;
		}

		return droppedItem;
	}
}
