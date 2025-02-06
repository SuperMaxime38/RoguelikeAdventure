package fr.poutrecosmique.roguelike.items;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
	protected int damage = 0;
	protected int attack = 0;
	protected int critical_chance = 0;
	protected int critical_damage = 0;
	protected int health = 0;
	protected int defense = 0;
	protected int speed = 0;
	protected int solaris = 0;
	
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
		this.itemStack = item;
	}
	
	public void setMaterial(Material mat) {
		this.itemStack.setType(mat);
	}
	
	//SETTERS OF STATS
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setCriticalChance(int critical_chance) {
		this.critical_chance = critical_chance;
	}
	public void setCriticalDamage(int critical_damage) {
		this.critical_damage = critical_damage;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setSolaris(int solaris) {
		this.solaris = solaris;
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
		String stats = "§7Stats:\n";
		if(damage > 0) {
			stats += "§7  Damage: §c" + damage + "\n";
		}
		if(attack > 0) {
			stats += "§7  Attack: §c" + attack + "\n";
		}
		if(critical_chance > 0) {
			stats += "§1  Critical Chance: §3" + critical_chance + "\n";
		}
		if(critical_damage > 0) {
			stats += "§1  Critical Damage: §3" + critical_damage + "\n";
		}
		if(health > 0) {
			stats += "§2  Health: §a" + health + "\n";
		}
		if(defense > 0) {
			stats += "§2  Defense: §a" + defense + "\n";
		}
		if(speed > 0) {
			stats += "§e  Speed: §f" + speed + "\n";
		}
		if(solaris > 0) {
			stats += "§b  Solaris: §5" + solaris + "\n";
		}
		return stats;
	}
}
