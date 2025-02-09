package fr.poutrecosmique.roguelike.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import fr.poutrecosmique.roguelike.utils.Stat;

public class ItemObject {
	protected ItemRarity rarity = ItemRarity.UNKNOWN;
	protected ItemStack itemStack = new ItemStack(Material.AIR);
	protected ItemMeta meta;
	protected String name = "Null";
	protected ItemType type = ItemType.NONE;
	protected String itemEffectsDesc = "";
	protected String itemDesc = "";
	protected int itemIdentifier = -1;
	
	// Stats
	protected Stat stats = new Stat();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIdentifier(int identifier) {
		this.itemIdentifier = identifier;
	}
	
	public void setItemEffectsDesc(String itemEffectsDesc) {
		this.itemEffectsDesc = itemEffectsDesc;
	}
	
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	public void setRarity(ItemRarity rarity) {
		this.rarity = rarity;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	
	public void setItemStack(ItemStack item) {
		meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(NamespacedKey.fromString("identifier"), PersistentDataType.INTEGER, this.itemIdentifier);
		item.setItemMeta(meta);
		this.itemStack = item;
	}
	
	public void setMaterial(Material mat) {
		this.itemStack.setType(mat);
	}
	
	//SETTERS OF STATS
	
	public void setStats(Stat stats) {
		this.stats = stats;
	}
	
	public void setDamage(int damage) {
		this.stats.setStat(Stat.DAMAGE, damage);
	}
	public void setAttack(int attack) {
		this.stats.setStat(Stat.ATTACK, attack);
	}
	public void setCriticalChance(int critical_chance) {
		this.stats.setStat(Stat.CRITICAL_CHANCE, critical_chance);
	}
	public void setCriticalDamage(int critical_damage) {
		this.stats.setStat(Stat.CRITICAL_DAMAGE, critical_damage);
	}
	public void setHealth(int health) {
		this.stats.setStat(Stat.HEALTH, health);
	}
	public void setDefense(int defense) {
		this.stats.setStat(Stat.DEFENSE, defense);
	}
	public void setSpeed(int speed) {
		this.stats.setStat(Stat.SPEED, speed);
	}
	public void setSolaris(int solaris) {
		this.stats.setStat(Stat.SOLARIS, solaris);
	}
	
	// END FO SETTERS OF STATS
	
	//UPDATERS
	
	public void updateLore() {
		meta = itemStack.getItemMeta();
		String loreString = getEmojiRarity() + rarity.toString()  + " " + type.toString() + getEmojiRarity()
		+ "\n\n§r§dSCORE: " + getItemScore() + "§r\n"
		+ getStatsAsLore() + "\n\n" + itemEffectsDesc + "\n\n" + itemDesc;
		
		List<String> lore = Arrays.asList(loreString.split("\n"));
		meta.setLore(lore);
		
		itemStack.setItemMeta(meta);
		
	}
	
	public void updateName() {
		meta = itemStack.getItemMeta();
		String emoji = getEmojiRarity();
		meta.setDisplayName(emoji + name + emoji);
		itemStack.setItemMeta(meta);
		
	}
	
	//INIT
	public void init() {
		
		meta = itemStack.getItemMeta();
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		meta.addItemFlags(ItemFlag.HIDE_DYE);
		
		itemStack.setItemMeta(meta);
		
		updateName();
		updateLore();
	}
	
	
	//GETTERS
	public ItemStack getItemStack() {
		return this.itemStack;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Stat getStats() {
		return this.stats;
	}
	
	// PRIVATE
	private String getEmojiRarity() {
		/*
		 * Get the emoji for the rarity colored in the rarity color
		 */
		switch(rarity) {
		default:
			return "";
		case TRASH:
			return "§8§l🗑";
		case COMMON:
			return "§f§l";
		case UNCOMMON:
			return "§a§l";
		case RARE:
			return "§9§l";
		case EPIC:
			return "§5§l";
		case LEGENDARY:
			return "§6§l✨";
		case MYTHIC:
			return "§d§l💎";
		case DIVINE:
			return "§4§l🔆";
		}
	}
	
	private int getItemScore() {
		return -1;
	}
	
	private String getStatsAsLore() {
		String statsString = "§7Stats:\n";
		if(stats.getStat(Stat.DAMAGE) > 0) {
			statsString += "§7  Damage: §c" + stats.getStat(Stat.DAMAGE) + "\n";
		}
		if(stats.getStat(Stat.ATTACK) > 0) {
			statsString += "§7  Attack: §c" + stats.getStat(Stat.ATTACK) + "\n";
		}
		if(stats.getStat(Stat.CRITICAL_CHANCE) > 0) {
			statsString += "§1  Critical Chance: §3" + stats.getStat(Stat.CRITICAL_CHANCE) + "\n";
		}
		if(stats.getStat(Stat.CRITICAL_DAMAGE) > 0) {
			statsString += "§1  Critical Damage: §3" + stats.getStat(Stat.CRITICAL_DAMAGE) + "\n";
		}
		if(stats.getStat(Stat.HEALTH) > 0) {
			statsString += "§2  Health: §a" + stats.getStat(Stat.HEALTH) + "\n";
		}
		if(stats.getStat(Stat.DEFENSE) > 0) {
			statsString += "§2  Defense: §a" + stats.getStat(Stat.DEFENSE) + "\n";
		}
		if(stats.getStat(Stat.SPEED) > 0) {
			statsString += "§e  Speed: §f" + stats.getStat(Stat.SPEED) + "\n";
		}
		if(stats.getStat(Stat.SOLARIS) > 0) {
			statsString += "§b  Solaris: §5" + stats.getStat(Stat.SOLARIS) + "\n";
		}
		return statsString;
	}
}
