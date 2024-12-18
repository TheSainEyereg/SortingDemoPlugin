package ru.olejka.sorting.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.olejka.sorting.DisplayManager;

public class CreateCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player player)) {
			return true;
		}

		if (DisplayManager.isReady()) {
			sender.sendMessage("Display is already created");
			return true;
		}

		DisplayManager.init(player);
		DisplayManager.render();

		sender.sendMessage("Display created");

		return true;
	}
}
