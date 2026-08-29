package malicedev.gateworks.mixin;

import malicedev.gateworks.ModBlocks;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.pos.TilePos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sunsetsatellite.signalindustries.SIBlocks;
import sunsetsatellite.signalindustries.worldgen.WorldFeatureGeode;
import sunsetsatellite.signalindustries.worldgen.WorldFeatureMeteor;

import java.util.Random;

import static malicedev.gateworks.Main.meteorChance;


@Mixin(value = ChunkDecoratorOverworld.class, remap = false)
public class ChunkDecoratorOverworldMixin {
	@Shadow
	@Final
	private World world;
	@Inject(method = "decorate", at = @At(value = "TAIL"))
	public void decorate(Chunk chunk, CallbackInfo ci) {
		if (FabricLoaderImpl.INSTANCE.isModLoaded("signalindustries")) {
			int chunkX = chunk.pos.x;
			int chunkZ = chunk.pos.z;

			int minY = world.getWorldType().getMinY(world);
			int maxY = world.getWorldType().getMaxY(world);
			int rangeY = (maxY + 1) - minY;

			float oreHeightModifier = rangeY / 128f;
			int x = chunkX * 16;
			int z = chunkZ * 16;
			int y = world.getHeightValue(x + 16, z + 16);
			Random rand = new Random(world.getRandomSeed());
			long l1 = (rand.nextLong() / 2L) * 2L + 1L;
			long l2 = (rand.nextLong() / 2L) * 2L + 1L;
			rand.setSeed((long) chunkX * l1 + (long) chunkZ * l2 ^ world.getRandomSeed());
			if (meteorChance != 0) {
				if (rand.nextInt(meteorChance) == 0) {
					int i = x + rand.nextInt(16);
					int k = z + rand.nextInt(16);
					int j = world.getHeightValue(i, k);
					TilePos pos = new TilePos(i, j, k);
					new WorldFeatureMeteor(ModBlocks.OreNaquadahMeteoric.id(), 0, 5).place(world, rand, pos);
				}
			}
		}
	}
}
