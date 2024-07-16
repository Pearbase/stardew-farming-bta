package luke.stardew.blocks;

import luke.stardew.StardewConfig;
import luke.stardew.blocks.model.*;
import net.minecraft.client.render.block.model.*;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockCake;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockLeaves;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.stardew.StardewMod.MOD_ID;

public class StardewBlocks {
	private int blockID(String blockName) {
		return StardewConfig.cfg.getInt("Block IDs." + blockName);
	}

	//Spring Crops
	public static Block cropsCarrot;

	public static Block cropsBlueberry;
	public static Block cropsPineapple;

	//Summer Crops
	public static Block cropsTomato;
	public static Block cropsPotato;

	public static Block cropsStrawberry;
	public static Block cropsWatermelon;
	public static Block watermelon;

	//Fall Crops
	public static Block logApple;
	public static Block leavesApple;
	public static Block leavesAppleFlowering;
	public static Block saplingApple;

	public static Block logAppleGolden;
	public static Block leavesAppleGolden;
	public static Block leavesAppleGoldenFlowering;
	public static Block saplingAppleGolden;

	public static Block cropsCornBottom;
	public static Block cropsCornTop;

	public static Block cropsGrapeBottom;
	public static Block cropsGrapeTop;

	//Winter Crops

	public static Block cropsCauliflower;
	public static Block cauliflower;

	public static Block cropsCranberries;


	public static Block bush;

	public static Block plantStake;

	public static Block beehiveIdle;
	public static Block beehiveHoney;

	public static Block blockHoney;

	public static Block cakeChocolate;
	public static Block pie;

	public static Block beehive;

	public static Block pizza;

	public static Block candle;
	public static Block candleActive;

	private void initializeBlockDetails() {

	}

