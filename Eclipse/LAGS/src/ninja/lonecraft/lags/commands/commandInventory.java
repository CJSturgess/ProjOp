package ninja.lonecraft.lags.commands;

import ninja.lonecraft.lags.Main;
import ninja.lonecraft.lags.helpers.helperClasses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandInventory implements CommandExecutor {
	
	private final Main plugin;
	public commandInventory(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getLabel().equalsIgnoreCase("inventory")) {
			plugin.getLogger().info(sender.getName().toString() + " executed /inventory!");
			helperClasses.getWeapons(plugin.getServer().getPlayer(sender.getName()));
			return true;
		} else {
			return false;
		}
	}
}
