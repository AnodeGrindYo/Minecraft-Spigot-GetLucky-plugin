package fr.anodegrindyo.getlucky;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Seuls les utilisateurs peuvent utiliser cette commande !");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("abracadabra")) {
			player.getInventory().addItem(ItemManager.wand);
		}
		return true;
	}

}
