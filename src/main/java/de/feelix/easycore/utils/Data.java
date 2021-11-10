package de.feelix.easycore.utils;

/**
 * Enum to get the Messages for the ReloadPluginCommand
 *
 * @author SaveFeelix
 * @version 1.0
 */
public enum Data {
    Prefix("§5Easy§1Core §7>>"),


    //Commands
    PluginReload(Prefix.text + " §aPlugin reloaded"),
    WrongSyntax(Prefix.text + " §cPlease use §6%syntax% §cto execute this Command§7!"),
    NoPerms(Prefix.text + " §cYou haven't any Permissions to execute this Command§7!");

    public final String text;

    Data(String text) {
        this.text = text;
    }
}
