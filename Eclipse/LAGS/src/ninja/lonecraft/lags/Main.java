package ninja.lonecraft.lags;

import ninja.lonecraft.lags.commands.commandInventory;
import ninja.lonecraft.lags.helpers.helperClasses;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main plugin;
	
	@Override
	public void onLoad() {
		//Wow! Did I just load?
		this.getLogger().info("Loading...");
	}
	
	@Override
	public void onEnable() {
		//No way! I'm enabled!
		this.getLogger().info("Loaded!");
		
		this.getCommand("inventory").setExecutor(new commandInventory(this));
		new helperClasses(this);
	}
	
	@Override
	public void onDisable() {
		//Aww booo! Why do I have to go?
		this.getLogger().info("Disabling...");
	}
	
}
