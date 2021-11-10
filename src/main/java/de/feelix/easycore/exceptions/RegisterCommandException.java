package de.feelix.easycore.exceptions;

import de.feelix.easycore.commands.abstracts.EasyCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * ExceptionClass
 *
 * @author SaveFeelix
 * @version 1.0
 */
public class RegisterCommandException extends Exception {

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @deprecated Deprecated because of the not existing CommandParameter
     */
    @Deprecated
    public RegisterCommandException(@NotNull JavaPlugin plugin) {
        super("Failed to register Command on Plugin " + plugin.getName());
    }

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param command the Command Reference
     */
    public RegisterCommandException(@NotNull JavaPlugin plugin, @NotNull EasyCommand command) {
        super("Failed to register Command " + command.getCommand().getName() + " on Plugin " + plugin.getName());
    }
}
