package fr.anodegrindyo.getlucky;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class ItemEvents implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onRightClick(PlayerInteractEvent event) {
		// si l'utilisateur right-clic sur un bloc
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getItem() != null) {
				if (event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
					Player player = event.getPlayer();
					// son aléatoire
					// Liste de sons possibles
					Sound[] sounds = {
					    Sound.ENTITY_DONKEY_ANGRY,
					    Sound.ENTITY_HORSE_ANGRY,
					    Sound.ENTITY_ENDER_DRAGON_GROWL,
					    Sound.ENTITY_CAT_AMBIENT,
					    Sound.ENTITY_PLAYER_LEVELUP,
					    Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
					    Sound.ENTITY_VILLAGER_YES
					};

					// Joue un son aléatoire lorsqu'un joueur clique avec la baguette magique
					player.playSound(player.getLocation(), sounds[new Random().nextInt(sounds.length)], 1, 1);
					
					
					// évènement aléatoire
					int nb_effects = 20;
					Random rand = new Random();
					int randomInt = rand.nextInt(nb_effects);
					switch(randomInt) {
						case 0:
	                        player.getWorld().strikeLightning(player.getTargetBlock(null, 200).getLocation());
	                        player.getServer().broadcastMessage(player.getName() + " a invoqué la foudre ! ZAP ZAP !");
	                        break;
	                    case 1:
	                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000, 4));
	                        player.getServer().broadcastMessage(player.getName() + " court plus vite que Sonic !");
	                        break;
	                    case 2:
	                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000, 8));
	                        player.getServer().broadcastMessage(player.getName() + " saute à la lune !");
	                        break;
	                    case 3:
	                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2000, 4));
	                        player.getServer().broadcastMessage(player.getName() + " est devenu invisible ! Où est-il ?");
	                        break;
	                    case 4:
