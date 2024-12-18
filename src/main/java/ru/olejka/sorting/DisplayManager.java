package ru.olejka.sorting;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DisplayManager {
    // Array of all wool blocks
	private static final Material[] blocks = new Material[] {
			Material.RED_CONCRETE,
            Material.RED_WOOL,
			Material.ORANGE_CONCRETE,
            Material.ORANGE_WOOL,
			Material.YELLOW_CONCRETE,
            Material.YELLOW_WOOL,
			Material.LIME_CONCRETE,
            Material.LIME_WOOL,
			Material.GREEN_CONCRETE,
            Material.GREEN_WOOL,
			Material.CYAN_CONCRETE,
            Material.CYAN_WOOL,
			Material.LIGHT_BLUE_CONCRETE,
            Material.LIGHT_BLUE_WOOL,
			Material.BLUE_CONCRETE,
            Material.BLUE_WOOL,
			Material.PURPLE_CONCRETE,
            Material.PURPLE_WOOL
    };

    // Array with number from 0 to 8
    public static int[] numbers = new int[18];


	private static UUID uuid = null;
	private static Integer x = null;
	private static Integer y = null;
	private static Integer z = null;

	public static void init(Player player) {
		for (int i = 0; i < blocks.length; i++) {
			numbers[i] = i;
		}

		uuid = player.getUniqueId();
		x = (int) player.getLocation().getX() - numbers.length / 2;
		y = (int) player.getLocation().getY() + 1;
		z = (int) player.getLocation().getZ() - numbers.length / 2;
	}

	public static boolean isOwner(Player player) {
		return uuid == null || uuid.equals(player.getUniqueId());
	}

	public static boolean isReady() {
		return uuid != null && x != null && y != null && z != null;
	}

	public static void cleanup() {
		var world = Sorting.getInstance().getServer().getWorld("world");
		assert world != null;

		for (int i = 0; i < numbers.length; i++) {
			world
					.getBlockAt(x + i, y, z)
					.setType(Material.AIR);
		}

		uuid = null;
		x = null;
		y = null;
		z = null;

	}

    public static void render() {
		var world = Sorting.getInstance().getServer().getWorld("world");
		assert world != null;

		for (int i = 0; i < numbers.length; i++) {
			world
					.getBlockAt(x + i, y, z)
					.setType(blocks[numbers[i]]);
		}

    }
}
