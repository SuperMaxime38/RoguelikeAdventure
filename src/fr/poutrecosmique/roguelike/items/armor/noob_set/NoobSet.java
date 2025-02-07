package fr.poutrecosmique.roguelike.items.armor.noob_set;

import java.util.Arrays;

import fr.poutrecosmique.roguelike.items.ItemEffect;
import fr.poutrecosmique.roguelike.items.ItemEffectIdentifier;
import fr.poutrecosmique.roguelike.items.ItemEffectType;
import fr.poutrecosmique.roguelike.items.ItemObject;
import fr.poutrecosmique.roguelike.utils.Pair;
import fr.poutrecosmique.roguelike.utils.Stat;

public class NoobSet extends ItemObject{
	
	protected ItemEffect effects;

	public NoobSet() {
		
		Stat stats = new Stat(
			Arrays.asList(new Pair(Stat.SPEED, 10))
		);
		
		this.effects = new ItemEffect(ItemEffectIdentifier.NEW_BLOOD, ItemEffectType.IDLE, stats);
	}

}