//	                        player.setFallDistance(-5000);
	                    	Location pos = player.getLocation();
	                    	player.teleport(new Location(player.getWorld(), pos.getX(), 3000, pos.getY()));
	                        player.getServer().broadcastMessage(player.getName() + " a volé ! C'est un oiseau ! C'est un avion !");
	                        break;
	                    case 5:
	                        player.getWorld().spawnEntity(player.getTargetBlock(null, 200).getLocation(), EntityType.PRIMED_TNT);
	                        player.getServer().broadcastMessage(player.getName() + " a posé une bombe ! BOUM !");
	                        break;
	                    case 6:
	                        player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREBALL);
	                        player.getServer().broadcastMessage(player.getName() + " a lancé une boule de feu ! BRAVO !");
	                        break;
	                    case 7:
	                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000, 2));
	                        player.getServer().broadcastMessage(player.getName() + " est incassable ! YEAH !");
	                        break;
	                    case 8:
	                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000, 1));
	                        player.getServer().broadcastMessage(player.getName() + " est devenu aveugle ! AIE !");
	                        break;
	                    case 9:
	                        player.setHealth(0);
	                        player.getServer().broadcastMessage(player.getName() + " s'est suicidé ! OH LA VACHE !");
	                        break;
	                    case 10:
	                    	player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000, 1));
	                        player.getServer().broadcastMessage(player.getName() + " est complètement désorienté !");
	                        break;
	                    case 11:
	                    	for (int i = 0; i < 10; i++) {
	                            player.getWorld().spawnEntity(player.getLocation(), EntityType.RABBIT);
	                        }
	                        player.getServer().broadcastMessage("Des lapins viennent d'apparaître autour de " + player.getName() + " !");
	                        break;
	                    case 12:
	                    	int nbEntities = 20;
	                    	Random random = new Random();

	                    	for (int i = 0; i < nbEntities; i++) {
	                    	    EntityType entityType = EntityType.values()[random.nextInt(EntityType.values().length)];
	                    	    Location loc = player.getLocation().add(random.nextDouble() * 10 - 5, random.nextDouble() * 10, random.nextDouble() * 10 - 5);
	                    	    player.getWorld().spawnEntity(loc, entityType);
	                    	    player.getServer().broadcastMessage(player.getName() + " a fait apparaître un " + entityType.getName());
	                    	}
	                        break;
	                    case 13:
	                    	player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 4000, 16));
	                        player.getServer().broadcastMessage(player.getName() + " est en lévitation !");
	                        break;
	                    case 14:
	                    	if (player.getBedLocation() != null) {
		                    	player.teleport(player.getBedLocation());
		                        player.getServer().broadcastMessage(player.getName() + " a été téléporté dans son lit !");
	                    	}
	                    	else {
	                    		player.teleport(player.getLastDeathLocation());
	                    		player.getServer().broadcastMessage(player.getName() + " s'est téléporté à l'endroit de sa dernière mort !");
	                    	}
	                    	player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 4000, 16));
	                        break;
	                    case 15:
	                    	for (int i = 0; i < 10; i++) {
	                            Villager babyVillager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
	                            babyVillager.setBaby();
	                        }
	                        player.getServer().broadcastMessage("Des bébés villageois viennent d'apparaître autour de " + player.getName() + " !");
	                        break;
	                    case 16:
	                    	for (int i = 0; i < 36; i++) {
	                            player.getInventory().addItem(new ItemStack(Material.values()[new Random().nextInt(Material.values().length)]));
	                        }
	                        player.getServer().broadcastMessage(player.getName() + " vient de recevoir un inventaire aléatoire !");
	                        break;
	                    case 17:
	                    	player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 64));
	                        player.getServer().broadcastMessage(player.getName() + " vient de recevoir 64 lingots d'or !");
	                        break;
	                    case 18:
	                    	for (int i = 0; i < 10; i++) {
	                            player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
	                        }
	                        player.getServer().broadcastMessage("Des zombies viennent d'apparaître autour de " + player.getName());
	                    case 19:
	                    	player.getInventory().addItem(new ItemStack(Material.DIAMOND, 64));
	                        player.getServer().broadcastMessage(player.getName() + " vient de recevoir 64 diamants !");
	                        break;
	                    case 20:
	                        player.sendMessage(ChatColor.YELLOW + "Let's celebrate!");
	                        Location location = player.getLocation();
	                        for (int i = 0; i < 100; i++) {
	                            Firework firework = location.getWorld().spawn(location, Firework.class);
	                            FireworkMeta meta = firework.getFireworkMeta();

	                            // Ajouter un effet aléatoire au feux d'artifice
	                            FireworkEffect.Type type = FireworkEffect.Type.values()[new Random().nextInt(FireworkEffect.Type.values().length)];
	                            Color color = Color.fromRGB(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
	                            FireworkEffect effect = FireworkEffect.builder().with(type).withColor(color).build();

	                            meta.addEffect(effect);
	                            meta.setPower(1);
	                            firework.setFireworkMeta(meta);
	                        }
//	                        for (int i = 0; i < 50; i++) {
//	                            Location location = player.getLocation();
//	                            Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
//	                            FireworkMeta fireworkMeta = firework.getFireworkMeta();
//	                            Random random = new Random();
//	                            FireworkEffect.Type[] types = FireworkEffect.Type.values();
//	                            FireworkEffect.Type type = types[random.nextInt(types.length)];
//	                            Color color = Color.fromRGB(random.nextInt(256), random.nextInt(256), random.nextInt(256));
//	                            FireworkEffect effect = FireworkEffect.builder().with(type).withColor(color).flicker(random.nextBoolean()).build();
//	                            fireworkMeta.addEffect(effect);
//	                            fireworkMeta.setPower(random.nextInt(3) + 1);
//	                            firework.setFireworkMeta(fireworkMeta);
//	                        }
//	                        new BukkitRunnable() {
//	                            int count = 0;
//	                            @Override
//	                            public void run() {
//	                                count++;
//	                                if (count >= 300) { // arrête après 5 minutes (10 * 20 * 15)
//	                                    cancel();
//	                                    return;
//	                                }
//	                                for (Player player : Bukkit.getOnlinePlayers()) {
//	                                    player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);
//	                                }
//	                            }
//	                        }.runTaskTimer(Main.getPlugin(Main.class), 0, 20 * 15);
	                        break;
	                    default:
	                        break;
					}
				}
			}
		}
	}
}
