package de.feelix.easycore.countdown;

import de.feelix.easycore.countdown.enums.CountdownDisplayType;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

/**
 * Class to get the Structure for a Countdown
 *
 * @author SaveFeelix
 * @version 1.0
 */
public abstract class EasyCountdown {

    /**
     * Reference to the Plugin
     */
    protected JavaPlugin plugin;

    /**
     * Reference to the CountdownID
     */
    protected int countdownID;

    /**
     * true if the countdown is running
     */
    protected boolean isRunning;

    /**
     * Reference to the CountdownTime
     */
    protected int countdownTime;
    /**
     * Reference to the splitted countdownTime
     */
    protected int sec, min, hour;

    /**
     * Reference to the splitted countdownTime as a String
     */
    protected String ssec, smin, shour;

    /**
     * Reference to the ServerConsole
     */
    protected static final ConsoleCommandSender console = Bukkit.getConsoleSender();

    /**
     * Constructor for the EasyCountdown
     * @param plugin the Plugin
     * @param countdownTime the countdownTime
     */
    public EasyCountdown(JavaPlugin plugin, int countdownTime) {
        this.countdownTime = countdownTime;
        this.plugin = plugin;
        this.sec = this.countdownTime;
        this.isRunning = false;
    }

    /**
     * Method to start the EasyCountdown
     * @param displayType the Type of the Display. (OPTIONAL!!!)
     */
    public abstract void start(@Nullable CountdownDisplayType displayType);

    /**
     * Method to stop the EasyCountdown
     */
    public abstract void stop();

    /**
     * Convert the CountdownTime
     */
    protected void convertTime() {
        if (sec < 0 && min > 0) {
            sec = 59;
            min--;
        }
        if (min < 0 && hour > 0) {
            min = 59;
            hour--;
        }
        if (sec < 0 && min == 0 && hour > 0) {
            sec = 59;
            min = 59;
            hour--;
        }
    }

    /**
     * Set the CountdownTime
     */
    protected void setDefaultTime() {
        while (sec >= 60) {
            min++;
            sec -= 60;
        }
        while (min >= 60) {
            hour++;
            min -= 60;
        }
    }

    /**
     * Convert the CountdownTime to a String
     */
    protected void timeToString() {
        if (sec < 10)
            ssec = '0' + String.valueOf(sec);
        else ssec = String.valueOf(sec);

        if (min < 10)
            smin = '0' + String.valueOf(min);
        else smin = String.valueOf(min);

        if (hour < 10)
            shour = '0' + String.valueOf(hour);
        else shour = String.valueOf(hour);
    }


    /**
     * Stop all Countdowns in the Plugin
     * @param plugin the Plugin
     */
    public static void stopAllCountdowns(JavaPlugin plugin) {
        Bukkit.getScheduler().cancelTasks(plugin);
    }

    /**
     * Get the CountdownTime
     * @return the CountdownTime
     */
    public int getCountdownTime() {
        return countdownTime;
    }

    /**
     * Set the CountdownTime
     * @param countdownTime the new CountdownTime
     */
    public void setCountdownTime(int countdownTime) {
        this.countdownTime = countdownTime;
    }

    /**
     * Get if the Countdown is Running
     * @return true if the Countdown is Running
     */
    public boolean isRunning() {
        return isRunning;
    }
}
