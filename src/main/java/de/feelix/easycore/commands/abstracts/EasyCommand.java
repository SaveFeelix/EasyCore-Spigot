package de.feelix.easycore.commands.abstracts;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Class to create a EasyCommand
 *
 * @author SaveFeelix
 * @version 1.0
 * @see CommandExecutor
 */
public abstract class EasyCommand implements CommandExecutor {

    /**
     * Reference to the Plugin
     */
    protected final JavaPlugin plugin;

    /**
     * Reference to the Command
     */
    protected final Command command;

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param commandName the CommandName
     */
    public EasyCommand(JavaPlugin plugin, String commandName) {
        this.plugin = plugin;
        this.command = Bukkit.getPluginCommand(commandName);
    }

    /**
     * Getter for the Command
     * @return the Command
     */
    public Command getCommand() {
        return command;
    }
}
