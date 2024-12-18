package ru.olejka.sorting;

import org.bukkit.plugin.java.JavaPlugin;
import ru.olejka.sorting.commands.*;

import java.util.Objects;
import java.util.logging.Logger;

public final class Sorting extends JavaPlugin {

    public static Sorting instance;
    public static Logger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;
        logger = getLogger();

        // Utility commands
		Objects.requireNonNull(getCommand("screate")).setExecutor(new CreateCommand());
        Objects.requireNonNull(getCommand("sshuffle")).setExecutor(new ShuffleCommand());
        Objects.requireNonNull(getCommand("sdelete")).setExecutor(new DeleteCommand());
        // Simple sorting
        Objects.requireNonNull(getCommand("ssort-bubble")).setExecutor(new SortBubbleCommand());
        Objects.requireNonNull(getCommand("ssort-insertion")).setExecutor(new SortInsertionCommand());
        Objects.requireNonNull(getCommand("ssort-selection")).setExecutor(new SortSelectionCommand());
        // Effective sorting
        Objects.requireNonNull(getCommand("ssort-quick")).setExecutor(new SortQuickCommand());
        Objects.requireNonNull(getCommand("ssort-heap")).setExecutor(new SortHeapCommand());
        Objects.requireNonNull(getCommand("ssort-merge")).setExecutor(new SortMergeCommand());
        // Lin sort
        Objects.requireNonNull(getCommand("ssort-msd")).setExecutor(new SortMSDCommand());
        Objects.requireNonNull(getCommand("ssort-lsd")).setExecutor(new SortLSDCommand());
        Objects.requireNonNull(getCommand("ssort-counting")).setExecutor(new SortCountingCommand());

        logger.info("Sorting plugin enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        if (DisplayManager.isReady())
            DisplayManager.cleanup();

        logger.info("Sorting plugin disabled");
    }

    public static Sorting getInstance() {
        return instance;
    }

    public static Logger getPluginLogger() {
        return logger;
    }
}