	public void initializeBlocks() {

		BlockBuilder crops = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCrossedSquares::new)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU);

		BlockBuilder cropsBlock = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCropsPumpkin::new)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.OVERRIDE_STEPSOUND);

		BlockBuilder blocks = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(1.0F)
			.setResistance(1.0F)
			.setTags(BlockTags.MINEABLE_BY_AXE);

		BlockBuilder leaves = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.2F)
			.setResistance(0.2F)
			.setFlammability(30, 60)
			.setTickOnLoad()
			.setVisualUpdateOnMetadata()
			.setItemBlock(ItemBlockLeaves::new)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH);

		BlockBuilder sapling = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setBlockModel(BlockModelCrossedSquares::new)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR);

		BlockBuilder log = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(2.0F)
			.setResistance(1.0f)
			.setFlammability(5, 5)
			.setBlockModel(BlockModelAxisAligned::new)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT);

		BlockBuilder wood = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(2.5f)
			.setResistance(1.0f)
			.setFlammability(5, 5)
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT);

		BlockBuilder metal = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.stone", "step.stone", 1.0f, 1.5f))
			.setHardness(5.0f)
			.setResistance(10.0f)
			.setTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CHAINLINK_FENCES_CONNECT);



		//Spring Crops

		// Spring Tree
		// Cherry Tree

		// Spring Vegetables
		cropsCarrot = crops
			.setBlockModel(BlockModelCropsCarrot::new)
			.build(new BlockCropsCarrot("crops.carrot", blockID("cropsCarrot")));


		// Spring Fruits
		cropsBlueberry = crops
			.setBlockModel(BlockModelCropsBlueberry::new)
			.build(new BlockCropsBlueberry("crops.blueberry", blockID("cropsBlueberry")));

		cropsPineapple = crops
			.setBlockModel(BlockModelCropsPineapple::new)
			.build(new BlockCropsPineapple("crops.pineapple", blockID("cropsPineapple")));


		//Summer Crops

		// Summer Tree


		// Summer Vegetables
		cropsTomato = crops
			.setBlockModel(BlockModelCropsTomato::new)
			.build(new BlockCropsTomato("crops.tomato", blockID("cropsTomato")));

		cropsPotato = crops
			.setBlockModel(BlockModelCropsPotato::new)
			.build(new BlockCropsPotato("crops.potato", blockID("cropsPotato")));

		// Summer Fruits

		cropsStrawberry = crops
			.setBlockModel(BlockModelCropsStrawberry::new)
			.build(new BlockCropsStrawberry("crops.strawberry", blockID("cropsStrawberry")));

		cropsWatermelon = cropsBlock
			.setBlockModel(BlockModelCropsWatermelon::new)
			.build(new BlockCropsWatermelon("crops.watermelon", blockID("cropsWatermelon")));
		watermelon = blocks
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("stardew:block/watermelon_top", "stardew:block/watermelon_side"))
			.build(new Block("watermelon", blockID("watermelon"), Material.vegetable));


		//Fall Crops
		cropsCornBottom = crops
			.setBlockModel(BlockModelCropsCornBottom::new)
			.build(new BlockCropsCornBottom("crops.corn.bottom", blockID("cropsCornBottom")));

		cropsCornTop = crops
			.setBlockModel(BlockModelCropsCornTop::new)
			.build(new BlockCropsCornTop("crops.corn.top", blockID("cropsCornTop")));


		cropsGrapeBottom = crops
			.setBlockModel(BlockModelCropsGrapesBottom::new)
			.build(new BlockCropsGrapeBottom("crops.grape.bottom", blockID("cropsGrapeBottom")));

		cropsGrapeTop = crops
			.setBlockModel(BlockModelCropsGrapesTop::new)
			.build(new BlockCropsGrapeTop("crops.grape.top", blockID("cropsGrapeTop")));


		// Fall Tree
		logApple = log
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("stardew:block/log_apple_top", "stardew:block/log_apple_side"))
			.build(new BlockLog("log.apple", blockID("logApple")));
		leavesApple = leaves
			.setBlockModel(block -> new BlockModelLeaves<>(block, "stardew:block/leaves_apple"))
			.build(new BlockLeavesApple("leaves.apple", blockID("leavesApple")));
		leavesAppleFlowering = leaves
			.setBlockModel(BlockModelAppleLeavesBloom::new)
			.build(new BlockLeavesAppleFlowering("leaves.apple.flowering", blockID("leavesAppleFlowering")));
		saplingApple = sapling
			.setBlockModel(block -> new BlockModelCrossedSquares<>(block).withTextures("stardew:block/sapling_apple"))
			.build(new BlockSaplingApple("sapling.apple", blockID("saplingApple")));

		logAppleGolden = log
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("stardew:block/log_apple_golden_top", "stardew:block/log_apple_golden_side"))
			.build(new BlockLog("log.apple.golden", blockID("logAppleGolden")));
		leavesAppleGolden = leaves
			.setBlockModel(block -> new BlockModelLeaves<>(block, "stardew:block/leaves_apple_golden"))
			.build(new BlockLeavesAppleGolden("leaves.apple.golden", blockID("leavesAppleGolden")));
		leavesAppleGoldenFlowering = leaves
			.setBlockModel(BlockModelGoldenAppleLeavesBloom::new)
			.build(new BlockLeavesAppleGoldenFlowering("leaves.apple.flowering", blockID("leavesAppleGoldenFlowering")));
		saplingAppleGolden = sapling
			.setBlockModel(block -> new BlockModelCrossedSquares<>(block).withTextures("stardew:block/sapling_apple_golden"))
			.build(new BlockSaplingAppleGolden("sapling.apple.golden", blockID("saplingAppleGolden")));


		//Winter Crops
		cropsCauliflower = cropsBlock
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.OVERRIDE_STEPSOUND, BlockTags.PLANTABLE_IN_JAR)
			.setBlockModel(BlockModelCropsCauliflower::new)
			.build(new BlockCropsCauliflower("crops.cauliflower", blockID("cropsCauliflower")));
		cauliflower = blocks
			.setBlockModel(block -> new BlockModelAxisAligned<>(block).withTextures("stardew:block/cauliflower_bottom", "stardew:block/cauliflower_top", "stardew:block/cauliflower_side"))
			.build(new Block("cauliflower", blockID("cauliflower"), Material.vegetable));


		cropsCranberries = crops
			.setBlockModel(BlockModelCropsCranberry::new)
			.build(new BlockCropsCranberries("crops.cranberries", blockID("cropsCranberries")));


		plantStake = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.0f))
			.setHardness(2.0F)
			.setResistance(1.0f)
			.setFlammability(5, 5)
			.build(new BlockPlantStake("plantstake", blockID("plantStake"), Material.wood));



		bush = crops
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.MINEABLE_BY_SHEARS)
			.setTicking(true)
			.setTickOnLoad()
			.setBlockModel(BlockModelBush::new)
			.build(new BlockBush("bush", blockID("bush")));


		beehiveIdle = wood
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT, BlockTags.NOT_IN_CREATIVE_MENU)
			.setTopBottomTextures("stardew:block/beehive_top")
			.setSideTextures("stardew:block/beehive_side")
			.setNorthTexture("stardew:block/beehive_idle")
			.setBlockModel((block) -> {
				TextureRegistry.getTexture(MOD_ID + ":item/bee");
				return new BlockModelHorizontalRotation<>(block);
			})
			//.setBlockModel(block -> new BlockModelHorizontalRotation<>(block).withTextures("stardew:block/beehive_top", "stardew:block/beehive_top", "stardew:block/beehive_idle", "stardew:block/beehive_side", "stardew:block/beehive_side", "stardew:block/beehive_side"))
			.build(new BlockBeehiveActive("beehive.idle", blockID("beehiveIdle"), false));

		beehiveHoney = wood
			.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT, BlockTags.NOT_IN_CREATIVE_MENU)
			.setTopBottomTextures("stardew:block/beehive_top")
			.setSideTextures("stardew:block/beehive_side")
			.setNorthTexture("stardew:block/beehive_active")
			.setBlockModel((block) -> {
				TextureRegistry.getTexture(MOD_ID + ":item/bee");
				return new BlockModelHorizontalRotation<>(block);
			})
			//.withTextures(, "stardew:block/beehive_top", "stardew:block/beehive_active", "stardew:block/beehive_side", "stardew:block/beehive_side", "stardew:block/beehive_side"))
			.build(new BlockBeehiveActive("beehive.honey", blockID("beehiveHoney"), true));

		blockHoney = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.5f))
			.setHardness(0.2f)
			.setResistance(0.2f)
			.setLightOpacity(6)
			.setTags(BlockTags.MINEABLE_BY_AXE)
			.setBlockModel(block -> new BlockModelStandard<>(block).withTextures("stardew:block/block_honey"))
			.build(new BlockHoney("block.honey", blockID("blockHoney")));


		cakeChocolate = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
			.setHardness(0.5f)
			.setResistance(0.5f)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.setBlockModel(block -> new BlockModelCakeChocolate<>(block).withTextures("stardew:block/chokoCake_top", "stardew:block/chokoCake_bottom", "stardew:block/chokoCake_side"))
			.build(new BlockCake("cake.chocolate", blockID("cakeChocolate")));

		pie = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
			.setHardness(0.5f)
			.setResistance(0.5f)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			//.setBlockModel(block -> new BlockModelPumpkinPie<>(block).withTextures("stardew:block/chokoCake_top", "stardew:block/chokoCake_bottom", "stardew:block/chokoCake_side"))
			.build(new BlockPie("pie", blockID("pie"), Material.cake));

		beehive = wood
			.setBlockModel(block -> new BlockModelHorizontalRotation<>(block).withTextures("stardew:block/beehive_top", "stardew:block/beehive_top", "stardew:block/beehive_idle", "stardew:block/beehive_side", "stardew:block/beehive_side", "stardew:block/beehive_side"))
			.build(new BlockBeehive("beehive", blockID("beehive")));

		pizza = new BlockBuilder(MOD_ID)
			.setBlockModel(block -> new BlockModelPizza<>(block).withTextures("stardew:block/pizza_top", "stardew:block/pizza_bottom", "stardew:block/pizza_side"))
			.setBlockSound(new BlockSound("step.cloth", "step.cloth", 1.0f, 1.0f))
			.setHardness(0.5f)
			.setResistance(0.5f)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build(new BlockPizza("pizza", blockID("pizza")));

		candle = new BlockBuilder(MOD_ID)
			.setBlockModel(block -> new DFBlockModelBuilder(MOD_ID).setBlockModel("block/candle.json").setRender3D(false).build(candle))
			.setIcon("stardew:block/candle_item")
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.2f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.BROKEN_BY_FLUIDS)
			.build(new BlockCandle("candle", blockID("candle"), false));

		candleActive = new BlockBuilder(MOD_ID)
			.setBlockModel(block -> new DFBlockModelBuilder(MOD_ID).setBlockModel("block/candle.json").setRender3D(false).build(candleActive))
			.setIcon("stardew:block/candle_item")
			.setBlockSound(new BlockSound("step.wood", "step.wood", 1.0f, 1.2f))
			.setHardness(0.0f)
			.setResistance(0.0f)
			.setLuminance(14)
			.setUseInternalLight()
			.setVisualUpdateOnMetadata()
			.setTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build(new BlockCandle("candle.active", blockID("candleActive"), true));

		initializeBlockDetails();
	}


}
