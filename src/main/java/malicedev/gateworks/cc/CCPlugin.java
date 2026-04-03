package malicedev.gateworks.cc;

import dan200.computercraft.api.ComputerCraftAPI;
import gungun974.stargate.dhd.cc.DHDPeripheral;
import malicedev.gateworks.TileEntityHeadlessDHD;
import net.minecraft.core.block.entity.TileEntity;

public class CCPlugin {
	public static void register() {
		ComputerCraftAPI.registerPeripheralProvider((world, pos, side) -> {
			TileEntity tile = world.getTileEntity(pos.x, pos.y, pos.z);
			if (tile instanceof TileEntityHeadlessDHD) {
				return new DHDPeripheral((TileEntityHeadlessDHD) tile);
			}
			return null;
		});

	}
}
