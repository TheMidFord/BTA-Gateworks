package malicedev.gateworks;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.util.ModelEntrypoint;

public class ModModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(new BlockModelHorizontalRotation<>(ModBlocks.HeadlessDHD)
			.setTex(0, "gateworks:block/headless_dhd_top", Side.TOP,Side.BOTTOM)
			.setTex(0, "gateworks:block/headless_dhd_front", Side.NORTH,Side.SOUTH)
			.setTex(0, "gateworks:block/headless_dhd_side", Side.WEST,Side.EAST)

		);
	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
