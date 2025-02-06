package fr.poutrecosmique.roguelike.items.melee;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import fr.poutrecosmique.roguelike.items.ItemIdentifier;
import fr.poutrecosmique.roguelike.items.ItemObject;
import fr.poutrecosmique.roguelike.items.ItemRarity;
import fr.poutrecosmique.roguelike.items.ItemType;

public class NoobSword extends ItemObject{
	
	public static ItemObject sword;
	
	public NoobSword() {
		sword = new ItemObject();
		sword.setIdentifier(ItemIdentifier.NOOB_SWORD);
		sword.setName("Noob Sword");
		sword.setItemStack(new ItemStack(Material.WOODEN_SWORD));
		sword.setRarity(ItemRarity.COMMON);
		sword.setType(ItemType.MELEE);
		sword.setDamage(10);
		sword.setItemDesc("§fRien de particulier.");
		sword.init();
	}
	
	public ItemStack getItem() {
		return sword.getItemStack();
	}

}
