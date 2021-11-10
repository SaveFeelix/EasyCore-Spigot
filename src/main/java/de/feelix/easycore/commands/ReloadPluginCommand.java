package de.feelix.easycore.commands;

import de.feelix.easycore.commands.abstracts.EasyCommand;
import de.feelix.easycore.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * Prepared Command to reload the Plugin
 *
 * @author SaveFeelix
 * @version 1.0
 */
public class ReloadPluginCommand extends EasyCommand {

    /**
     * Default Constructor
     * @param plugin the Plugin
     * @param commandName the CommandName
     */
    public ReloadPluginCommand(JavaPlugin plugin, String commandName) {
        super(plugin, commandName);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(plugin.getName() + ".reload")) {
                if (strings.length == 0) {
                    Bukkit.getPluginManager().disablePlugin(plugin);
                    Bukkit.getPluginManager().enablePlugin(plugin);
                    player.sendMessage(Data.PluginReload.text);
                } else
                    player.sendMessage(Data.WrongSyntax.text.replace("%syntax%", "/rlplugin"));
            } else
                player.sendMessage(Data.NoPerms.text);
        } else {
            if (strings.length == 0) {
                Bukkit.getPluginManager().disablePlugin(plugin);
                Bukkit.getPluginManager().enablePlugin(plugin);
                Bukkit.getConsoleSender().sendMessage(Data.PluginReload.text);
            } else
                Bukkit.getConsoleSender().sendMessage(Data.WrongSyntax.text.replace("%syntax%", "rlplugin"));
        }
        return true;
    }
}
