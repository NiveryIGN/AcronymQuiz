package me.jupdyke01.AcronymQuiz;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin{

	public static Economy econ = null;

	public static Plugin pl;
	public static boolean QuizEnabled = false;
	public static boolean Paused = false;

	public static String PluginTag = "" + ChatColor.DARK_GRAY + ChatColor.BOLD + "{" + ChatColor.BLUE + ChatColor.BOLD + "Acronym Quiz" + ChatColor.DARK_GRAY + ChatColor.BOLD + "}";
	public static String ConsoleUse = PluginTag + ChatColor.GRAY + " You must be a player to use this command!";
	public static String NoPerm = PluginTag + ChatColor.GRAY + " You do not have permission to perform this command!";

	public void onEnable() {
		pl = this;
		saveDefaultConfig();
		EnableEvents();
		EnableCommands();
		runnablerunner();
		runnablerunner2();
		if (!setupEconomy() ) {
			getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
	}

	public void onDisable() {

	}

	public void EnableEvents() {
		getServer().getPluginManager().registerEvents(new AnswerListener(), this);
	}

	public void EnableCommands() {
		getCommand("aquiz").setExecutor(new AQuiz());
	}

	public void runnablerunner() {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (QuizEnabled == true) {
					return;
				}
				if (Paused == true) {
					return;
				}

				if(QuizStart.timeleft <= 0) {
					QuizStart.QuizStarter();
				} else {
					QuizStart.timeleft--;
				}
			}
		}.runTaskTimer(this, 0, 20);
	}

	public void runnablerunner2() {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (QuizEnabled == false) {
					return;
				}
				if (Paused == true) {
					return;
				}

				if(QuizStart.TimeUp <= 0) {
					QuizStop.StopQuiz();
				} else {
					QuizStart.TimeUp--;
				}
			}
		}.runTaskTimer(this, 0, 20);
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}
}
