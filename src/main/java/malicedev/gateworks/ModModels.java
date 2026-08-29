package malicedev.gateworks;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.util.helper.Side;


public class ModModels  {

	public void initBlockModels(BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(new BlockModelHorizontalRotation<>(ModBlocks.HeadlessDHD)
			.setTex("gateworks:block/headless_dhd_top", Side.TOP,Side.BOTTOM)
			.setTex("gateworks:block/headless_dhd_front", Side.NORTH,Side.SOUTH)
			.setTex("gateworks:block/headless_dhd_side", Side.WEST,Side.EAST)

		);

		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.OreNaquadahMeteoric)
				.setAllTextures("gateworks:block/naquadah_ore")
			);
	}


	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {

	}

	public void initEntityModels(EntityRendererDispatcher entityRenderDispatcher) {

	}


	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}


	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
