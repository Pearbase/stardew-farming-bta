package luke.stardew.blocks;

import luke.stardew.items.StardewItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.season.Seasons;

import java.util.Random;

public class BlockCropsTomato extends BlockFlower implements IBonemealable {
	public BlockCropsTomato(String key, int id) {
		super(key, id);
		this.setTicking(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	}

	public boolean canThisPlantGrowOnThisBlockID(int i) {
		return i == Block.farmlandDirt.id;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		if (world.seasonManager.getCurrentSeason() == Seasons.OVERWORLD_SUMMER) {
			if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				int l = world.getBlockMetadata(x, y, z);
				if (l < 5) {
					float f = this.getGrowthRate(world, x, y, z);
					if (rand.nextInt((int) (100.0F / f)) == 0) {
						++l;
						world.setBlockMetadataWithNotify(x, y, z, l);
					}
				}
			}
		}
	}

	public void fertilize(World world, int i, int j, int k) {
		world.setBlockMetadataWithNotify(i, j, k, 5);
	}

	private float getGrowthRate(World world, int x, int y, int z) {
		float growthRate = 1.0F;
		int idNegZ = world.getBlockId(x, y, z - 1);
		int idPosZ = world.getBlockId(x, y, z + 1);
		int idNegX = world.getBlockId(x - 1, y, z);
		int idPosX = world.getBlockId(x + 1, y, z);
		int idNegXNegZ = world.getBlockId(x - 1, y, z - 1);
		int idPosXNegZ = world.getBlockId(x + 1, y, z - 1);
		int idPosXPosZ = world.getBlockId(x + 1, y, z + 1);
		int idNegXPosZ = world.getBlockId(x - 1, y, z + 1);
		boolean xNeighbor = idNegX == this.id || idPosX == this.id;
		boolean zNeighbor = idNegZ == this.id || idPosZ == this.id;
		boolean diagNeighbor = idNegXNegZ == this.id || idPosXNegZ == this.id || idPosXPosZ == this.id || idNegXPosZ == this.id;

		for(int dx = x - 1; dx <= x + 1; ++dx) {
			for(int dz = z - 1; dz <= z + 1; ++dz) {
				int id = world.getBlockId(dx, y - 1, dz);
				float growthRateMod = 0.0F;
				if (id == Block.farmlandDirt.id) {
					growthRateMod = 1.0F;
					if (world.getBlockMetadata(dx, y - 1, dz) > 0) {
						growthRateMod = 3.0F;
					}
				}

				if (dx != x || dz != z) {
					growthRateMod /= 4.0F;
				}

				growthRate += growthRateMod;
			}
		}

		if (diagNeighbor || xNeighbor && zNeighbor) {
			growthRate /= 2.0F;
		}

		if (world.seasonManager.getCurrentSeason() != null) {
			growthRate *= world.seasonManager.getCurrentSeason().cropGrowthFactor;
		}

		return growthRate;
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return meta != 5 ? new ItemStack[]{new ItemStack(StardewItems.seedsTomato)} : new ItemStack[]{new ItemStack(StardewItems.seedsTomato, world.rand.nextInt(3) + 1), new ItemStack(StardewItems.tomato)};
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, EntityPlayer player, Side side, double xHit, double yHit) {
		int l = world.getBlockMetadata(x, y, z);
		if (l == 5) {
			world.setBlockMetadataWithNotify(x, y, z, 3);
			world.playSoundEffect(player, SoundCategory.WORLD_SOUNDS, (double)x + 0.5, (double)y + 0.5, (double)z + 0.5, "random.pop", 0.3F, 1.0f);
			world.dropItem(x, y, z, new ItemStack(StardewItems.tomato, world.rand.nextInt(1) + 1));
		}
		return false;
	}

	public boolean onBonemealUsed(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (world.getBlockMetadata(blockX, blockY, blockZ) < 5) {
			if (!world.isClientSide) {
				((BlockCropsTomato)StardewBlocks.cropsTomato).fertilize(world, blockX, blockY, blockZ);
				if (entityplayer.getGamemode().consumeBlocks()) {
					--itemstack.stackSize;
				}
			}

			return true;
		} else {
			return false;
		}
	}
}
