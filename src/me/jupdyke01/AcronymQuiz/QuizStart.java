package me.jupdyke01.AcronymQuiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

public class QuizStart {

	public static int Delay = Main.pl.getConfig().getInt("quizcooldown");
	public static int Delay2 = Main.pl.getConfig().getInt("timeactive");
	public static int timeleft = Delay;
	public static int TimeUp = Delay2;
	
	public static void QuizStarter() {
		if (Main.QuizEnabled == false) {
			QuizStart.Chooser();
			timeleft = Delay;
			TimeUp = Delay2;
			Utils.Broadcast(ChatColor.DARK_GRAY + "-=-=-=-=-=" + ChatColor.AQUA + PluginTag + ChatColor.DARK_GRAY + "=-=-=-=-=-");
			Utils.Broadcast(ChatColor.GRAY + "              A Quiz Has" + ChatColor.BLUE + " " + ChatColor.BOLD + "Begun!");
			Utils.Broadcast(ChatColor.GRAY + "             The Acronym Is " + ChatColor.WHITE + "" + ChatColor.BOLD + "" + name);
			Utils.Broadcast(ChatColor.DARK_GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			Main.QuizEnabled = true;
			return;
		} else {
			return;
		}
	}
	
	public static String PluginTag = Main.PluginTag;
	
	static String answer;
	static String name;

	public static void Chooser() {
		Quizzes random = getRandom();
		answer = random.Answer();
		name = random.name();	
	}

	public static Quizzes getRandom() {
		List<Quizzes> values = Arrays.asList(Quizzes.values());
		Collections.shuffle(values);
		return values.get(0);
	}
}
