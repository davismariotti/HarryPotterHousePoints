package me.gomeow.housepoints;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HarryPotterHousePoints extends JavaPlugin implements Listener {

	HashMap<String, House> setSign = new HashMap<String, House>();
	
	public String capFirst(String s) {
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}

	ChatColor GRYFFINDOR = ChatColor.DARK_RED;
	ChatColor HUFFLEPUFF = ChatColor.YELLOW;
	ChatColor SLYTHERIN = ChatColor.DARK_GREEN;
	ChatColor RAVENCLAW = ChatColor.DARK_BLUE;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmdObj, String label, String[] args) {
		String cmd = cmdObj.getName();
		if(cmd.equalsIgnoreCase("housepoints")) {
			switch(args.length) {
			case 1:
			case 3:
				if(args[0].equalsIgnoreCase("give")) {
					if(args[1].equalsIgnoreCase("g") || args[1].equalsIgnoreCase("Gryffindor")) {
						if(cs.hasPermission("housepoints.give.gryffindor")) {
							int points = getConfig().getInt("Points.Gryffindor", 0);
							try {
								points = points + Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Gryffindor", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.GRYFFINDOR, points, true);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You gave "+args[2]+ " points to Gryffindor!");
						}
					}
					else if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("Slytherin")) {
						if(cs.hasPermission("housepoints.give.slytherin")) {
							int points = getConfig().getInt("Points.Slytherin", 0);
							try {
								points = points + Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Slytherin", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.SLYTHERIN, points, true);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You gave "+args[2]+ " points to Slytherin!");
						}
					}
					else if(args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("Ravenclaw")) {
						if(cs.hasPermission("housepoints.give.ravenclaw")) {
							int points = getConfig().getInt("Points.Ravenclaw", 0);
							try {
								points = points + Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Ravenclaw", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.RAVENCLAW, points, true);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You gave "+args[2]+ " points to Ravenclaw!");
						}
					}
					else if(args[1].equalsIgnoreCase("h") || args[1].equalsIgnoreCase("Hufflepuff")) {
						if(cs.hasPermission("housepoints.give.hufflepuff")) {
							int points = getConfig().getInt("Points.Hufflepuff", 0);
							try {
								points = points + Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Hufflepuff", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.HUFFLEPUFF, points, true);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You gave "+args[2]+ " points to Hufflepuff!");
						}
					}
				}
				else if(args[0].equalsIgnoreCase("take")) {
					if(args[1].equalsIgnoreCase("g") || args[1].equalsIgnoreCase("Gryffindor")) {
						if(cs.hasPermission("housepoints.take.gryffindor")) {
							int points = getConfig().getInt("Points.Gryffindor", 0);
							try {
								points = points - Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Gryffindor", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.GRYFFINDOR, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You took "+args[2]+ " points from Gryffindor!");
						}
					}
					else if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("Slytherin")) {
						if(cs.hasPermission("housepoints.take.slytherin")) {
							int points = getConfig().getInt("Points.Slytherin", 0);
							try {
								points = points - Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Slytherin", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.SLYTHERIN, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You took "+args[2]+ " points from Slytherin!");
						}
					}
					else if(args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("Ravenclaw")) {
						if(cs.hasPermission("housepoints.take.ravenclaw")) {
							int points = getConfig().getInt("Points.Ravenclaw", 0);
							try {
								points = points - Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Ravenclaw", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.RAVENCLAW, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You took "+args[2]+ " points from Ravenclaw!");
						}
					}
					else if(args[1].equalsIgnoreCase("h") || args[1].equalsIgnoreCase("Hufflepuff")) {
						if(cs.hasPermission("housepoints.take.hufflepuff")) {
							int points = getConfig().getInt("Points.Hufflepuff", 0);
							try {
								points = points - Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Hufflepuff", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.HUFFLEPUFF, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You took "+args[2]+ " points from Hufflepuff!");
						}
					}
				}
				else if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("g") || args[1].equalsIgnoreCase("Gryffindor")) {
						if(cs.hasPermission("housepoints.set.gryffindor")) {
							int points = getConfig().getInt("Points.Gryffindor", 0);
							try {
								points = Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points given!");
							}
							getConfig().set("Points.Gryffindor", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.GRYFFINDOR, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You set Gryffindor\'s points at "+args[2]+ "!");
						}
					}
					else if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("Slytherin")) {
						if(cs.hasPermission("housepoints.set.slytherin")) {
							int points = getConfig().getInt("Points.Slytherin", 0);
							try {
								points = Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points set!");
							}
							getConfig().set("Points.Slytherin", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.SLYTHERIN, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You set Slytherin\'s points at "+args[2]+ "!");
						}
					}
					else if(args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("Ravenclaw")) {
						if(cs.hasPermission("housepoints.set.ravenclaw")) {
							int points = getConfig().getInt("Points.Ravenclaw", 0);
							try {
								points = Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points set!");
							}
							getConfig().set("Points.Ravenclaw", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.RAVENCLAW, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You set Ravenclaw\'s points at "+args[2]+ "!");
						}
					}
					else if(args[1].equalsIgnoreCase("h") || args[1].equalsIgnoreCase("Hufflepuff")) {
						if(cs.hasPermission("housepoints.set.hufflepuff")) {
							int points = getConfig().getInt("Points.Hufflepuff", 0);
							try {
								points = Integer.parseInt(args[2]);
							}catch(NumberFormatException nfe) {
								cs.sendMessage(ChatColor.RED+"You need to specify a number as the points set!");
							}
							getConfig().set("Points.Hufflepuff", points);
							this.saveConfig();
							HousePointEvent event = new HousePointEvent(House.HUFFLEPUFF, points, false);
							Bukkit.getPluginManager().callEvent(event);
							cs.sendMessage(ChatColor.GREEN+"You set Hufflepuff\'s points at "+args[2]+ "!");
						}
					}
				}
			default:
				sendHelp(cs);
			}
		}
		return true;
	}

	private void sendHelp(CommandSender cs) {
		// TODO Auto-generated method stub
		
	}
	
	@EventHandler
	public void onInteract(SignChangeEvent event) {
		Player p = event.getPlayer();
		Sign s = (Sign) event.getBlock().getState();
		Location l = event.getBlock().getLocation();
		String[] lines = event.getLines();
		String uuid = UUID.randomUUID().toString().substring(0,8);
		if(p.hasPermission("housepoints.makesign")) {
			if(lines[0].equalsIgnoreCase("[Gryffindor]")) {
				s.setLine(0, GRYFFINDOR+"Gryffindor");
				s.setLine(1, GRYFFINDOR+"Points:");
				s.setLine(2, GRYFFINDOR+String.valueOf(getConfig().getInt("Points.Gryffindor")));
				s.update();
				event.setCancelled(true);
				getConfig().set("Signs.Gryffindor."+uuid+".World", l.getWorld().getName());
				getConfig().set("Signs.Gryffindor."+uuid+".X", l.getBlockX());
				getConfig().set("Signs.Gryffindor."+uuid+".Y", l.getBlockY());
				getConfig().set("Signs.Gryffindor."+uuid+".Z", l.getBlockZ());
				this.saveConfig();
			}
			else if(lines[0].equalsIgnoreCase("[Slytherin]")) {
				s.setLine(0, SLYTHERIN+"Slytherin");
				s.setLine(1, SLYTHERIN+"Points:");
				s.setLine(2, SLYTHERIN+String.valueOf(getConfig().getInt("Points.Slytherin")));
				s.update();
				event.setCancelled(true);
				getConfig().set("Signs.Slytherin."+uuid+".World", l.getWorld().getName());
				getConfig().set("Signs.Slytherin."+uuid+".X", l.getBlockX());
				getConfig().set("Signs.Slytherin."+uuid+".Y", l.getBlockY());
				getConfig().set("Signs.Slytherin."+uuid+".Z", l.getBlockZ());
				this.saveConfig();
			}
			else if(lines[0].equalsIgnoreCase("[Ravenclaw]")) {
				s.setLine(0, RAVENCLAW+"Ravenclaw");
				s.setLine(1, RAVENCLAW+"Points:");
				s.setLine(2, RAVENCLAW+String.valueOf(getConfig().getInt("Points.Ravenclaw")));
				s.update();
				event.setCancelled(true);
				getConfig().set("Signs.Ravenclaw."+uuid+".World", l.getWorld().getName());
				getConfig().set("Signs.Ravenclaw."+uuid+".X", l.getBlockX());
				getConfig().set("Signs.Ravenclaw."+uuid+".Y", l.getBlockY());
				getConfig().set("Signs.Ravenclaw."+uuid+".Z", l.getBlockZ());
				this.saveConfig();
			}
			else if(lines[0].equalsIgnoreCase("[Hufflepuff]")) {
				s.setLine(0, HUFFLEPUFF+"Hufflepuff");
				s.setLine(1, HUFFLEPUFF+"Points:");
				s.setLine(2, HUFFLEPUFF+String.valueOf(getConfig().getInt("Points.Hufflepuff")));
				s.update();
				event.setCancelled(true);
				getConfig().set("Signs.Hufflepuff."+uuid+".World", l.getWorld().getName());
				getConfig().set("Signs.Hufflepuff."+uuid+".X", l.getBlockX());
				getConfig().set("Signs.Hufflepuff."+uuid+".Y", l.getBlockY());
				getConfig().set("Signs.Hufflepuff."+uuid+".Z", l.getBlockZ());
				this.saveConfig();
			}
		}
	}
	
	@EventHandler
	public void onHousePointChange(HousePointEvent event) {
		String house = capFirst(event.getHouse().toString().toLowerCase());
		if(!(getConfig().getConfigurationSection("Signs").getKeys(false).contains(house))) return;
		for(String key:getConfig().getConfigurationSection("Signs."+house)
				.getKeys(false)) {
			World w = Bukkit.getWorld(getConfig().getString("Signs."+house+"."+key+".World"));
			Location l = new Location(w, 
				getConfig().getInt("Signs."+house+"."+key+".X"), 
				getConfig().getInt("Signs."+house+"."+key+".Y"), 
				getConfig().getInt("Signs."+house+"."+key+".Z"));
			if(w.getBlockAt(l).getType() == Material.SIGN_POST 
					|| w.getBlockAt(l).getType() == Material.WALL_SIGN) {
				Sign s = (Sign) w.getBlockAt(l).getState();
				if(ChatColor.stripColor(s.getLine(0)).equalsIgnoreCase(house)) {
					s.setLine(0, event.getHouse().getColor()+capFirst(event.getHouse().toString().toLowerCase()));
					s.setLine(1, event.getHouse().getColor()+"Points:");
					s.setLine(2, event.getHouse().getColor()+String.valueOf(event.getPoints()));
					s.update();
				}
				else {
					getConfig().set("Signs."+house+"."+key, null);
					saveConfig();
				}
			}
			else {
				getConfig().set("Signs."+house+"."+key, null);
				saveConfig();
			}
		}
	}
}
