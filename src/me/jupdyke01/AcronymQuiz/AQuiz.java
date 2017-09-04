package me.jupdyke01.AcronymQuiz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class AQuiz implements CommandExecutor{

	public static String PluginTag = Main.PluginTag;
	public static String NoPerm = Main.NoPerm;
	public static String ConsoleUse = Main.ConsoleUse;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ConsoleUse);
			return true;
		}
		Player p = (Player) sender;

		if (args.length == 0) {
			p.sendMessage(PluginTag + ChatColor.GRAY + " You must enter an argument, Try /aquiz help");
			return true;
		} else if (args.length == 1) {
			if (args[0].equals("start")) {
				if (!(p.hasPermission("aquiz.start"))) {
					p.sendMessage(NoPerm);
					return true;
				}
				if (Main.QuizEnabled == false) {
					QuizStart.Chooser();
					String name = QuizStart.name;
					QuizStart.timeleft = QuizStart.Delay;
					QuizStart.TimeUp = QuizStart.Delay2;
					Utils.Broadcast(ChatColor.DARK_GRAY + "-=-=-=-=-=" + ChatColor.AQUA + PluginTag + ChatColor.DARK_GRAY + "=-=-=-=-=-");
					Utils.Broadcast(ChatColor.GRAY + "              A Quiz Has" + ChatColor.BLUE + " " + ChatColor.BOLD + "Begun!");
					Utils.Broadcast(ChatColor.GRAY + "             The Acronym Is " + ChatColor.WHITE + "" + ChatColor.BOLD + "" + name);
					Utils.Broadcast(ChatColor.DARK_GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					Main.QuizEnabled = true;
					return true;
				} else {
					p.sendMessage(PluginTag + ChatColor.GRAY + "" + ChatColor.BOLD + " There is a quiz currently " + ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "active!");
					return true;
				}
			} else if (args[0].equals("stop")) {
				if (!(p.hasPermission("aquiz.stop"))) {
					p.sendMessage(NoPerm);
					return true;
				}
				if (Main.QuizEnabled != true) {
					p.sendMessage(PluginTag + ChatColor.GRAY + " No current active acronym quizzes!");
					return true;
				} else {
					String Answer = QuizStart.answer;
					Utils.Broadcast(PluginTag + ChatColor.GRAY + " The quiz has been stopped!");
					Utils.Broadcast(ChatColor.GRAY + "The answer was" + ChatColor.DARK_GRAY + " -> " + ChatColor.BLUE + Answer);
					QuizStart.timeleft = QuizStart.Delay;
					QuizStart.TimeUp = QuizStart.Delay2;
					Main.QuizEnabled = false;
					return true;
				}
			} else if (args[0].equals("check")) {
				if (!(p.hasPermission("aquiz.check"))) {
					p.sendMessage(NoPerm);
					return true;
				}
				if (Main.QuizEnabled == true) {
					p.sendMessage(PluginTag + ChatColor.GRAY + "" + ChatColor.BOLD + " There is a quiz currently " + ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "active!");
					p.sendMessage(PluginTag + ChatColor.GRAY + " The acronmy is -> " + ChatColor.AQUA + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + QuizStart.name);
					return true;
				} else {
					p.sendMessage(PluginTag + ChatColor.GRAY + " No current active acronym quizzes!");
					return true;
				}
			} else if (args[0].equals("pause")) {
				if (!(p.hasPermission("aquiz.pause"))) {
					p.sendMessage(NoPerm);
					return true;
				}
				if (Main.Paused == false) {
					Main.Paused = true;
					p.sendMessage(PluginTag + ChatColor.GRAY + " The quizzes have been paused.");
					return true;
				} else {
					p.sendMessage(PluginTag + ChatColor.GRAY + " The quizzes are already paused!");
					return true;
				}
			} else if (args[0].equals("unpause")) {
				if (!(p.hasPermission("aquiz.unpause"))) {
					p.sendMessage(NoPerm);
					return true;
				}
				if (Main.Paused == true) {
					Main.Paused = false;
					p.sendMessage(PluginTag + ChatColor.GRAY + " The quizzes have been unpaused.");
					return true;
				} else {
					p.sendMessage(PluginTag + ChatColor.GRAY + " The quizzes are not paused!");
					return true;
				}
			} else if (args[0].equals("info")) {
				if (!(p.hasPermission("aquiz.info"))) {
					p.sendMessage(NoPerm);
					return true;
				}
				p.sendMessage(ChatColor.DARK_GRAY + "-=-=-=-=-=" + ChatColor.AQUA + PluginTag + ChatColor.DARK_GRAY + "=-=-=-=-=-");
				p.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.DARK_AQUA + Main.getPlugin(Main.class).getDescription().getVersion());
				p.sendMessage(ChatColor.GRAY + "Author: " + ChatColor.DARK_AQUA + "Jupdyke01");
				p.sendMessage(ChatColor.GRAY + "PluginName: " + ChatColor.DARK_AQUA + Main.getPlugin(Main.class).getDescription().getName());
				return true;
			} else if (args[0].equals("help")) {
				if (!(p.hasPermission("aquiz.help"))) {
					
					return true;
				}
				p.sendMessage(ChatColor.DARK_GRAY + "-=-=-=-=-=" + ChatColor.AQUA + PluginTag + ChatColor.DARK_GRAY + "=-=-=-=-=-");
				p.sendMessage(ChatColor.GRAY + "/aquiz");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " start");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " stop");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " pause");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " unpause");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " check");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " help");
				p.sendMessage(ChatColor.GRAY + "/aquiz" + ChatColor.DARK_AQUA + " info");
				return true;
			} else {
				p.sendMessage(PluginTag + ChatColor.GRAY + " Unknown Command, Try /aquiz help");
			}
		}

		return true;
	}
}
