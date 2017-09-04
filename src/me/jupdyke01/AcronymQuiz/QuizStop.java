package me.jupdyke01.AcronymQuiz;

import net.md_5.bungee.api.ChatColor;

public class QuizStop {

	public static String PluginTag = Main.PluginTag;
	
	public static void StopQuiz() {
		if (Main.QuizEnabled != true) {
			return;
		} else {
			String Answer = QuizStart.answer;
			Utils.Broadcast(PluginTag + ChatColor.GRAY + " The quiz has been stopped!");
			Utils.Broadcast(ChatColor.GRAY + "The answer was" + ChatColor.DARK_GRAY + " -> " + ChatColor.BLUE + Answer);
			QuizStart.timeleft = QuizStart.Delay;
			QuizStart.TimeUp = QuizStart.Delay2;
			Main.QuizEnabled = false;
		}
	}
}
