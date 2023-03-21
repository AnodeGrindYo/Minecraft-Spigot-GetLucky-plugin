package fr.anodegrindyo.getlucky;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
	
	public static ItemStack wand;
	
	public static void init() {
		createDumbWand();
	}
	
	private static void createDumbWand() {
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("baguette_stupide");
		List<String> lore = new ArrayList<>();
		lore.add("§7On raconte que cet artifact puissant");
		lore.add("§7a été créé par Chip_Li, le codeur fou");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		wand = item;
	}
}
