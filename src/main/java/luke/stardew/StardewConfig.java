package luke.stardew;

import luke.stardew.blocks.StardewBlocks;
import luke.stardew.items.StardewItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StardewConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties();
	private static final Toml properties = new Toml("Stardew Farming TOML Config");
	public static TomlConfigHandler cfg;

	private static int blockIDs = 6000;

	private static int itemIDs = 22000;

	static {
		properties.addCategory("stardew")
			.addEntry("cfgVersion", 5);

		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", 6000);
		properties.addCategory("Item IDs");
		properties.addEntry("Item IDs.startingID", 22000);


		List<Field> blockFields = Arrays.stream(StardewBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIDs++);
		}
		List<Field> itemFields = Arrays.stream(StardewItems.class.getDeclaredFields()).filter((F)-> Item.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field itemField : itemFields) {
			properties.addEntry("Item IDs." + itemField.getName(), itemIDs++);
		}

		cfg = new TomlConfigHandler(updater, StardewMod.MOD_ID, properties);

	}
}
