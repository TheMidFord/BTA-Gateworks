package malicedev.gateworks;

import malicedev.gateworks.cc.CCPlugin;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;

public class Main implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "gateworks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static int itemId;
	public static int blockId;
	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","9300");
		prop.setProperty("starting_item_id","32000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		blockId = config.getInt("starting_block_id");
		itemId = config.getInt("starting_item_id");

		config.updateConfig();
	}
	@Override
	public void onInitialize() {
		LOGGER.info("GateWorks initialized.");
		ModBlocks.init();

		try {
			Class.forName("dan200.computercraft.api.ComputerCraftAPI");
			registerCCPlugin();
		} catch (ClassNotFoundException ignored){}

	}

	@Override
	public void onRecipesReady() {}

	@Override
	public void initNamespaces() {}

	@Override
	public void beforeGameStart() {
	}

	@Override
	public void afterGameStart() {}

	private void registerCCPlugin() {
		CCPlugin.register();
	}
}
