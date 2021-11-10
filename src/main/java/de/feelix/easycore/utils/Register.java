package de.feelix.easycore.utils;

import de.feelix.easycore.commands.abstracts.EasyCommand;
import de.feelix.easycore.exceptions.RegisterCommandException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Class to register Commands and Listener
 *
 * @author SaveFeelix
 * @version 1.0
 */
public class Register {

    private final JavaPlugin plugin;

    public Register(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the Class (Needed superclass: {@link CommandExecutor})
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     * @deprecated deprecated because of the Exception
     */
    @Deprecated
    public void registerCommand(@NotNull String commandName, @NotNull CommandExecutor commandClass) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin);
        }
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the CommandClass (Needed superclass: {@link CommandExecutor})
     * @param tabCompleter the TabCompleterclass (Needed superclass: {@link TabCompleter})
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     * @deprecated deprecated because of the Exception
     */
    @Deprecated
    public void registerCommand(@NotNull String commandName, @NotNull CommandExecutor commandClass, TabCompleter tabCompleter) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
            plugin.getCommand(commandName).setTabCompleter(tabCompleter);
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin);
        }
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the CommandClass (Needed superclass: {@link CommandExecutor})
     * @param aliases      the Aliases of the Command
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     * @deprecated deprecated because of the Exception
     */
    @Deprecated
    public void registerCommand(@NotNull String commandName, @NotNull CommandExecutor commandClass, String...
            aliases) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
            plugin.getCommand(commandName).setAliases(Arrays.asList(aliases));
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin);
        }
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the CommandClass (Needed superclass: {@link CommandExecutor})
     * @param tabCompleter the TabCompleterclass (Needed superclass: {@link TabCompleter})
     * @param aliases      the Aliases of the Command
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     * @deprecated deprecated because of the Exception
     */
    @Deprecated
    public void registerCommand(@NotNull String commandName, @NotNull CommandExecutor commandClass, TabCompleter
            tabCompleter, String... aliases) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
            plugin.getCommand(commandName).setTabCompleter(tabCompleter);
            plugin.getCommand(commandName).setAliases(Arrays.asList(aliases));
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin);
        }
    }


    // New RegisterCommand
    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the Class (Needed superclass: {@link EasyCommand})
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull String commandName, @NotNull EasyCommand commandClass) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin, commandClass);
        }
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the CommandClass (Needed superclass: {@link EasyCommand})
     * @param tabCompleter the TabCompleterclass (Needed superclass: {@link TabCompleter})
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull String commandName, @NotNull EasyCommand commandClass, TabCompleter tabCompleter) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
            plugin.getCommand(commandName).setTabCompleter(tabCompleter);
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin, commandClass);
        }
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the CommandClass (Needed superclass: {@link EasyCommand})
     * @param aliases      the Aliases of the Command
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull String commandName, @NotNull EasyCommand commandClass, String...
            aliases) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
            plugin.getCommand(commandName).setAliases(Arrays.asList(aliases));
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin, commandClass);
        }
    }

    /**
     * Register a Command
     *
     * @param commandName  the Name of the Command
     * @param commandClass the CommandClass (Needed superclass: {@link EasyCommand})
     * @param tabCompleter the TabCompleterclass (Needed superclass: {@link TabCompleter})
     * @param aliases      the Aliases of the Command
     * @throws RegisterCommandException if the Command isn't registered in the plugin.yml
     */
    public void registerCommand(@NotNull String commandName, @NotNull EasyCommand commandClass, TabCompleter
            tabCompleter, String... aliases) throws RegisterCommandException {
        try {
            plugin.getCommand(commandName).setExecutor(commandClass);
            plugin.getCommand(commandName).setTabCompleter(tabCompleter);
            plugin.getCommand(commandName).setAliases(Arrays.asList(aliases));
        } catch (NullPointerException e) {
            throw new RegisterCommandException(plugin, commandClass);
        }
    }


    // Listeners
    /**
     * Register a Listener
     *
     * @param listener the ListenerClass (Needed superclass: {@link Listener})
     */
    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    /**
     * Register many Listener
     *
     * @param listeners a List which includes ListenersClass (Needed superclass: {@link Listener})
     */
    public void registerListeners(Listener... listeners) {
        this.registerListeners(Arrays.asList(listeners));
    }

    /**
     * Register many Listener
     *
     * @param listeners a List which includes ListenersClass (Needed superclass: {@link Listener})
     */
    public void registerListeners(@NotNull List<Listener> listeners) {
        listeners.forEach(this::registerListener);
    }
}
