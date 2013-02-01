package me.gomeow.housepoints;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HarryPotterHousePoints extends JavaPlugin implements Listener {

	HashMap<String, House> setSign = new HashMap<String, House>();
	
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
				
			case 2:
				/*if(args[0].equalsIgnoreCase("setsign")) {
					if(cs instanceof Player) {
						Player p = (Player) cs;
						if(args[1].equalsIgnoreCase("g") || args[1].equalsIgnoreCase("gryffindor")) {
							p.sendMessage(ChatColor.GREEN+"Now hit a sign to set the Gryffindor house sign!");
							setSign.put(p.getName(), House.GRYFFINDOR);
							return true;
						}
						else if(args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("slytherin")) {
							p.sendMessage(ChatColor.GREEN+"Now hit a sign to set the Slytherin house sign!");
							setSign.put(p.getName(), House.SLYTHERIN);
							return true;
						}
						else if(args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("ravenclaw")) {
							p.sendMessage(ChatColor.GREEN+"Now hit a sign to set the Ravenclaw house sign!");
							setSign.put(p.getName(), House.RAVENCLAW);	
							return true;
						}
						else if(args[1].equalsIgnoreCase("h") || args[1].equalsIgnoreCase("hufflepuff")) {
							p.sendMessage(ChatColor.GREEN+"Now hit a sign to set the Hufflepuff house sign!");
							setSign.put(p.getName(), House.HUFFLEPUFF);	
							return true;
						}
						else  {
							p.sendMessage(ChatColor.RED + "You did not specify one of the acceptable house names:");
							p.sendMessage(ChatColor.RED+"gryffindor, slytherin, ravenclaw, hufflepuff");
							return true;
						}
					}
					else {
						cs.sendMessage(ChatColor.RED+"");
					}
				}*/
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
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block b = event.getClickedBlock();
			if(b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN) {
				Sign s = (Sign) b;
				String[] lines = s.getLines();
				if(p.hasPermission("housepoints.makesign")) {
					if(lines[0].equalsIgnoreCase("[Gryffindor]")) {
						
					}
					else if(lines[0].equalsIgnoreCase("[Slytherin]")) {
						
					}
					else if(lines[0].equalsIgnoreCase("[Ravenclaw]")) {
						
					}
					else if(lines[0].equalsIgnoreCase("[Hufflepuff]")) {
						
					}
				}
			}
		}
	}
	
}
