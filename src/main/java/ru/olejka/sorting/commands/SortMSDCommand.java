package ru.olejka.sorting.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.olejka.sorting.DisplayManager;
import ru.olejka.sorting.algorithms.LinSort;

public class SortMSDCommand implements CommandExecutor {
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

		LinSort.msdRadixSort(DisplayManager.numbers);
		DisplayManager.render();

		sender.sendMessage("Preformed MSD Radix sort");

		return true;
	}
}
