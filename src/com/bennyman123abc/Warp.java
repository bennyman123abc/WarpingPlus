package com.bennyman123abc;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Warp extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
	}
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("warp")) {
			
			int length = args.length;
			
			if(length == 0) {
				
				player.sendMessage(ChatColor.GOLD + "------ List of Warps ------");
				
				@SuppressWarnings("unchecked")
				List<String> warps = (List<String>) this.getConfig().getList("warps");
				for(String s : warps) {
					player.sendMessage(ChatColor.RED + s);
				}
				
				return true;
			}
			
			if(length == 1) {
				String arg1 = args[1]; 
				
				int xcoord = this.getConfig().getInt("warp." + arg1 + ".xcoord");
				int ycoord = this.getConfig().getInt("warp." + arg1 + ".ycoord");
				int zcoord = this.getConfig().getInt("warp." + arg1 + ".zcoord");
				
				if(xcoord == 0) {
					player.sendMessage(ChatColor.RED + "That warp does not exist!");
					return true;
				}
			}
			
		}
		
		return false;
	}

}
