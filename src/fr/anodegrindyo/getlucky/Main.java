package fr.anodegrindyo.getlucky;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		ItemManager.init();
		getServer().getPluginManager().registerEvents(new ItemEvents(), this);
		getCommand("abracadabra").setExecutor(new ItemCommand());
	}
	
	@Override
	public void onDisable() {
		
	}

}
