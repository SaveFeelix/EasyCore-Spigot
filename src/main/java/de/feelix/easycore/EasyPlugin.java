package de.feelix.easycore;

import de.feelix.easycore.utils.Register;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * class to create a Plugin
 *
 * @author SaveFeelix
 * @version 1.0
 */
public abstract class EasyPlugin extends JavaPlugin {

    /**
     * Reference to the ServerConsole
     */
    public static final ConsoleCommandSender console = Bukkit.getConsoleSender();
    /**
     * Reference to the RegisterClass
     */
    protected final Register register = new Register(this);

    @Override
    public abstract void onLoad();
    @Override
    public abstract void onEnable();
    @Override
    public abstract void onDisable();

    /**
     * Method to initialize Commands
     */
    public abstract void initCommands();

    /**
     * Method to initialize Listeners
     */
    public abstract void initListeners();

    /**
     * Method to initialize Configs
     */
    public abstract void initConfigs();

    /**
     * Method to initialize Utils
     */
    public abstract void initUtils();
}
