package me.gomeow.housepoints;

import org.bukkit.ChatColor;


public enum House {
	GRYFFINDOR(ChatColor.DARK_RED),
	SLYTHERIN(ChatColor.GREEN),
	RAVENCLAW(ChatColor.DARK_BLUE),
	HUFFLEPUFF(ChatColor.YELLOW);
	
	ChatColor cc;
	
	House(ChatColor cc) {
		this.cc = cc;
	}
	public ChatColor getColor() {
		return this.cc;
	}
	
}
