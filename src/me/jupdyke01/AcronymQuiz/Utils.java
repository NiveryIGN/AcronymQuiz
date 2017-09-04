package me.jupdyke01.AcronymQuiz;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
		
	
	public static void Broadcast(String msg) {
		Bukkit.broadcastMessage(msg);
	}
	
	public static void Msg(Player p, String msg) {
		p.sendMessage(msg);
	}
}
