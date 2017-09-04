package me.jupdyke01.AcronymQuiz;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;

public class AnswerListener implements Listener{

	public static String PluginTag = Main.PluginTag;
	
	@EventHandler
	public static void PlayerChat(AsyncPlayerChatEvent e) {

		if (Main.QuizEnabled == true) {
			 String Answer = QuizStart.answer;
			if (e.getMessage().toLowerCase().equals(Answer.toLowerCase())) {
				String p = ChatColor.stripColor(e.getPlayer().getName());
				Utils.Broadcast(PluginTag + ChatColor.GRAY + "The Player " + ChatColor.AQUA + ChatColor.BOLD + p + ChatColor.GRAY + " Has Won!");
				Utils.Broadcast(ChatColor.GRAY + "The answer was" + ChatColor.DARK_GRAY + " -> " + ChatColor.BLUE + Answer);
				int price = Main.pl.getConfig().getInt("amountwon");
				
				@SuppressWarnings({ "deprecation", "unused" })
				EconomyResponse r = Main.econ.depositPlayer(p, price);
				e.getPlayer().sendMessage(PluginTag + ChatColor.GRAY + " You have won the quiz and got $" + ChatColor.BLUE + price + ChatColor.GRAY + "!");
				e.setCancelled(true);
				Main.QuizEnabled = false;
			}
		}

		return;
	}
}
