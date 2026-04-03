package malicedev.gateworks;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;

import static malicedev.gateworks.Main.MOD_ID;
import static malicedev.gateworks.Main.blockId;

public class ModBlocks {
	private ModBlocks() {}

	public static Block<?> HeadlessDHD;

	public static void init(){

		EntityHelper.createTileEntity(TileEntityHeadlessDHD.class, NamespaceID.getPermanent(MOD_ID, "dhd_headless"));

		HeadlessDHD = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.METAL)
			.setHardness(2)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			.setTileEntity(TileEntityHeadlessDHD::new)
			.build("headless_dhd","headless_dhd",blockId++,(block) -> new BlockLogicHeadlessDHD(block, Material.metal));
	}
}
