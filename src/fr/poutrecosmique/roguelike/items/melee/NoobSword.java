package fr.poutrecosmique.roguelike.items.melee;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import fr.poutrecosmique.roguelike.items.ItemIdentifier;
import fr.poutrecosmique.roguelike.items.ItemObject;
import fr.poutrecosmique.roguelike.items.ItemRarity;
import fr.poutrecosmique.roguelike.items.ItemType;

public class NoobSword extends ItemObject{
	
	public NoobSword() {
		super();
		this.setIdentifier(ItemIdentifier.NOOB_SWORD);
		this.setName("Noob Sword");
		this.setItemStack(new ItemStack(Material.WOODEN_SWORD));
		this.setRarity(ItemRarity.COMMON);
		this.setType(ItemType.MELEE);
		this.setDamage(10);
		this.setItemDesc("§fRien de particulier.");
		this.init();
	}
	
	public ItemStack getItem() {
		return this.getItemStack();
	}

}
