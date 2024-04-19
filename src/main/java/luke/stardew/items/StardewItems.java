package luke.stardew.items;

import luke.stardew.StardewConfig;
import luke.stardew.blocks.StardewBlocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemFoodStackable;
import net.minecraft.core.item.ItemSeeds;
import turniplabs.halplibe.helper.ItemHelper;

import static luke.stardew.StardewMod.MOD_ID;

public class StardewItems {

	private int itemID(String itemName) {
		return StardewConfig.cfg.getInt("Item IDs." + itemName);
	}

	public static Item seedsTomato;
	public static Item tomato;

	public static Item seedsPotato;
	public static Item potato;

	public static Item seedsCarrot;
	public static Item carrot;

	public static Item seedsStrawberry;
	public static Item strawberry;
	public static Item jamStrawberry;

	public static Item seedsBlueberry;
	public static Item blueberry;
	public static Item jamBlueberry;

	public void initilizeItems() {
		seedsTomato = ItemHelper.createItem(MOD_ID,
			new ItemSeeds("seeds.tomato", itemID("seedsTomato"), StardewBlocks.cropsTomato), "seedsTomato.png");

		tomato = ItemHelper.createItem(MOD_ID,
			new ItemFood("food.tomato", itemID("tomato"), 2, false), "tomato.png");


		seedsPotato = ItemHelper.createItem(MOD_ID,
			new ItemSeeds("seeds.potato", itemID("seedsPotato"), StardewBlocks.cropsPotato), "seedsPotato.png");

		potato = ItemHelper.createItem(MOD_ID,
			new ItemFood("food.potato", itemID("potato"), 2, false), "potato.png");


		seedsCarrot = ItemHelper.createItem(MOD_ID,
			new ItemSeeds("seeds.carrot", itemID("seedsCarrot"), StardewBlocks.cropsCarrot), "seedsCarrot.png");

		carrot = ItemHelper.createItem(MOD_ID,
			new ItemFood("food.carrot", itemID("carrot"), 2, false), "carrot.png");



		seedsStrawberry = ItemHelper.createItem(MOD_ID,
			new ItemSeeds("seeds.strawberry", itemID("seedsStrawberry"), StardewBlocks.cropsStrawberry), "seedsStrawberry.png");

		strawberry = ItemHelper.createItem(MOD_ID,
			new ItemFood("food.strawberry", itemID("strawberry"), 2, false), "strawberry.png");

		jamStrawberry = ItemHelper.createItem(MOD_ID,
			new ItemJam("food.jam.strawberry", itemID("jamStrawberry"), 10, 2), "jamStrawberry.png");



		seedsBlueberry = ItemHelper.createItem(MOD_ID,
			new ItemSeeds("seeds.blueberry", itemID("seedsBlueberry"), StardewBlocks.cropsBlueberry), "seedsBlueberry.png");

		blueberry = ItemHelper.createItem(MOD_ID,
			new ItemFoodStackable("food.blueberry", itemID("blueberry"), 1, false, 4), "blueberry.png");

		jamBlueberry = ItemHelper.createItem(MOD_ID,
			new ItemJam("food.jam.blueberry", itemID("jamBlueberry"), 10, 2), "jamBlueberry.png");

	}


}
