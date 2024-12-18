package ru.olejka.sorting.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.olejka.sorting.DisplayManager;
import ru.olejka.sorting.Sorting;

public class ShuffleCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player player)) {
			return true;
		}

		if (!DisplayManager.isReady()) {
			sender.sendMessage("Display is not created");
			return true;
		}

		if (!DisplayManager.isOwner(player)) {
			sender.sendMessage("Display is owned by someone else");
			return true;
		}

		for (int i = 0; i < DisplayManager.numbers.length; i++) {
			int j = (int) (Math.random() * (i + 1));
			int temp = DisplayManager.numbers[i];
			DisplayManager.numbers[i] = DisplayManager.numbers[j];
			DisplayManager.numbers[j] = temp;
		}

		DisplayManager.render();

		sender.sendMessage("Shuffled display");

		return true;
	}
}
