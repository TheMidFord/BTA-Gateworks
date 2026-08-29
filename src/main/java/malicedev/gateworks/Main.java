package malicedev.gateworks;

//import malicedev.gateworks.cc.CCPlugin;
import malicedev.gateworks.recipes.workbench.WorkbenchRecipes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.dependency.Key;


import java.util.Properties;

public class Main implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("gateworks",true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static int itemId;
	public static int blockId;
	public static int meteorChance;
	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","9300");
		prop.setProperty("starting_item_id","32000");
		prop.setProperty("signalindustries_compat_naquadah_meteor_chance","2048");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		blockId = config.getInt("starting_block_id");
		itemId = config.getInt("starting_item_id");
		meteorChance = config.getInt("signalindustries_compat_naquadah_meteor_chance");

		config.updateConfig();
	}


	@Override
	public void onInitialize() {
		if (FabricLoaderImpl.INSTANCE.isModLoaded("signalindustries")){
			new SignalIndustriesCompat();
		}
		LOGGER.info("GateWorks initialized.");
		EntityHelper.addMapping(TileEntityHeadlessDHD.class,new NamespaceID(MOD_ID, "dhd_headless"));
		CommonEvents.AFTER_BLOCK_INIT.listen(Key.of(MOD_ID),ModBlocks::init);
		CommonEvents.RECIPES_READY.listen(Key.of(MOD_ID),WorkbenchRecipes::init);
		CommonEvents.RECIPES_NAMESPACE_INIT.listen(Key.of(MOD_ID),WorkbenchRecipes::initNamespaces);

	}


	public void onRecipesReady() {

	}


	public void initNamespaces() {}

	public void beforeGameStart() {
	}


	public void afterGameStart() {}

}
