package malicedev.gateworks;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import static malicedev.gateworks.Main.MOD_ID;
import static malicedev.gateworks.Main.blockId;

public class ModBlocks {
	private ModBlocks() {}

	public static Block<?> HeadlessDHD;
	public static Block<?> OreNaquadahMeteoric;

	public static void init(){


		HeadlessDHD = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.METAL)
			.setHardness(2)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			.setTileEntity(TileEntityHeadlessDHD::new)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build("headless_dhd","headless_dhd",blockId++,(block) -> new BlockLogicHeadlessDHD(block, Materials.METAL));

		OreNaquadahMeteoric = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.STONE)
			.setHardness(3)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build("meteoric_naquadah_ore","naquadah_ore",blockId++,(block -> new BlockLogicOreNaquadah(block,Materials.STONE)));
	}


}

