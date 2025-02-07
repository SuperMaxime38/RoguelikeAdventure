package fr.poutrecosmique.roguelike.items.armor.noob_set;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import fr.poutrecosmique.roguelike.items.ItemRarity;
import fr.poutrecosmique.roguelike.items.ItemType;
import fr.poutrecosmique.roguelike.utils.Pair;
import fr.poutrecosmique.roguelike.utils.Stat;

public class NoobHelmet extends NoobSet {
	
	public NoobHelmet() {
		super();
		this.setName("Noob Helmet");
		this.setType(ItemType.HELMET);
		this.setItemStack(new ItemStack(Material.LEATHER_HELMET));
		this.setRarity(ItemRarity.COMMON);
		
		//Stats
		this.setStats(new Stat(Arrays.asList(
				new Pair(Stat.HEALTH, 15),
				new Pair(Stat.DEFENSE, 5),
				new Pair(Stat.SOLARIS, 5)
				)));
		
		this.setItemDesc("§fRien de particulier.");
		this.init();
	}
	
	public ItemStack getItem() {
		return this.getItemStack();
	}
}
