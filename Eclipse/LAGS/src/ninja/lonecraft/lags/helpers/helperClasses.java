package ninja.lonecraft.lags.helpers;

import java.util.HashMap;
import java.util.Map;

import ninja.lonecraft.lags.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class helperClasses {
	public static Main plugin;
	public helperClasses(Main main) {
		helperClasses.plugin = main;
	}
	
	public static Integer getGunID(String gun) {
		Map<String, Integer> gunIDArray = new HashMap<String, Integer>();
		gunIDArray.put("AK47", 4250);
		
		String useGun;
		if (gun.contains("_")) {
			String[] gunSplit = gun.split("_");
			useGun = gunSplit[0];
		} else {
			useGun = gun;
		}
		
		return gunIDArray.get(useGun);
	}
	
	public static Integer getGunAmmoType(Integer gunID) {
		Map<Integer, Integer> gunAmmoTypeArray = new HashMap<Integer, Integer>();
		gunAmmoTypeArray.put(4250, 4171);
		
		return gunAmmoTypeArray.get(gunID);
	}
	
	public static String getGunName(String gun) {
		
		String gunName;
		
		if (gun.contains("_")) {
			gunName = gun.replace("_", " ");
		} else {
			gunName = gun;
		}
		
		return gunName;
	}
	
	public static void doCommand(String command) {
		plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), command);
	}
	
	public static void getWeapons(Player player) {
		ItemStack coolStack = new ItemStack(Material.STAINED_GLASS_PANE);
		coolStack.setDurability((short) 8);;
		ItemMeta coolItemMeta = coolStack.getItemMeta();
		coolItemMeta.setDisplayName(ChatColor.GRAY + "Unused Slot");
		coolStack.setItemMeta(coolItemMeta);
		for (int i = 0; i <  36; i++) {
			player.getInventory().setItem(i, coolStack);
		}
		getPrimary("AK47_Birch", player);
		
		plugin.getLogger().info("Loadout retrieved for player " + player.getName().toString() + ".");
	}
	
	public static void getPrimary(String gun, Player player) {
		doCommand("give " + player.getName().toString() + " minecraft:iron_bars 1");
		try {Thread.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].tag.display.Name = \"&8Primary Weapon Slot\"");
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].Slot = 0 Byte");
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].id = " + getGunID(gun) + " Short");
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].tag.Paint = " + gun);
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].tag.ammo[0].id = " + getGunAmmoType(getGunID(gun)) + " Short");
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].tag.ammo[0].Count = 1 Short");
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].Damage = 0 Short");
		doCommand("nbt. *" + player.getName().toString() + " Inventory[0].tag.display.Name = \"&2" + player.getName().toString() + "'s &8" + getGunName(gun) + "\"");
		plugin.getLogger().info("Equipped " + gun + " for player " + player.getName().toString() + ".");
	}
}
